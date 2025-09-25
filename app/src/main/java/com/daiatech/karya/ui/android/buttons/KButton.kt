package com.daiatech.karya.ui.android.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daiatech.karya.ui.buttons.ButtonVariation
import com.daiatech.karya.ui.buttons.KButton

@Preview
@Composable
private fun KButtonEnablePrev() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier =
            Modifier
                .background(Color.White)
                .padding(8.dp),
    ) {
        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.PrimaryButtonRegular,
            isEnabled = true,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.PrimaryButtonSmall,
            isEnabled = true,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.SecondaryButtonSmall,
            isEnabled = true,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.SecondaryButtonRegular,
            isEnabled = true,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.ErrorButtonSmall,
            isEnabled = true,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.ErrorButtonRegular,
            isEnabled = true,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.TertiaryButtonRegular,
            isEnabled = true,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.AccentOutlineRegular,
            isEnabled = true,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.AccentFillRegular,
            isEnabled = true,
            onClick = {},
        )
    }
}

@Preview
@Composable
private fun KButtonDisablePrev() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier =
            Modifier
                .background(Color.White)
                .padding(8.dp),
    ) {
        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.PrimaryButtonRegular,
            isEnabled = false,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.PrimaryButtonSmall,
            isEnabled = false,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.SecondaryButtonSmall,
            isEnabled = false,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.SecondaryButtonRegular,
            isEnabled = false,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.ErrorButtonSmall,
            isEnabled = false,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.ErrorButtonRegular,
            isEnabled = false,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.TertiaryButtonRegular,
            isEnabled = false,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.AccentOutlineRegular,
            isEnabled = false,
            onClick = {},
        )

        KButton(
            content = "Click Here",
            leftIcon = rememberVectorPainter(Icons.Default.Info),
            rightIcon = rememberVectorPainter(Icons.Default.Info),
            buttonVariation = ButtonVariation.AccentFillRegular,
            isEnabled = false,
            onClick = {},
        )
    }
}
