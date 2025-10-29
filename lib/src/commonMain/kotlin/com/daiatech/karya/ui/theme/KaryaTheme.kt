package com.daiatech.karya.ui.theme

import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.material3.Typography

internal val LocalColorScheme = staticCompositionLocalOf { defaultKaryaColorScheme }
internal val LocalDimens = staticCompositionLocalOf { defaultKaryaDimensions }
internal val LocalTypography = staticCompositionLocalOf { Typography() }

internal val LocalKaryaShapes = staticCompositionLocalOf { defaultKaryaShapes }

object KaryaTheme {
    val colors: KaryaColorScheme
        @Composable get() = LocalColorScheme.current

    val dimens: KaryaDimensions
        @Composable get() = LocalDimens.current

    // TODO: Implement our own typography
    val typography: Typography
        @Composable get() = LocalTypography.current

    val shapes: KaryaShapes
        @Composable get() = LocalKaryaShapes.current
}

@Composable
fun KaryaTheme(
    colors: KaryaColorScheme = defaultKaryaColorScheme,
    dimens: KaryaDimensions = defaultKaryaDimensions,
    typography: Typography = defaultTypography,
    shapes: KaryaShapes = defaultKaryaShapes,
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(
        LocalColorScheme provides colors,
        LocalDimens provides dimens,
        LocalTypography provides typography,
        LocalKaryaShapes provides shapes,
        LocalContentColor provides LocalColorScheme.current.black,
        content = content
    )
}