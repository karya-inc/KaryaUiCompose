package com.daiatech.karya.ui.chips

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.daiatech.karya.ui.theme.KaryaTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

data class KChipColors(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color
)

val defaultKChipColors
    @Composable get() = KChipColors(
        containerColor = KaryaTheme.colorScheme.tertiary95,
        contentColor = KaryaTheme.colorScheme.tertiary40,
        disabledContainerColor = KaryaTheme.colorScheme.tertiary95.copy(alpha = 0.1f),
        disabledContentColor = KaryaTheme.colorScheme.tertiary40.copy(alpha = 0.4f)
    )

enum class BorderStyle {
    SOLID, NONE
}

@Composable
fun KChip(
    text: String,
    enabled: Boolean = true,
    colors: KChipColors = defaultKChipColors,
    borderStyle: BorderStyle = BorderStyle.SOLID,
    leadingPainter: Painter? = null,
    trailingPainter: Painter? = null,
    shape: Shape = CircleShape
) {
    KChip(
        content = {
            Text(
                text = text,
                style = KaryaTheme.typography.labelMedium
            )
                  },
        enabled = enabled,
        colors = colors,
        borderStyle = borderStyle,
        leadingIcon = leadingPainter?.let {
            {
                Icon(
                    painter = leadingPainter,
                    contentDescription = text,
                    modifier = Modifier.size(KaryaTheme.dimens.m)
                )
            }
        },
        trailingIcon = trailingPainter?.let {
            {
                Icon(
                    painter = trailingPainter,
                    contentDescription = text
                )
            }
        },
        shape = shape
    )
}

@Composable
fun KChip(
    content: @Composable () -> Unit,
    enabled: Boolean = true,
    colors: KChipColors = defaultKChipColors,
    borderStyle: BorderStyle = BorderStyle.SOLID,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    shape: Shape = CircleShape
) {
    val contentColor = remember(colors, enabled) {
        if (enabled) colors.contentColor else colors.disabledContentColor
    }
    val containerColor = remember(colors, enabled) {
        if (enabled) colors.containerColor else colors.disabledContainerColor
    }
    val borderColor = remember (colors, enabled){
        if (enabled) contentColor else contentColor.copy(alpha = 0.4f)
    }
    Row(
        modifier = Modifier
            .height(KaryaTheme.dimens.m + KaryaTheme.dimens.xs)
            .chipBorder(1.dp, borderColor, shape, borderStyle)
            .background(containerColor, shape)
            .padding(
                vertical = KaryaTheme.dimens.xs,
                horizontal = KaryaTheme.dimens.s
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(KaryaTheme.dimens.xs)
    ) {
        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            LocalTextStyle provides KaryaTheme.typography.labelMedium
        ) {
            leadingIcon?.invoke()
            content()
            trailingIcon?.invoke()
        }
    }
}

private fun Modifier.chipBorder(
    width: Dp,
    color: Color,
    shape: Shape,
    style: BorderStyle
) = this.then(
    when (style) {
        BorderStyle.SOLID -> Modifier.border(width, color, shape)
        BorderStyle.NONE -> Modifier
    }
)

@Preview()
@Composable
fun KChipPreview() {
    KaryaTheme {
        Surface {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                KChip(text = "New Task")
                KChip(
                    text = "New Task",
                    borderStyle = BorderStyle.NONE,
                    trailingPainter = rememberVectorPainter(Icons.AutoMirrored.Filled.List)
                )
                KChip(
                    text = "New Task",
                    borderStyle = BorderStyle.NONE,
                    trailingPainter = rememberVectorPainter(Icons.AutoMirrored.Filled.List),
                    leadingPainter = rememberVectorPainter(Icons.AutoMirrored.Filled.List)
                )
                KChip(
                    text = "New Task",
                    borderStyle = BorderStyle.SOLID,
                    enabled = false,
                    trailingPainter = rememberVectorPainter(Icons.AutoMirrored.Filled.List),
                    leadingPainter = rememberVectorPainter(Icons.AutoMirrored.Filled.List)
                )
            }
        }
    }
}
