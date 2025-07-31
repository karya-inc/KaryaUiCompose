/** Copyright (c) 2023 DAIA Tech Pvt Ltd */

package com.daiatech.ui.components.appbars

import android.app.Activity
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.daiatech.ui.R
import com.daiatech.ui.theme.Dimens
import com.daiatech.ui.theme.UITheme
import kotlinx.coroutines.launch

@Composable
fun KaryaNavigationAppBar(
    title: @Composable RowScope.() -> Unit,
    onNavigateBack: () -> Unit,
    enableHelp: Boolean = true,
    spotlightKey: String = "helpButton",
    spotlightController: Any? = null,
    spotlightMessages: List<Any>? = null,
    spotlightTooltipMaxWidth: Dp = 200.dp,
    disableTouchWhenSpotlighted: Boolean = false,
    onSpotlightFinish: () -> Unit = {},
    onAssistantClicked: (Uri?) -> Unit
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
    KaryaNavigationAppBarImpl(
        title = title,
        onNavigateBack = onNavigateBack,
        enableHelp = enableHelp,
        onAssistantClicked = { takeScreenshot() },
        spotlightKey = spotlightKey,
        spotlightController = spotlightController,
        spotlightMessages = spotlightMessages,
        spotlightTooltipMaxWidth = spotlightTooltipMaxWidth,
        disableTouchWhenSpotlighted = disableTouchWhenSpotlighted,
        onSpotlightFinish = onSpotlightFinish
    )
}

@Composable
fun KaryaNavigationAppBarImpl(
    title: @Composable RowScope.() -> Unit,
    onNavigateBack: () -> Unit,
    enableHelp: Boolean,
    onAssistantClicked: () -> Unit,
    spotlightKey: String,
    spotlightController: Any? = null,
    spotlightMessages: List<Any>? = null,
    spotlightTooltipMaxWidth: Dp,
    disableTouchWhenSpotlighted: Boolean,
    onSpotlightFinish: () -> Unit = {}
) {
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
            IconButton(onClick = onNavigateBack) {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = stringResource(id = R.string.back),
                    Modifier.size(Dimens.XXL)
                )
            }
            Row { title() }
//            spotlightController?.let {
//                val isAvatarSpeaking by spotlightController.isAudioPlaying().collectAsStateWithLifecycle(false)
//                SpotlightZone(
//                    key = spotlightKey,
//                    controller = it,
//                    messages = spotlightMessages,
//                    onFinish = onSpotlightFinish,
//                    toolTipMaxWidth = spotlightTooltipMaxWidth,
//                    tooltipPosition = TooltipPosition.BOTTOM,
//                    disableTouch = disableTouchWhenSpotlighted
//                ) {
//                    SpeakingHelpButton(
//                        isSpeaking = isAvatarSpeaking,
//                        onClick = onAssistantClicked,
//                        enabled = enableHelp
//                    )
//                }
//            } ?: HelpButton(
//                onClick = onAssistantClicked,
//                enabled = enableHelp
//            )
        }
    }
}

@Preview
@Composable
fun KaryaNavigationAppBarPrev() {
    UITheme {
        KaryaNavigationAppBarImpl(
            title = {
                Image(
                    painter = painterResource(id = R.drawable.ic_settings),
                    contentDescription = "Welcome to Karya"
                )
                Text(text = "Welcome to Karya")
            },
            onNavigateBack = { /*TODO*/ },
            enableHelp = true,
            onAssistantClicked = { /*TODO*/ },
            spotlightKey = "helpButton",
            spotlightController = null,
            spotlightMessages = null,
            spotlightTooltipMaxWidth = 200.dp,
            disableTouchWhenSpotlighted = false
        ) {
        }
    }
}
