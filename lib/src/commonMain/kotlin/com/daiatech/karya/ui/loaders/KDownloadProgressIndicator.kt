package com.daiatech.karya.ui.loaders

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daiatech.karya.ui.theme.KaryaTheme
import kotlinx.coroutines.delay

/**
 * A circular progress indicator with an animated download arrow.
 *
 * Displays a circular progress bar with a downward-pointing arrow in the center.
 * The arrow can optionally animate with a continuous downward motion that wraps
 * from bottom to top, creating a download effect.
 *
 * @param progress The current progress value between 0f and 1f.
 * @param modifier The modifier to be applied to the component.
 * @param size The diameter of the indicator in dp.
 * @param strokeWidth The stroke width for both the circular progress and the arrow.
 * @param animateArrow Whether the arrow should animate. When true, the arrow moves
 *   downward continuously and wraps around. When false, the arrow remains static.
 * @param backgroundColor The color of the background circle (unfilled progress).
 * @param progressColor The color of the progress arc.
 * @param arrowColor The color of the download arrow.
 */
@Composable
fun KDownloadProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    size: Float = 200f,
    strokeWidth: Float = 32f,
    animateArrow: Boolean = false,
    backgroundColor: Color = KaryaTheme.colorScheme.neutral95,
    progressColor: Color = KaryaTheme.colorScheme.primary50,
    arrowColor: Color = KaryaTheme.colorScheme.primary50
) {
    val infiniteTransition = rememberInfiniteTransition(label = "arrow")

    val arrowOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = if (animateArrow) 1f else 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "arrowOffset"
    )

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing),
        label = "progress"
    )

    Box(
        modifier = modifier.size(size.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasSize = this.size.minDimension
            val radius = (canvasSize - strokeWidth) / 2
            val center = Offset(canvasSize / 2, canvasSize / 2)

            // Background circle
            drawArc(
                color = backgroundColor,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                topLeft = Offset(
                    center.x - radius,
                    center.y - radius
                ),
                size = Size(radius * 2, radius * 2),
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )

            // Progress arc
            if (animatedProgress > 0) {
                drawArc(
                    color = progressColor,
                    startAngle = -90f,
                    sweepAngle = 360f * animatedProgress,
                    useCenter = false,
                    topLeft = Offset(
                        center.x - radius,
                        center.y - radius
                    ),
                    size = Size(radius * 2, radius * 2),
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                )
            }

            // Animated arrow with wrapping
            val arrowLength = canvasSize * 0.5f
            val arrowHeadSize = arrowLength * 0.35f

            // Define the visible region (inside the circle)
            val topBound = center.y - radius + strokeWidth
            val bottomBound = center.y + radius - strokeWidth
            val totalHeight = bottomBound - topBound

            // Arrow moves from middle to bottom, wrapping to top
            // offset 0 = arrow centered, offset 1 = arrow has moved down by totalHeight
            val baseY = if (animateArrow) {
                center.y + (totalHeight * arrowOffset)
            } else {
                center.y * 1.1f
            }

            // Function to draw arrow at a given Y position
            fun drawArrowAt(arrowCenterY: Float) {
                val shaftTop = arrowCenterY - arrowLength * 0.4f
                val shaftBottom = arrowCenterY + arrowLength * 0.1f
                val headTip = arrowCenterY + arrowLength * 0.2f
                val headWingY = arrowCenterY - arrowLength * 0.05f

                // Arrow shaft
                drawLine(
                    color = arrowColor,
                    start = Offset(center.x, shaftTop),
                    end = Offset(center.x, shaftBottom),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )

                // Arrow head
                val arrowHeadPath = Path().apply {
                    moveTo(center.x, headTip)
                    lineTo(center.x - arrowHeadSize * 0.8f, headWingY)
                    moveTo(center.x, headTip)
                    lineTo(center.x + arrowHeadSize * 0.8f, headWingY)
                }

                drawPath(
                    path = arrowHeadPath,
                    color = arrowColor,
                    style = Stroke(
                        width = strokeWidth,
                        cap = StrokeCap.Round
                    )
                )
            }

            // Clip to the circular region and draw arrows
            clipRect(
                left = center.x - radius + strokeWidth / 2,
                top = topBound,
                right = center.x + radius - strokeWidth / 2,
                bottom = bottomBound
            ) {
                // Draw primary arrow
                drawArrowAt(baseY)

                // Draw wrapped arrow (coming from top when primary goes below bottom)
                drawArrowAt(baseY - totalHeight)
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun DownloadProgressPreview() {
    var progress by remember { mutableStateOf(0.0f) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            if (progress < 1f) {
                progress += 0.1F
            } else {
                progress = 0F
            }
        }
    }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            KDownloadProgressIndicator(
                progress = progress,
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Progress: ${(progress * 100).toInt()}%",
                style = MaterialTheme.typography.titleMedium
            )

            Slider(
                value = progress,
                onValueChange = { progress = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }
    }
}