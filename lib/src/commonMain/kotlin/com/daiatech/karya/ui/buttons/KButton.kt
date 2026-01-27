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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

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
fun KButton(
    modifier: Modifier = Modifier,
    content: String? = null,
    leftIcon: Painter? = null,
    rightIcon: Painter? = null,
    variant: ButtonVariant,
    enabled: Boolean = true,
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource? = null
) {
    @Suppress("NAME_SHADOWING")
    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }
    val containerColor = variant.containerColor(enabled)
    val contentColor = variant.contentColor(enabled)
    val border = variant.borderWidth?.let {
        BorderStroke(it, variant.borderColor(enabled))
    }
    Surface(
        onClick = onClick,
        modifier = modifier.semantics { role = Role.Button },
        enabled = enabled,
        shape = variant.shape,
        color = containerColor,
        contentColor = contentColor,
        border = border,
        interactionSource = interactionSource
    ) {
        Row(
            Modifier
                .height(variant.height)
                .padding(variant.paddingValues),
            horizontalArrangement = Arrangement.spacedBy(
                variant.itemSpacing,
                Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            leftIcon?.let { icon ->
                Icon(
                    painter = icon,
                    contentDescription = content,
                    modifier = Modifier.size(variant.iconSize),
                    tint = variant.contentColor(enabled)
                )
            }

            content?.let { text ->
                Text(
                    text = text,
                    style = variant.textStyle
                )
            }

            rightIcon?.let { icon ->
                Icon(
                    painter = icon,
                    contentDescription = content,
                    modifier = Modifier.size(variant.iconSize),
                    tint = variant.contentColor(enabled)
                )
            }
        }
    }
}


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
                    modifier = Modifier,
                    content = "Enabled",
                    variant = variant,
                    onClick = {}
                )
                KButton(
                    modifier = Modifier,
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
