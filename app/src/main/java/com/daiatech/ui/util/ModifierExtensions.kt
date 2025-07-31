package com.daiatech.app.ui.util

import androidx.compose.foundation.gestures.GestureCancellationException
import androidx.compose.foundation.gestures.PressGestureScope
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.AwaitPointerEventScope
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.changedToUp
import androidx.compose.ui.input.pointer.isOutOfBounds
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.unit.Density
import androidx.compose.ui.util.fastAll
import androidx.compose.ui.util.fastAny
import com.daiatech.analytics.ui.LocalAnalyticsHelper
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex

private val ModifierScreenName = modifierLocalOf<String?> { null }

/**
 * Extension function to add analytics screen name to a Modifier.
 *
 * @param screenName The name of the screen to be logged.
 * @return The modified Modifier with analytics screen name.
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Modifier.analyticsScreenName(screenName: String): Modifier {
    val analyticsHelper = LocalAnalyticsHelper.current
    LaunchedEffect(screenName) {
        analyticsHelper.screenViewEvent(screenName)
    }
    return this.then(Modifier.modifierLocalProvider(ModifierScreenName) { screenName })
}

/**
 * Extension function to add analytics event logging for tap gestures to a Modifier.
 *
 * @param buttonName The name of the button to be logged.
 * @return The modified Modifier with tap gesture analytics event logging.
 *
 * The BUTTON_ID is constructed using the following format:
 * button_screenName_buttonName
 * Where:
 *
 * button is a constant prefix to identify this as a button ID
 * screenName is the name of the screen where the button is located
 * buttonName is the unique identifier for the button
 *
 * For example, if a "Submit" button is clicked on the "UserProfile" screen, the BUTTON_ID would be:
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Modifier.onTapAnalyticsEvent(buttonName: String): Modifier {
    val analyticsHelper = LocalAnalyticsHelper.current
    var screenName by remember { mutableStateOf<String?>(null) }

    return this
        .modifierLocalConsumer { screenName = ModifierScreenName.current }
        .pointerInput(Unit) {
            detectConsumedTaps {
                analyticsHelper.clickEvent(buttonName, screenName ?: "unknown")
            }
        }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Modifier.onBackButtonClick(buttonName: String): Modifier {
    val analyticsHelper = LocalAnalyticsHelper.current
    var screenName by remember { mutableStateOf<String?>(null) }

    return this
        .modifierLocalConsumer { screenName = ModifierScreenName.current }
        .pointerInput(Unit) {
            detectConsumedTaps {
                analyticsHelper.backButtonClick(buttonName, screenName ?: "unknown")
            }
        }
}

/**
 * Detects tap gestures that have already been consumed.
 *
 * @param onTap Callback to be invoked when a tap gesture is detected.
 */
suspend fun PointerInputScope.detectConsumedTaps(
    onTap: ((Offset) -> Unit)? = null
) {
    val pressScope = PressGestureScopeImpl(this)
    coroutineScope {
        awaitEachGesture {
            launch { pressScope.reset() }

            awaitFirstDown(requireUnconsumed = false, pass = PointerEventPass.Final).also { it.consume() }

            val up = waitForUpOrCancellationInitial()
            if (up == null) {
                launch { pressScope.cancel() } // tap-up was canceled
            } else {
                launch { pressScope.release() }
                onTap?.invoke(up.position)
            }
        }
    }
}

/**
 * Waits for the up event or cancellation of the initial pointer event.
 *
 * @return The PointerInputChange if the up event is detected, null if canceled.
 */
suspend fun AwaitPointerEventScope.waitForUpOrCancellationInitial(): PointerInputChange? {
    while (true) {
        val event = awaitPointerEvent(PointerEventPass.Initial)
        if (event.changes.fastAll { it.changedToUp() }) {
            // All pointers are up
            return event.changes[0]
        }

        if (event.changes.fastAny { it.isConsumed || it.isOutOfBounds(size, extendedTouchPadding) }) {
            return null // Canceled
        }

        // Check for cancel by position consumption. We can look on the Final pass of the
        // existing pointer event because it comes after the Initial pass we checked above.
        val consumeCheck = awaitPointerEvent(PointerEventPass.Final)
        if (consumeCheck.changes.fastAny { it.isConsumed }) {
            return null
        }
    }
}

/**
 * Implementation of PressGestureScope to handle press gestures.
 *
 * @param density The density of the screen.
 */
private class PressGestureScopeImpl(
    density: Density
) : PressGestureScope, Density by density {

    private var isReleased = false
    private var isCanceled = false
    private val mutex = Mutex(locked = false)

    /**
     * Called when a gesture has been canceled.
     */
    fun cancel() {
        isCanceled = true
        mutex.unlock()
    }

    /**
     * Called when all pointers are up.
     */
    fun release() {
        isReleased = true
        mutex.unlock()
    }

    /**
     * Called when a new gesture has started.
     */
    suspend fun reset() {
        mutex.lock()
        isReleased = false
        isCanceled = false
    }

    /**
     * Awaits the release of the press gesture.
     *
     * @throws GestureCancellationException if the gesture was canceled.
     */
    override suspend fun awaitRelease() {
        if (!tryAwaitRelease()) {
            throw GestureCancellationException("The press gesture was canceled.")
        }
    }

    /**
     * Tries to await the release of the press gesture.
     *
     * @return True if the gesture was released, false if it was canceled.
     */
    override suspend fun tryAwaitRelease(): Boolean {
        if (!isReleased && !isCanceled) {
            mutex.lock()
            mutex.unlock()
        }
        return isReleased
    }
}
