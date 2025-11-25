package com.daiatech.karya.ui.loaders

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.daiatech.karya.ui.theme.KaryaTheme

@Composable
fun KLoadingAnimation(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "flow")

    val progress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(4800, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "progress"
    )

    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val minDim = minOf(w, h)

        fun interpolate(
            progress: Float,
            keyframes: List<Pair<Float, Float>>
        ): Float {
            if (progress <= keyframes.first().first) return keyframes.first().second
            if (progress >= keyframes.last().first) return keyframes.last().second

            for (i in 0 until keyframes.size - 1) {
                val (t1, v1) = keyframes[i]
                val (t2, v2) = keyframes[i + 1]
                if (progress in t1..t2) {
                    val local = (progress - t1) / (t2 - t1)
                    val eased = if (local < 0.5f)
                        2f * local * local
                    else
                        1f - (-2f * local + 2f).let { it * it } / 2f

                    return v1 + (v2 - v1) * eased
                }
            }
            return keyframes.last().second
        }

        fun pctX(p: Float) = p / 100f * w
        fun pctY(p: Float) = p / 100f * h
        fun pctRadius(r: Float) = r / 100f * minDim

        // Copied from lottie json
        val circle3X = pctX(interpolate(progress, listOf(
            0f to 72.34f, 0.167f to 74.14f, 0.333f to 34.23f,
            0.5f to 18.66f, 0.667f to 39.28f, 0.833f to 18.94f, 1f to 72.34f
        )))
        val circle3Y = pctY(interpolate(progress, listOf(
            0f to 45.15f, 0.167f to 47.06f, 0.333f to 59.92f,
            0.5f to 34.34f, 0.667f to 42f, 0.833f to 50.1f, 1f to 45.15f
        )))
        val circle3Radius = pctRadius(9f)
        drawCircle(
            color = Color(0xFFC8E56E),
            radius = circle3Radius,
            center = Offset(circle3X, circle3Y)
        )

        // Copied from lottie json
        val circle2X = pctX(interpolate(progress, listOf(
            0f to 41.06f, 0.167f to 46.44f, 0.333f to 54.5f,
            0.5f to 54.5f, 0.667f to 49.22f, 0.833f to 49.22f, 1f to 41.06f
        )))
        val circle2Y = pctY(interpolate(progress, listOf(
            0f to 39.14f, 0.167f to 17.02f, 0.333f to 34.34f,
            0.5f to 34.34f, 0.667f to 73.34f, 0.833f to 73.34f, 1f to 39.14f
        )))
        val circle2Radius = pctRadius(15f)
        drawCircle(
            color = Color(0xFF41B47D),
            radius = circle2Radius,
            center = Offset(circle2X, circle2Y)
        )

        // Copied from lottie json
        val circle1X = pctX(interpolate(progress, listOf(
            0f to 57.01f, 0.167f to 58.19f, 0.333f to 64.37f,
            0.5f to 87.53f, 0.667f to 70.45f, 0.833f to 83.31f, 1f to 57.01f
        )))
        val circle1Y = pctY(interpolate(progress, listOf(
            0f to 72.3f, 0.167f to 90.48f, 0.333f to 69.86f,
            0.5f to 64.54f, 0.667f to 44.09f, 0.833f to 35.9f, 1f to 72.3f
        )))
        val circle1Radius = pctRadius(15f)
        drawCircle(
            color = Color(0xFFC8E56E),
            radius = circle1Radius,
            center = Offset(circle1X, circle1Y)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun KLoadingAnimationPreview() {
    Box(
        modifier = Modifier.size(256.dp).border(
            2.dp, KaryaTheme.colorScheme.primary20,
            RoundedCornerShape(16.dp)
        ),
        contentAlignment = Alignment.Center
    ) {
        KLoadingAnimation(Modifier.size(256.dp))
    }
}
