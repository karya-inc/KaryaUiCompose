/** Copyright (c) 2023 DAIA Tech Pvt Ltd */

package com.daiatech.ui.components.appbars

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.daiatech.app.ui.util.onTapAnalyticsEvent
import com.daiatech.ui.R
import com.daiatech.ui.theme.UITheme

@Composable
fun HelpButton(enabled: Boolean = true, onClick: () -> Unit) {
    val alpha = if (enabled) 1f else 0f
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .alpha(alpha)
            .size(56.dp)
            .onTapAnalyticsEvent("help"),
        enabled = enabled
    ) {
        Image(
            painter = painterResource(id = R.drawable.help_avatar),
            contentDescription = stringResource(id = R.string.help)
        )
    }
}

@Composable
fun SpeakingHelpButton(enabled: Boolean = true, isSpeaking: Boolean = false, onClick: () -> Unit) {
    AnimatedContent(isSpeaking) { targetState ->
        SpeakingHelpButtonImpl(enabled, targetState, onClick)
    }
}

@Composable
fun SpeakingHelpButtonImpl(enabled: Boolean = true, isSpeaking: Boolean, onClick: () -> Unit) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.avatar_speaking))

    if (isSpeaking) {
        LottieAnimation(
            modifier = Modifier.size(64.dp),
            composition = composition,
            iterations = LottieConstants.IterateForever
        )
    } else {
        HelpButton(enabled, onClick)
    }
}

@Preview
@Composable
fun HelpButtonPrev() {
    UITheme {
        Column {
            HelpButton(enabled = true) {}
        }
    }
}

@Preview
@Composable
fun SpeakingHelpButtonPrev1() {
    UITheme {
        Column {
            SpeakingHelpButtonImpl(isSpeaking = true, onClick = {})
        }
    }
}

@Preview
@Composable
fun SpeakingHelpButtonPrev2() {
    UITheme {
        Column {
            SpeakingHelpButtonImpl(isSpeaking = false, onClick = {})
        }
    }
}
