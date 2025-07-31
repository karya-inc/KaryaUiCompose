/** Copyright (c) 2023 DAIA Tech Pvt Ltd */

package com.daiatech.ui.components.appbars

import android.app.Activity
import android.net.Uri
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.daiatech.app.ui.components.spacers.HorizontalSpacer
import com.daiatech.ui.R
import com.daiatech.ui.theme.Dimens
import com.daiatech.ui.theme.UITheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.KaryaTopAppBar(
    menuContent: (@Composable () -> Unit) = { MenuContent() },
    onAssistantClicked: (screenshotUri: Uri?) -> Unit,
    enableHelp: Boolean = true,
    spotlightKey: String = "helpButton",
    spotlightController: Any? = null,
    spotlightMessages: List<Any>? = null,
    spotlightTooltipMaxWidth: Dp = 200.dp,
    disableTouchWhenSpotlighted: Boolean = false,
    animatedContentScope: AnimatedContentScope,
    onSpotlightFinish: () -> Unit = {},
    title: @Composable () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val view = LocalView.current
    val context = LocalContext.current
    val takeScreenshot = {
        coroutineScope.launch {
            val window = (view.context as Activity).window
            val fileContainer = (context.filesDir.path.plus("/screenshots-container"))
            val filesUri = saveViewAsBitmap(fileContainer, view, window)
            onAssistantClicked(filesUri)
        }
    }

    KaryaTopAppBarImpl(
        menuContent = menuContent,
        onAssistantClicked = { takeScreenshot() },
        enableHelp = enableHelp,
        title = title,
        spotlightKey = spotlightKey,
        spotlightController = spotlightController,
        spotlightMessages = spotlightMessages,
        spotlightTooltipMaxWidth = spotlightTooltipMaxWidth,
        disableTouchWhenSpotlighted = disableTouchWhenSpotlighted,
        sharedTransitionScope = this,
        animatedContentScope = animatedContentScope,
        onSpotlightFinish = onSpotlightFinish
    )
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun KaryaTopAppBarImpl(
    menuContent: (@Composable () -> Unit) = { MenuContent() },
    onAssistantClicked: () -> Unit,
    enableHelp: Boolean,
    spotlightKey: String,
    spotlightController: Any? = null,
    spotlightMessages: List<Any>? = null,
    disableTouchWhenSpotlighted: Boolean = false,
    spotlightTooltipMaxWidth: Dp,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    onSpotlightFinish: () -> Unit = {},
    title: @Composable () -> Unit
) {
    with(sharedTransitionScope) {
        Surface(
            color = MaterialTheme.colorScheme.inverseSurface,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimens.S),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                menuContent()
                title()
//                spotlightController?.let {
//                    val isAvatarSpeaking by spotlightController.isAudioPlaying().collectAsStateWithLifecycle(false)
//                    SpotlightZone(
//                        key = spotlightKey,
//                        controller = it,
//                        messages = spotlightMessages,
//                        onFinish = onSpotlightFinish,
//                        toolTipMaxWidth = spotlightTooltipMaxWidth,
//                        tooltipPosition = TooltipPosition.BOTTOM,
//                        disableTouch = disableTouchWhenSpotlighted
//                    ) {
//                        Box(
//                            Modifier.sharedElement(
//                                rememberSharedContentState("avatar"),
//                                animatedContentScope
//                            )
//                        ) {
//                            SpeakingHelpButton(
//                                isSpeaking = isAvatarSpeaking,
//                                onClick = onAssistantClicked,
//                                enabled = enableHelp
//                            )
//                        }
//                    }
//                } ?: Box(
//                    Modifier.sharedElement(
//                        rememberSharedContentState("avatar"),
//                        animatedContentScope
//                    )
//                ) {
//                    HelpButton(
//                        onClick = onAssistantClicked,
//                        enabled = enableHelp
//                    )
//                }
            }
        }
    }
}

@Composable
fun MenuContent() {
    Image(
        painter = painterResource(id = R.drawable.karya_logo),
        contentDescription = stringResource(id = R.string.back),
        modifier = Modifier
            .size(Dimens.XL),
        contentScale = ContentScale.FillHeight
    )
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Preview
@Composable
fun KaryaTopAppBarPrev() {
    UITheme {
        Surface {
            SharedTransitionLayout {
                AnimatedContent(true) {
                    if (it) {
                        KaryaTopAppBarImpl(
                            onAssistantClicked = {},
                            enableHelp = true,
                            sharedTransitionScope = this@SharedTransitionLayout,
                            animatedContentScope = this,
                            spotlightKey = "helpButton",
                            spotlightTooltipMaxWidth = 200.dp
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                HorizontalSpacer(Dimens.S)
                                Text("Connected")
                            }
                        }
                    }
                }
            }
        }
    }
}
