package com.daiatech.karya.ui.avatar


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val messageBubble: ImageVector
    get() {
        if (_messageBubble != null) return _messageBubble!!

        _messageBubble = ImageVector.Builder(
            name = "messageBubble",
            defaultWidth = 90.dp,
            defaultHeight = 85.dp,
            viewportWidth = 90f,
            viewportHeight = 85f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFFFFFFFF))
                ) {
                    moveTo(16f, 4f)
                    curveTo(11.5817f, 4f, 8f, 7.58172f, 8f, 12f)
                    verticalLineTo(43.2222f)
                    curveTo(8f, 47.6404f, 11.5817f, 51.2222f, 16f, 51.2222f)
                    horizontalLineTo(49.9121f)
                    curveTo(51.0369f, 52.2702f, 52.3561f, 53.4896f, 53.8032f, 54.8273f)
                    curveTo(59.1101f, 59.7329f, 66.1366f, 66.2281f, 71.5999f, 71.6875f)
                    curveTo(73.1569f, 73.2434f, 76.3486f, 71.4508f, 75.7346f, 69.337f)
                    lineTo(70.4732f, 51.2222f)
                    horizontalLineTo(73.4565f)
                    curveTo(77.8748f, 51.2222f, 81.4565f, 47.6404f, 81.4565f, 43.2222f)
                    verticalLineTo(12f)
                    curveTo(81.4565f, 7.58172f, 77.8748f, 4f, 73.4565f, 4f)
                    horizontalLineTo(16f)
                    close()
                }
            }
            group {
                path(
                    stroke = SolidColor(Color(0xFFD9D9D9)),
                    strokeLineWidth = 2f
                ) {
                    moveTo(16f, 4f)
                    curveTo(11.5817f, 4f, 8f, 7.58172f, 8f, 12f)
                    verticalLineTo(43.2222f)
                    curveTo(8f, 47.6404f, 11.5817f, 51.2222f, 16f, 51.2222f)
                    horizontalLineTo(49.9121f)
                    curveTo(51.0369f, 52.2702f, 52.3561f, 53.4896f, 53.8032f, 54.8273f)
                    curveTo(59.1101f, 59.7329f, 66.1366f, 66.2281f, 71.5999f, 71.6875f)
                    curveTo(73.1569f, 73.2434f, 76.3486f, 71.4508f, 75.7346f, 69.337f)
                    lineTo(70.4732f, 51.2222f)
                    horizontalLineTo(73.4565f)
                    curveTo(77.8748f, 51.2222f, 81.4565f, 47.6404f, 81.4565f, 43.2222f)
                    verticalLineTo(12f)
                    curveTo(81.4565f, 7.58172f, 77.8748f, 4f, 73.4565f, 4f)
                    horizontalLineTo(16f)
                    close()
                }
            }
        }.build()
        
        return _messageBubble!!
    }

private var _messageBubble: ImageVector? = null

