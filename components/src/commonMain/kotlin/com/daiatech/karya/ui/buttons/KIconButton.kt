package com.daiatech.karya.ui.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.IconButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.daiatech.app.ui.components.buttons.KButtonLayout
import com.daiatech.karya.ui.theme.KaryaTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun KIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(8.dp),
    colors: IconButtonColors? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    buttonVariation: ButtonVariation = ButtonVariation.TertiaryButtonRegular,
    content: @Composable () -> Unit,
) {
    KButtonLayout(
        modifier = modifier.width(buttonVariation.buttonSize.value),
        leftIcon = {
            Box(
                modifier = Modifier.size(24.dp),
                contentAlignment = Alignment.Center,
            ) {
                content()
            }
        },
        buttonVariation = buttonVariation,
        isEnabled = enabled,
        onClick = onClick,
        interactionSource = interactionSource,
        contentPaddingValues = PaddingValues(0.dp),
    )
}

@Preview
@Composable
fun KIconButtonPrev() {
    KaryaTheme {
        Column {
            KIconButton(buttonVariation = ButtonVariation.IconPrimaryButtonRegular, onClick = { }) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
            KIconButton(onClick = { }, enabled = false, buttonVariation = ButtonVariation.IconPrimaryButtonRegular) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
        }
    }
}

@Preview
@Composable
fun KIconButtonPrev1() {
    KaryaTheme {
        Column {
            KIconButton(buttonVariation = ButtonVariation.IconSecondaryButtonRegular, onClick = { }) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
            KIconButton(onClick = { }, enabled = false, buttonVariation = ButtonVariation.IconSecondaryButtonRegular) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
        }
    }
}

@Preview
@Composable
fun KIconButtonPrev2() {
    KaryaTheme {
        Column {
            KIconButton(buttonVariation = ButtonVariation.IconErrorButtonRegular, onClick = { }) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
            KIconButton(onClick = { }, enabled = false, buttonVariation = ButtonVariation.IconErrorButtonRegular) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
        }
    }
}

@Preview
@Composable
fun KIconButtonPrev3() {
    KaryaTheme {
        Column {
            KIconButton(buttonVariation = ButtonVariation.IconTertiaryButtonRegular, onClick = { }) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
            KIconButton(onClick = { }, enabled = false, buttonVariation = ButtonVariation.IconTertiaryButtonRegular) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
        }
    }
}

@Preview
@Composable
fun KIconButtonSmallPrev() {
    KaryaTheme {
        Column {
            KIconButton(buttonVariation = ButtonVariation.IconPrimaryButtonSmall, onClick = { }) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
            KIconButton(onClick = { }, enabled = false, buttonVariation = ButtonVariation.IconPrimaryButtonSmall) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
        }
    }
}

@Preview
@Composable
fun KIconButtonSmallPrev1() {
    KaryaTheme {
        Column {
            KIconButton(buttonVariation = ButtonVariation.IconSecondaryButtonSmall, onClick = { }) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
            KIconButton(onClick = { }, enabled = false, buttonVariation = ButtonVariation.IconSecondaryButtonSmall) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
        }
    }
}

@Preview
@Composable
fun KIconButtonSmallPrev2() {
    KaryaTheme {
        Column {
            KIconButton(buttonVariation = ButtonVariation.IconErrorButtonSmall, onClick = { }) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
            KIconButton(onClick = { }, enabled = false, buttonVariation = ButtonVariation.IconErrorButtonSmall) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
        }
    }
}

@Preview
@Composable
fun KIconButtonSmallPrev3() {
    KaryaTheme {
        Column {
            KIconButton(buttonVariation = ButtonVariation.IconTertiaryButtonSmall, onClick = { }) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
            KIconButton(onClick = { }, enabled = false, buttonVariation = ButtonVariation.IconTertiaryButtonSmall) {
                Image(imageVector = Icons.Default.Person, contentDescription = null)
            }
        }
    }
}
