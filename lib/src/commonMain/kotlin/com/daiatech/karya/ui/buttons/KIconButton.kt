package com.daiatech.karya.ui.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun KIconButton(
    modifier: Modifier = Modifier,
    painter: Painter,
    variant: IconButtonVariant,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(variant.shape)
            .clickable(
                enabled = enabled,
                onClick = onClick,
                role = Role.Button,
                interactionSource = interactionSource
            )
            .background(variant.containerColor(enabled))
            .border(1.dp, variant.borderColor(enabled), variant.shape)
            .padding(variant.paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(variant.iconSize).alpha(enabled.alpha)
        )
    }
}

@Stable
internal fun IconButtonVariant.containerColor(enabled: Boolean): Color =
    if (enabled) colors.containerColor else colors.disabledContainerColor

@Stable
internal fun IconButtonVariant.borderColor(enabled: Boolean): Color =
    if (enabled) borderColor else borderColor.copy(0.5f)


@Preview(showBackground = true)
@Composable
fun KIconButtonPreview() {
    val iconButtonVariants = listOf(
        "Primary Small" to IconButtonVariants.primarySmall,
        "Primary Regular" to IconButtonVariants.primaryRegular,
        "Secondary Small" to IconButtonVariants.secondarySmall,
        "Secondary Regular" to IconButtonVariants.secondaryRegular,
        "Tertiary Small" to IconButtonVariants.tertiarySmall,
        "Tertiary Regular" to IconButtonVariants.tertiaryRegular,
        "Error Small" to IconButtonVariants.errorSmall,
        "Error Regular" to IconButtonVariants.errorRegular,
        "Accent Outline Small" to IconButtonVariants.accentOutlineSmall,
        "Accent Outline Regular" to IconButtonVariants.accentOutlineRegular,
        "Accent Fill Small" to IconButtonVariants.accentFillSmall,
        "Accent Fill Regular" to IconButtonVariants.accentFillRegular,
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(iconButtonVariants) { (label, variant) ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    KIconButton(
                        painter = rememberVectorPainter(Icons.Default.Add),
                        variant = variant,
                        onClick = {}
                    )
                    KIconButton(
                        painter = rememberVectorPainter(Icons.Default.Add),
                        variant = variant,
                        enabled = false,
                        onClick = {}
                    )
                }
            }
        }
    }
}