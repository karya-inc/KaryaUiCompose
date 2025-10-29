
package com.daiatech.karya.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class KaryaColorScheme(

    // Brand Colors
    val impactGreen: Color,
    val techBlue: Color,
    val freshLime: Color,

    // Semantic Colors
    val red: Color,
    val yellow: Color,

    // Neutral Colors
    val black: Color,
    val white: Color,

    // Primary
    val primary0: Color,
    val primary10: Color,
    val primary20: Color,
    val primary30: Color,
    val primary40: Color,
    val primary50: Color,
    val primary60: Color,
    val primary70: Color,
    val primary80: Color,
    val primary90: Color,
    val primary95: Color,
    val primary99: Color,
    val primary100: Color,

    // Secondary
    val secondary0: Color,
    val secondary10: Color,
    val secondary20: Color,
    val secondary30: Color,
    val secondary40: Color,
    val secondary50: Color,
    val secondary60: Color,
    val secondary70: Color,
    val secondary80: Color,
    val secondary90: Color,
    val secondary95: Color,
    val secondary99: Color,
    val secondary100: Color,

    // Tertiary
    val tertiary0: Color,
    val tertiary10: Color,
    val tertiary20: Color,
    val tertiary30: Color,
    val tertiary40: Color,
    val tertiary50: Color,
    val tertiary60: Color,
    val tertiary70: Color,
    val tertiary80: Color,
    val tertiary90: Color,
    val tertiary95: Color,
    val tertiary99: Color,
    val tertiary100: Color,

    // Error
    val error0: Color,
    val error10: Color,
    val error20: Color,
    val error30: Color,
    val error40: Color,
    val error50: Color,
    val error60: Color,
    val error70: Color,
    val error80: Color,
    val error90: Color,
    val error95: Color,
    val error99: Color,
    val error100: Color,

    // Warning
    val warning0: Color,
    val warning10: Color,
    val warning20: Color,
    val warning30: Color,
    val warning40: Color,
    val warning50: Color,
    val warning60: Color,
    val warning70: Color,
    val warning80: Color,
    val warning90: Color,
    val warning95: Color,
    val warning99: Color,
    val warning100: Color,

    // Neutrals
    val neutral0: Color,
    val neutral10: Color,
    val neutral20: Color,
    val neutral30: Color,
    val neutral40: Color,
    val neutral50: Color,
    val neutral60: Color,
    val neutral70: Color,
    val neutral80: Color,
    val neutral90: Color,
    val neutral95: Color,
    val neutral99: Color,
    val neutral100: Color
)

val defaultKaryaColorScheme = KaryaColorScheme(

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
