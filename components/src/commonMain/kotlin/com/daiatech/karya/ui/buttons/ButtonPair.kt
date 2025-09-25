package com.daiatech.karya.ui.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.daiatech.karya.ui.spacers.VerticalSpacer
import com.daiatech.karya.ui.theme.KaryaTheme
import com.daiatech.karya.ui.theme.backgroundDark
import com.daiatech.karya.ui.theme.errorColor
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ButtonPair(
    modifier: Modifier = Modifier,
    positiveText: String,
    onPositive: () -> Unit,
    positiveEnabled: Boolean,
    positiveIcon: Painter,
    negativeText: String,
    onNegative: () -> Unit,
    negativeEnabled: Boolean,
    negativeIcon: Painter,
    error: String? = null,
    onErrorUpdate: (String?) -> Unit = {},
    actionButton: (@Composable () -> Unit)? = null,
) {
    Column(
        modifier
            .fillMaxWidth()
            .background(backgroundDark)
            .padding(Dimens.S),
    ) {
        error?.let {
            Text(text = error, color = errorColor, style = MaterialTheme.typography.labelSmall)
        }
        VerticalSpacer(8.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            actionButton?.let { it() }
            KButton(
                modifier = Modifier.weight(1f),
                content = negativeText,
                leftIcon = negativeIcon,
                buttonVariation = ButtonVariation.ErrorButtonRegular,
                isEnabled = negativeEnabled,
                onClick = {
                    onErrorUpdate(null)
                    onNegative()
                },
            )

            KButton(
                modifier = Modifier.weight(1f),
                content = positiveText,
                rightIcon = positiveIcon,
                buttonVariation = ButtonVariation.PrimaryButtonRegular,
                isEnabled = positiveEnabled,
                onClick = {
                    onErrorUpdate(null)
                    onPositive()
                },
            )
        }
    }
}

@Preview
@Composable
fun ResponsePairButtonPrev() {
    KaryaTheme {
        Column(Modifier.padding(16.dp)) {
            ButtonPair(
                positiveText = "Accept",
                onPositive = { },
                positiveEnabled = true,
                negativeText = "Reject",
                onNegative = { },
                negativeEnabled = true,
                positiveIcon = rememberVectorPainter(Icons.Default.AccountTree),
                negativeIcon = rememberVectorPainter(Icons.Default.AccountTree),
            )
        }
    }
}

@Preview
@Composable
fun ResponsePairButtonPrev1() {
    KaryaTheme {
        Column(Modifier.padding(16.dp)) {
            ButtonPair(
                positiveText = "Accept",
                onPositive = { },
                positiveEnabled = true,
                negativeText = "Reject",
                onNegative = { },
                negativeEnabled = true,
                positiveIcon = rememberVectorPainter(Icons.Default.AccountTree),
                negativeIcon = rememberVectorPainter(Icons.Default.AccountTree),
                error = "This is an error message",
            )
        }
    }
}
