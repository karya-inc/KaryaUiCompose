package com.daiatech.karya.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val defaultKaryaDimensions = KaryaDimensions(
    zero = 0.dp,
    xxs = 2.dp,
    xs = 4.dp,
    s = 8.dp,
    m = 16.dp,
    l = 24.dp,
    xl = 32.dp,
    xxl = 48.dp,
    xxxl = 64.dp
)

private val defaultKaryaColorScheme = KaryaColorScheme(

    // Brand Colors
    impactGreen = Color(0xFF4EBF87),
    techBlue = Color(0xFF0082D7),
    freshLime = Color(0xFFC8E56E),

    // Semantic Colors
    red = Color(0xFFDE3730),
    yellow = Color(0xFFEDB458),

    // Neutrals
    black = Color(0xFF000000),
    white = Color(0xFFFFFFFF),

    // Primary
    primary0 = Color(0xFF000000),
    primary10 = Color(0xFF001F24),
    primary20 = Color(0xFF00363D),
    primary30 = Color(0xFF005232),
    primary40 = Color(0xFF006C44),
    primary50 = Color(0xFF008857),
    primary60 = Color(0xFF2DA46E),
    primary70 = Color(0xFF4EBF87),
    primary80 = Color(0xFF6CDCA1),
    primary90 = Color(0xFF89F8BC),
    primary95 = Color(0xFFC0FFD7),
    primary99 = Color(0xFFF5FFF5),
    primary100 = Color(0xFFFFFFFF),

    // Secondary
    secondary0 = Color(0xFF000000),
    secondary10 = Color(0xFF161E00),
    secondary20 = Color(0xFF293500),
    secondary30 = Color(0xFF3C4D00),
    secondary40 = Color(0xFF516600),
    secondary50 = Color(0xFF688010),
    secondary60 = Color(0xFF819B2C),
    secondary70 = Color(0xFF9BB645),
    secondary80 = Color(0xFFB6D25D),
    secondary90 = Color(0xFFD1EE76),
    secondary95 = Color(0xFFDFFD83),
    secondary99 = Color(0xFFFBFFE1),
    secondary100 = Color(0xFFFFFFFF),

    // Tertiary
    tertiary0 = Color(0xFF000000),
    tertiary10 = Color(0xFF001D36),
    tertiary20 = Color(0xFF003258),
    tertiary30 = Color(0xFF00497C),
    tertiary40 = Color(0xFF0061A3),
    tertiary50 = Color(0xFF007BCB),
    tertiary60 = Color(0xFF3095EB),
    tertiary70 = Color(0xFF62B0FF),
    tertiary80 = Color(0xFF9ECAFF),
    tertiary90 = Color(0xFFD1E4FF),
    tertiary95 = Color(0xFFE9F1FF),
    tertiary99 = Color(0xFFFDFCFF),
    tertiary100 = Color(0xFFFFFFFF),

    // Error
    error0 = Color(0xFF000000),
    error10 = Color(0xFF410002),
    error20 = Color(0xFF690005),
    error30 = Color(0xFF93000A),
    error40 = Color(0xFFBA1A1A),
    error50 = Color(0xFFDE3730),
    error60 = Color(0xFFFF5449),
    error70 = Color(0xFFFF897D),
    error80 = Color(0xFFFFB4AB),
    error90 = Color(0xFFFFDAD6),
    error95 = Color(0xFFFFEDEA),
    error99 = Color(0xFFFFFBFF),
    error100 = Color(0xFFFFFFFF),

    // Warning
    warning0 = Color(0xFF000000),
    warning10 = Color(0xFF281800),
    warning20 = Color(0xFF432C00),
    warning30 = Color(0xFF614000),
    warning40 = Color(0xFF805600),
    warning50 = Color(0xFF9D6E16),
    warning60 = Color(0xFFBA8730),
    warning70 = Color(0xFFD8A247),
    warning80 = Color(0xFFF7BC60),
    warning90 = Color(0xFFFFDDAF),
    warning95 = Color(0xFFFFEEDB),
    warning99 = Color(0xFFFFFBFF),
    warning100 = Color(0xFFFFFFFF),

    // Neutral
    neutral0 = Color(0xFF000000),
    neutral10 = Color(0xFF151515),
    neutral20 = Color(0xFF2B2B2B),
    neutral30 = Color(0xFF404040),
    neutral40 = Color(0xFF555555),
    neutral50 = Color(0xFF6A6A6A),
    neutral60 = Color(0xFF808080),
    neutral70 = Color(0xFF959595),
    neutral80 = Color(0xFFAAAAAA),
    neutral90 = Color(0xFFBFBFBF),
    neutral95 = Color(0xFFD5D5D5),
    neutral99 = Color(0xFFEAEAEA),
    neutral100 = Color(0xFFFFFFFF)
)

val defaultKaryaShapes  = KaryaShapes(
    small = RoundedCornerShape(4.dp),
    medium =RoundedCornerShape(8.dp),
    large =  RoundedCornerShape(16.dp)
)


val defaultTypography
    @Composable get() =
        Typography(
            displayLarge =
                TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = 57.sp,
                    lineHeight = 28.sp,
                    letterSpacing = 0.4.sp,
                ),
            displayMedium =
                TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = 45.sp,
                    lineHeight = 52.sp,
                    letterSpacing = 0.sp,
                ),
            displaySmall =
                TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = 36.sp,
                    lineHeight = 44.sp,
                    letterSpacing = 0.sp,
                ),
            headlineLarge =
                TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = 32.sp,
                    lineHeight = 40.sp,
                    letterSpacing = 0.sp,
                ),
            headlineMedium =
                TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = 28.sp,
                    lineHeight = 36.sp,
                    letterSpacing = 0.sp,
                ),
            headlineSmall =
                TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = 24.sp,
                    lineHeight = 32.sp,
                    letterSpacing = 0.sp,
                ),
            titleLarge =
                TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = 22.sp,
                    lineHeight = 28.sp,
                    letterSpacing = 0.sp,
                ),
            titleMedium =
                TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.2.sp,
                ),
            titleSmall =
                TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    letterSpacing = 0.2.sp,
                ),
            bodyLarge =
                TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.5.sp,
                ),
            bodyMedium =
                TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    letterSpacing = 0.2.sp,
                ),
            bodySmall =
                TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.4.sp,
                ),
            labelLarge =
                TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    letterSpacing = 0.1.sp,
                ),
            labelMedium =
                TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.5.sp,
                ),
            labelSmall =
                TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    fontSize = 11.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.5.sp,
                ),
        )



internal val LocalColorScheme = staticCompositionLocalOf { defaultKaryaColorScheme }
internal val LocalDimens = staticCompositionLocalOf { defaultKaryaDimensions }
internal val LocalTypography = staticCompositionLocalOf { Typography() }

internal val LocalKaryaShapes = staticCompositionLocalOf { defaultKaryaShapes }

object KaryaTheme {
    val colorScheme: KaryaColorScheme
        @Composable get() = LocalColorScheme.current

    val dimens: KaryaDimensions
        @Composable get() = LocalDimens.current

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
