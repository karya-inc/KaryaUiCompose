package com.daiatech.karya.ui.avatar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val avatarLogo: ImageVector
    get() {
        if (_avatarLogo != null) return _avatarLogo!!

        _avatarLogo = ImageVector.Builder(
            name = "avatarLogo",
            defaultWidth = 207.dp,
            defaultHeight = 207.dp,
            viewportWidth = 207f,
            viewportHeight = 207f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFF241C1C)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(69.4723f, 173.22f)
                    curveTo(69.4723f, 173.22f, 84.8321f, 181.266f, 101.167f, 181.266f)
                    curveTo(117.502f, 181.266f, 141.883f, 171.758f, 141.883f, 171.758f)
                    lineTo(144.077f, 130.025f)
                    lineTo(65.8152f, 132.707f)
                    lineTo(69.4723f, 173.22f)
                    close()
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFF3F270D)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(58.0272f, 180.431f)
                    curveTo(58.0272f, 180.431f, 48.792f, 86.8171f, 54.2832f, 72.3403f)
                    curveTo(59.7744f, 57.8635f, 75.4992f, 35.3994f, 100.709f, 35.649f)
                    curveTo(125.918f, 35.8986f, 154.373f, 51.3739f, 154.872f, 81.0763f)
                    curveTo(155.371f, 110.779f, 148.382f, 181.929f, 148.382f, 181.929f)
                    lineTo(136.651f, 185.673f)
                    lineTo(135.902f, 135.489f)
                    lineTo(70.2571f, 137.486f)
                    lineTo(70.506f, 185.673f)
                    lineTo(58.0272f, 180.431f)
                    close()
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFF4EBF87))
                ) {
                    moveTo(161.10070000000002f, 205.412f)
                    arcTo(57.7397f, 47.5025f, 0f, false, true, 103.361f, 252.9145f)
                    arcTo(57.7397f, 47.5025f, 0f, false, true, 45.621300000000005f, 205.412f)
                    arcTo(57.7397f, 47.5025f, 0f, false, true, 161.10070000000002f, 205.412f)
                    close()
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFFAD744D)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(90.5858f, 149.211f)
                    verticalLineTo(160.506f)
                    curveTo(90.5858f, 160.506f, 94.9099f, 163.507f, 101.881f, 163.507f)
                    curveTo(108.853f, 163.507f, 115.471f, 160.594f, 115.471f, 160.594f)
                    verticalLineTo(147.975f)
                    lineTo(90.5858f, 149.211f)
                    close()
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFFB25434))
                ) {
                    moveTo(114.323f, 66.6128f)
                    curveTo(114.323f, 66.6128f, 107.44f, 76.9369f, 89.6145f, 88.5855f)
                    curveTo(77.1528f, 96.7287f, 65.7463f, 94.4376f, 59.9976f, 92.3199f)
                    curveTo(58.959f, 95.3215f, 58.2372f, 98.4236f, 57.8442f, 101.575f)
                    curveTo(57.6252f, 101.555f, 57.4036f, 101.541f, 57.1796f, 101.541f)
                    curveTo(53.4418f, 101.541f, 50.4325f, 104.55f, 50.4325f, 108.288f)
                    verticalLineTo(119.908f)
                    curveTo(50.4325f, 123.646f, 53.4418f, 126.655f, 57.1796f, 126.655f)
                    curveTo(58.768f, 126.655f, 60.2215f, 126.108f, 61.3717f, 125.196f)
                    curveTo(64.9165f, 133.297f, 70.7432f, 140.19f, 78.1403f, 145.035f)
                    curveTo(85.5375f, 149.879f, 94.185f, 152.465f, 103.027f, 152.477f)
                    curveTo(111.949f, 152.475f, 120.674f, 149.853f, 128.119f, 144.935f)
                    curveTo(135.563f, 140.017f, 141.398f, 133.02f, 144.9f, 124.814f)
                    curveTo(146.108f, 125.954f, 147.733f, 126.655f, 149.532f, 126.655f)
                    curveTo(153.27f, 126.655f, 156.278f, 123.646f, 156.278f, 119.908f)
                    verticalLineTo(108.288f)
                    curveTo(156.278f, 104.55f, 153.27f, 101.541f, 149.532f, 101.541f)
                    curveTo(149.075f, 101.541f, 148.63f, 101.588f, 148.2f, 101.674f)
                    curveTo(148.024f, 100.171f, 147.774f, 98.6782f, 147.449f, 97.2004f)
                    curveTo(143.708f, 94.9621f, 137.851f, 90.4288f, 132.324f, 86.1151f)
                    curveTo(125.088f, 80.4673f, 114.323f, 66.6128f, 114.323f, 66.6128f)
                    close()
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFFCE926A))
                ) {
                    moveTo(114.323f, 68.9067f)
                    curveTo(114.323f, 68.9067f, 107.44f, 79.2308f, 89.6145f, 90.8794f)
                    curveTo(77.1528f, 99.0227f, 65.7463f, 96.7316f, 59.9976f, 94.6138f)
                    curveTo(58.959f, 97.6154f, 58.2372f, 100.717f, 57.8442f, 103.869f)
                    curveTo(57.6252f, 103.848f, 57.4036f, 103.835f, 57.1796f, 103.835f)
                    curveTo(53.4418f, 103.835f, 50.4325f, 106.844f, 50.4325f, 110.582f)
                    verticalLineTo(119.908f)
                    curveTo(50.4325f, 123.646f, 53.4418f, 126.655f, 57.1796f, 126.655f)
                    curveTo(58.768f, 126.655f, 60.2215f, 126.108f, 61.3717f, 125.196f)
                    curveTo(64.9165f, 133.297f, 70.7432f, 140.19f, 78.1403f, 145.035f)
                    curveTo(85.5375f, 149.879f, 94.185f, 152.465f, 103.027f, 152.477f)
                    curveTo(111.949f, 152.475f, 120.674f, 149.852f, 128.119f, 144.935f)
                    curveTo(135.563f, 140.017f, 141.398f, 133.02f, 144.9f, 124.814f)
                    curveTo(146.108f, 125.954f, 147.733f, 126.655f, 149.532f, 126.655f)
                    curveTo(153.27f, 126.655f, 156.278f, 123.646f, 156.278f, 119.908f)
                    verticalLineTo(110.582f)
                    curveTo(156.278f, 106.844f, 153.27f, 103.835f, 149.532f, 103.835f)
                    curveTo(149.075f, 103.835f, 148.63f, 103.882f, 148.2f, 103.968f)
                    curveTo(148.024f, 102.465f, 147.774f, 100.972f, 147.449f, 99.4944f)
                    curveTo(143.708f, 97.2561f, 137.851f, 92.7228f, 132.324f, 88.409f)
                    curveTo(125.088f, 82.7612f, 114.323f, 68.9067f, 114.323f, 68.9067f)
                    close()
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFFFFFFFF))
                ) {
                    moveTo(80.9918f, 90.2935f)
                    curveTo(74.1526f, 90.2935f, 68.199f, 94.1611f, 65.198f, 99.8216f)
                    lineTo(53.3066f, 99.4721f)
                    lineTo(53.2196f, 102.612f)
                    lineTo(63.9165f, 102.927f)
                    curveTo(63.4087f, 104.582f, 63.1324f, 106.337f, 63.1324f, 108.155f)
                    curveTo(63.1324f, 118.003f, 71.1499f, 126.02f, 80.9973f, 126.02f)
                    curveTo(90.8447f, 126.02f, 98.8621f, 118.003f, 98.8621f, 108.155f)
                    curveTo(98.8621f, 107.423f, 98.8122f, 106.703f, 98.7264f, 105.994f)
                    curveTo(99.9499f, 105.483f, 102.297f, 104.625f, 104.318f, 104.625f)
                    curveTo(106.846f, 104.625f, 108.647f, 105.801f, 109.058f, 106.091f)
                    curveTo(108.983f, 106.769f, 108.933f, 107.457f, 108.933f, 108.155f)
                    curveTo(108.933f, 118.003f, 116.95f, 126.02f, 126.798f, 126.02f)
                    curveTo(136.645f, 126.02f, 144.658f, 118.003f, 144.658f, 108.155f)
                    curveTo(144.658f, 106.47f, 144.42f, 104.84f, 143.981f, 103.293f)
                    lineTo(154.238f, 102.646f)
                    lineTo(154.041f, 99.5121f)
                    lineTo(142.795f, 100.222f)
                    curveTo(139.867f, 94.3443f, 133.798f, 90.2935f, 126.798f, 90.2935f)
                    curveTo(118.794f, 90.2935f, 112f, 95.5886f, 109.737f, 102.859f)
                    curveTo(108.524f, 102.225f, 106.631f, 101.484f, 104.316f, 101.484f)
                    curveTo(101.891f, 101.484f, 99.5479f, 102.239f, 98.0527f, 102.843f)
                    curveTo(95.7846f, 95.5806f, 88.9904f, 90.2935f, 80.9918f, 90.2935f)
                    close()
                    moveTo(80.9918f, 93.4349f)
                    curveTo(89.1417f, 93.4349f, 95.7152f, 100.005f, 95.7152f, 108.155f)
                    curveTo(95.7152f, 116.305f, 89.1417f, 122.879f, 80.9918f, 122.879f)
                    curveTo(72.842f, 122.879f, 66.2683f, 116.305f, 66.2683f, 108.155f)
                    curveTo(66.2683f, 100.005f, 72.842f, 93.4349f, 80.9918f, 93.4349f)
                    close()
                    moveTo(126.795f, 93.4349f)
                    curveTo(134.945f, 93.4349f, 141.515f, 100.005f, 141.515f, 108.155f)
                    curveTo(141.515f, 116.305f, 134.945f, 122.879f, 126.795f, 122.879f)
                    curveTo(118.645f, 122.879f, 112.072f, 116.305f, 112.072f, 108.155f)
                    curveTo(112.072f, 100.005f, 118.645f, 93.4349f, 126.795f, 93.4349f)
                    close()
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFFB25534))
                ) {
                    moveTo(79.297f, 122.998f)
                    curveTo(82.6599f, 122.998f, 85.3861f, 120.272f, 85.3861f, 116.909f)
                    curveTo(85.3861f, 113.546f, 82.6599f, 110.82f, 79.297f, 110.82f)
                    curveTo(75.9342f, 110.82f, 73.208f, 113.546f, 73.208f, 116.909f)
                    curveTo(73.208f, 120.272f, 75.9342f, 122.998f, 79.297f, 122.998f)
                    close()
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFFB25534))
                ) {
                    moveTo(129.945f, 122.998f)
                    curveTo(133.308f, 122.998f, 136.034f, 120.272f, 136.034f, 116.909f)
                    curveTo(136.034f, 113.546f, 133.308f, 110.82f, 129.945f, 110.82f)
                    curveTo(126.582f, 110.82f, 123.856f, 113.546f, 123.856f, 116.909f)
                    curveTo(123.856f, 120.272f, 126.582f, 122.998f, 129.945f, 122.998f)
                    close()
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFF3F270D)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(83.5303f, 93.8476f)
                    curveTo(83.5303f, 93.8476f, 86.5307f, 92.7887f, 88.2074f, 92.6122f)
                    curveTo(89.884f, 92.4357f, 92.1786f, 92.9652f, 92.1786f, 92.9652f)
                }
            }
            group {
                path(
                    stroke = SolidColor(Color(0xFF3F270D)),
                    strokeLineWidth = 1.50696f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(83.5303f, 93.8476f)
                    curveTo(83.5303f, 93.8476f, 86.5307f, 92.7887f, 88.2074f, 92.6122f)
                    curveTo(89.884f, 92.4357f, 92.1786f, 92.9652f, 92.1786f, 92.9652f)
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFF3F270D)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(122.537f, 94.1119f)
                    curveTo(122.537f, 94.1119f, 119.537f, 93.0528f, 117.86f, 92.8764f)
                    curveTo(116.183f, 92.6998f, 113.889f, 93.2293f, 113.889f, 93.2293f)
                }
            }
            group {
                path(
                    stroke = SolidColor(Color(0xFF3F270D)),
                    strokeLineWidth = 1.50696f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(122.537f, 94.1119f)
                    curveTo(122.537f, 94.1119f, 119.537f, 93.0528f, 117.86f, 92.8764f)
                    curveTo(116.183f, 92.6998f, 113.889f, 93.2293f, 113.889f, 93.2293f)
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFFB25534))
                ) {
                    moveTo(103.354f, 116.91f)
                    curveTo(102.277f, 116.91f, 101.245f, 117.337f, 100.484f, 118.099f)
                    curveTo(99.7225f, 118.86f, 99.2949f, 119.892f, 99.2948f, 120.969f)
                    curveTo(99.2963f, 121.028f, 99.299f, 121.086f, 99.303f, 121.145f)
                    horizontalLineTo(107.406f)
                    curveTo(107.41f, 121.086f, 107.413f, 121.028f, 107.414f, 120.969f)
                    curveTo(107.414f, 119.892f, 106.986f, 118.86f, 106.225f, 118.099f)
                    curveTo(105.464f, 117.337f, 104.43f, 116.91f, 103.354f, 116.91f)
                    close()
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFFB25534))
                ) {
                    moveTo(88.5038f, 130.361f)
                    curveTo(88.4877f, 130.635f, 88.4796f, 130.91f, 88.4794f, 131.184f)
                    curveTo(88.4836f, 131.376f, 88.4918f, 131.568f, 88.5038f, 131.76f)
                    curveTo(88.5038f, 131.774f, 88.5038f, 131.788f, 88.5038f, 131.802f)
                    curveTo(88.4918f, 131.994f, 88.4836f, 132.186f, 88.4794f, 132.378f)
                    curveTo(88.4787f, 134.243f, 88.8456f, 136.09f, 89.5591f, 137.814f)
                    curveTo(90.2726f, 139.537f, 91.3187f, 141.103f, 92.6377f, 142.422f)
                    curveTo(93.9567f, 143.741f, 95.5226f, 144.787f, 97.2461f, 145.501f)
                    curveTo(98.9695f, 146.214f, 100.817f, 146.581f, 102.682f, 146.58f)
                    curveTo(104.547f, 146.58f, 106.401f, 146.212f, 108.123f, 145.498f)
                    curveTo(109.846f, 144.784f, 111.411f, 143.738f, 112.729f, 142.419f)
                    curveTo(114.047f, 141.1f, 115.093f, 139.535f, 115.806f, 137.812f)
                    curveTo(116.519f, 136.089f, 116.885f, 134.242f, 116.884f, 132.378f)
                    curveTo(116.88f, 132.186f, 116.872f, 131.994f, 116.86f, 131.802f)
                    curveTo(116.86f, 131.796f, 116.86f, 131.791f, 116.86f, 131.785f)
                    curveTo(116.86f, 131.777f, 116.86f, 131.769f, 116.86f, 131.761f)
                    curveTo(116.872f, 131.569f, 116.88f, 131.377f, 116.884f, 131.185f)
                    curveTo(116.878f, 130.91f, 116.865f, 130.636f, 116.843f, 130.362f)
                    lineTo(88.5038f, 130.361f)
                    close()
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFF00373E)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(100.491f, 163.316f)
                    lineTo(99.4003f, 209.053f)
                    horizontalLineTo(105.551f)
                    lineTo(104.766f, 163.402f)
                    lineTo(100.491f, 163.316f)
                    close()
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFF1A1A1A))
                ) {
                    moveTo(89.1794f, 98.4995f)
                    curveTo(88.4362f, 98.5015f, 87.7237f, 99.0342f, 87.1985f, 99.9807f)
                    curveTo(86.6733f, 100.927f, 86.3781f, 102.21f, 86.3779f, 103.548f)
                    curveTo(86.3781f, 104.886f, 86.6733f, 106.169f, 87.1985f, 107.115f)
                    curveTo(87.7237f, 108.062f, 88.4362f, 108.594f, 89.1794f, 108.596f)
                    curveTo(89.5482f, 108.598f, 89.9135f, 108.468f, 90.2545f, 108.215f)
                    curveTo(90.5955f, 107.962f, 90.9053f, 107.59f, 91.1664f, 107.121f)
                    curveTo(91.4275f, 106.652f, 91.6347f, 106.095f, 91.7761f, 105.482f)
                    curveTo(91.9175f, 104.869f, 91.9903f, 104.212f, 91.9904f, 103.548f)
                    curveTo(91.9903f, 102.884f, 91.9175f, 102.227f, 91.7761f, 101.614f)
                    curveTo(91.6347f, 101f, 91.4275f, 100.444f, 91.1664f, 99.9746f)
                    curveTo(90.9053f, 99.5057f, 90.5955f, 99.1341f, 90.2545f, 98.881f)
                    curveTo(89.9135f, 98.6279f, 89.5482f, 98.4982f, 89.1794f, 98.4995f)
                    close()
                    moveTo(118.504f, 98.4995f)
                    curveTo(118.135f, 98.4982f, 117.77f, 98.6278f, 117.429f, 98.881f)
                    curveTo(117.088f, 99.1341f, 116.778f, 99.5057f, 116.517f, 99.9746f)
                    curveTo(116.256f, 100.444f, 116.049f, 101f, 115.908f, 101.614f)
                    curveTo(115.766f, 102.227f, 115.693f, 102.884f, 115.693f, 103.548f)
                    curveTo(115.693f, 104.212f, 115.766f, 104.869f, 115.908f, 105.482f)
                    curveTo(116.049f, 106.095f, 116.256f, 106.652f, 116.517f, 107.121f)
                    curveTo(116.778f, 107.59f, 117.088f, 107.962f, 117.429f, 108.215f)
                    curveTo(117.77f, 108.468f, 118.135f, 108.598f, 118.504f, 108.596f)
                    curveTo(119.248f, 108.594f, 119.96f, 108.062f, 120.485f, 107.115f)
                    curveTo(121.01f, 106.169f, 121.306f, 104.886f, 121.306f, 103.548f)
                    curveTo(121.306f, 102.21f, 121.01f, 100.927f, 120.485f, 99.9807f)
                    curveTo(119.96f, 99.0342f, 119.248f, 98.5015f, 118.504f, 98.4995f)
                    close()
                }
            }
        }.build()

        return _avatarLogo!!
    }

private var _avatarLogo: ImageVector? = null

