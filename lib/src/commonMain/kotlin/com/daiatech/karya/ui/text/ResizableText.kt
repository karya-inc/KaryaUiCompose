package com.daiatech.karya.ui.text

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.unit.dp
import com.daiatech.karya.ui.spacers.VerticalSpacer
import com.daiatech.karya.ui.theme.KaryaTheme
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ResizableText(
    modifier: Modifier = Modifier,
    text: String
) {
    val textStyleBody1 = MaterialTheme.typography.bodyMedium
    var textStyle by remember { mutableStateOf(textStyleBody1) }
    var readyToDraw by remember { mutableStateOf(false) }
    Text(
        text = text,
        style = textStyle,
        maxLines = 1,
        softWrap = false,
        modifier = modifier.drawWithContent {
            if (readyToDraw) drawContent()
        },
        onTextLayout = { textLayoutResult ->
            if (textLayoutResult.didOverflowWidth) {
                textStyle = textStyle.copy(fontSize = textStyle.fontSize * 0.9)
            } else {
                readyToDraw = true
            }
        }
    )
}

@Preview
@Composable
fun ResizableTextPreview() {
    // TODO: Add a resizable box
    var containerSize by remember { mutableStateOf(1F) }
    Column(Modifier.padding(16.dp)) {
        Box(
            modifier = Modifier.fillMaxWidth(containerSize)
                .border(1.dp, KaryaTheme.colorScheme.primary50)
                .padding(4.dp)
        ) {
            ResizableText(text = "This is a very long long long long long long and more long text more long it is")
        }
        VerticalSpacer()
        Text("Change container size")
        Slider(
            value = containerSize,
            onValueChange = { containerSize = it },
            colors = SliderDefaults.colors(
                thumbColor = KaryaTheme.colorScheme.primary50,
                activeTrackColor = KaryaTheme.colorScheme.primary50,
                inactiveTrackColor = KaryaTheme.colorScheme.primary95
            )
        )
    }
}
