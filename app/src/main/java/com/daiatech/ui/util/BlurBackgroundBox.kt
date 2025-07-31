package com.daiatech.app.ui.util

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.daiatech.app.ui.components.message.models.MessageVariant

@Composable
fun BlurBackgroundBox(
    modifier: Modifier = Modifier,
    variant: MessageVariant,
    colorStops: Array<Pair<Float, Color>> = arrayOf(
        0.5f to Color.Gray,
        1f to Color.LightGray
    ),
    thumbnail: Bitmap?
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(shape = variant.shape)
            .background(
                if (variant is MessageVariant.Platform) {
                    Brush.verticalGradient(colorStops = colorStops)
                } else {
                    Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.5f to Color.Gray,
                            1f to variant.color.containerColor
                        )
                    )
                }
            )
            .alpha(0.5f)
    ) {
        if (thumbnail != null) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(variant.shape)
                    .graphicsLayer {
                        scaleX = 1f
                        scaleY = 1f
                        compositingStrategy = CompositingStrategy.Offscreen
                    }
                    .blur(
                        radiusX = 10.dp,
                        radiusY = 10.dp,
                        edgeTreatment = BlurredEdgeTreatment.Unbounded
                    ),
                bitmap = thumbnail.asImageBitmap(),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
    }
}
