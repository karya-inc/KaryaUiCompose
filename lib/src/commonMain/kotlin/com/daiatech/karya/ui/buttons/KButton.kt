package com.daiatech.karya.ui.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun KButton(
    modifier: Modifier = Modifier,
    content: String? = null,
    leftIcon: Painter? = null,
    rightIcon: Painter? = null,
    variant: ButtonVariant,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    KButtonLayout(
        modifier = modifier,
        content = content?.let { text ->
            {
                Text(
                    text = text,
                    style = variant.textStyle
                )
            }
        },
        leftIcon = leftIcon?.let { icon ->
            {
                Icon(
                    painter = icon,
                    contentDescription = content,
                    modifier = Modifier.size(variant.iconSize),
                    tint = variant.contentColor(enabled)
                )
            }
        },
        rightIcon = rightIcon?.let { icon ->
            {
                Icon(
                    painter = icon,
                    contentDescription = content,
                    modifier = Modifier.size(variant.iconSize),
                    tint = variant.contentColor(enabled)
                )
            }
        },
        variant = variant,
        enabled = enabled,
        onClick = onClick,
    )
}


/**
 * Reusable button layout component that applies a ButtonVariant configuration.
 *
 * @param modifier Modifier to be applied to the button
 * @param content Main button content, typically a Text composable
 * @param leftIcon Optional icon to display before the content
 * @param rightIcon Optional icon to display after the content
 * @param variant ButtonVariant configuration that defines the button's appearance
 * @param interactionSource MutableInteractionSource for handling user interactions (press, hover, etc.)
 * @param enabled Whether the button is enabled or disabled
 * @param onClick Callback invoked when the button is clicked
 */
@Composable
internal fun KButtonLayout(
    modifier: Modifier = Modifier,
    content: (@Composable () -> Unit)? = null,
    leftIcon: (@Composable () -> Unit)? = null,
    rightIcon: (@Composable () -> Unit)? = null,
    variant: ButtonVariant,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        enabled = enabled,
        shape = variant.shape,
        colors = variant.colors,
        border = BorderStroke(1.dp, variant.borderColor),
        contentPadding = variant.paddingValues,
        interactionSource = interactionSource,
    ) {
        Row(
            modifier = Modifier.height(variant.iconSize),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(variant.itemSpacing),
        ) {
            leftIcon?.invoke()
            content?.invoke()
            rightIcon?.invoke()
        }
    }
}

@Stable
internal fun ButtonVariant.contentColor(enabled: Boolean): Color =
    if (enabled) colors.contentColor else colors.disabledContentColor

@Preview()
@Composable
fun KButtonPreview() {
    val buttonVariants = listOf(
        "Primary Small" to ButtonVariants.primarySmall,
        "Primary Regular" to ButtonVariants.primaryRegular,
        "Secondary Small" to ButtonVariants.secondarySmall,
        "Secondary Regular" to ButtonVariants.secondaryRegular,
        "Tertiary Small" to ButtonVariants.tertiarySmall,
        "Tertiary Regular" to ButtonVariants.tertiaryRegular,
        "Error Small" to ButtonVariants.errorSmall,
        "Error Regular" to ButtonVariants.errorRegular,
        "Accent Outline Small" to ButtonVariants.accentOutlineSmall,
        "Accent Outline Regular" to ButtonVariants.accentOutlineRegular,
        "Accent Fill Small" to ButtonVariants.accentFillSmall,
        "Accent Fill Regular" to ButtonVariants.accentFillRegular,
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(buttonVariants) { (label, variant) ->
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                KButton(
                    modifier = Modifier.fillMaxWidth(),
                    content = "Enabled",
                    variant = variant,
                    onClick = {}
                )
                KButton(
                    modifier = Modifier.fillMaxWidth(),
                    content = "Disabled",
                    variant = variant,
                    enabled = false,
                    onClick = {},
                    leftIcon = rememberVectorPainter(Icons.Default.Add)
                )
            }
        }
    }
}
