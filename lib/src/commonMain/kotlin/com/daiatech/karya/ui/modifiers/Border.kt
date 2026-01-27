package com.daiatech.karya.ui.modifiers


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.daiatech.karya.ui.theme.KaryaTheme
import androidx.compose.ui.tooling.preview.Preview

fun Modifier.dashedBorder(
    strokeWidth: Dp,
    color: Color,
    shape: Shape = RectangleShape,
    dashLength: Dp = 4.dp,
    gapLength: Dp = 4.dp,
    cap: StrokeCap = StrokeCap.Round
) = dashedBorder(brush = SolidColor(color), shape, strokeWidth, dashLength, gapLength, cap)

fun Modifier.dashedBorder(
    brush: Brush,
    shape: Shape,
    strokeWidth: Dp = 2.dp,
    dashLength: Dp = 4.dp,
    gapLength: Dp = 4.dp,
    cap: StrokeCap = StrokeCap.Round
) = this.drawWithContent {
    val strokeWidthPx = strokeWidth.toPx()
    val halfStroke = strokeWidthPx / 2
    val outline = shape.createOutline(
        size = Size(
            width = size.width - strokeWidthPx,
            height = size.height - strokeWidthPx
        ),
        layoutDirection = layoutDirection,
        density = this
    )
    val dashedStroke = Stroke(
        cap = cap,
        width = strokeWidthPx,
        pathEffect = PathEffect.dashPathEffect(
            intervals = floatArrayOf(dashLength.toPx(), gapLength.toPx())
        )
    )
    drawContent()
    translate(left = halfStroke, top = halfStroke) {
        drawOutline(
            outline = outline,
            style = dashedStroke,
            brush = brush
        )
    }
}

@Preview
@Composable
private fun DashedBorderPreview() {
    KaryaTheme {
        Surface {
            Text(
                text = "Hello", modifier = Modifier
                    .padding(8.dp)
                    .dashedBorder(1.dp, Color.Red)
            )
        }
    }
}

@Preview
@Composable
private fun DashedBorderPreview1() {
    KaryaTheme {
        Surface {
            Text(
                text = "Hello", modifier = Modifier
                    .padding(4.dp)
                    .dashedBorder(1.dp, Color.Red, CircleShape)
                    .padding(horizontal = 8.dp)
            )
        }
    }
}

