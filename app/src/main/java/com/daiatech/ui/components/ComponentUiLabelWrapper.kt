package com.daiatech.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daiatech.app.ui.components.message.AudioMessage
import com.daiatech.app.ui.components.message.models.MessageVariant
import com.daiatech.ui.theme.UITheme

@Composable
fun ComponentUiLabelWrapper(
    modifier: Modifier = Modifier,
    referenceMessage: String = "Reference Audio: ",
    variant: MessageVariant,
    content: @Composable () -> Unit
) {
    Column(
        modifier
            .clip(variant.shape)
            .border(2.dp, variant.color.containerColorVariant, variant.shape)
            .background(variant.color.containerColor)
    ) {
        Text(
            text = referenceMessage,
            modifier = Modifier.padding(8.dp)
        )
        content()
    }
}

@Preview
@Composable
private fun ReferencePlatformAudioComponentWrapperPrev(modifier: Modifier = Modifier) {
    UITheme {
        Surface {
            ComponentUiLabelWrapper(
                modifier = Modifier.padding(16.dp),
                variant = MessageVariant.Platform.Reference
            ) {
                AudioMessage(
                    isPlaying = false,
                    currentPosition = 10000,
                    durationMS = 20000,
                    showAmplitudes = false,
                    amplitudes = listOf(),
                    onPlay = {},
                    onPause = {},
                    variant = MessageVariant.Platform.Reference,
                    onSeek = {}
                )
            }
        }
    }
}
