package com.daiatech.karya.ui.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
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
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(variant.iconSize)
        )
    }
}


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