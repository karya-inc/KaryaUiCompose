package com.daiatech.karya.ui.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.daiatech.karya.ui.theme.KaryaTheme

/**
 * Immutable button variant configuration.
 * Mark as @Immutable to help Compose skip recompositions.
 * Constructor is internal to avoid creation of any other variant outside design system.
 */
@Immutable
class ButtonVariant internal constructor(
    val colors: ButtonColors,
    val shape: Shape,
    val textStyle: TextStyle,
    val iconSize: Dp,
    val itemSpacing: Dp,
    val paddingValues: PaddingValues,
    val borderColor: Color,
    val borderWidth: Dp?
) {
    @Stable
    internal fun contentColor(enabled: Boolean): Color =
        if (enabled) colors.contentColor else colors.disabledContentColor

    @Stable
    internal fun containerColor(enabled: Boolean): Color =
        if (enabled) colors.containerColor else colors.disabledContainerColor

    @Stable
    internal fun borderColor(enabled: Boolean): Color =
        if (enabled) borderColor else borderColor.copy(0.5f)

    @Stable
    internal val height: Dp = paddingValues.calculateTopPadding() +
            iconSize + paddingValues.calculateBottomPadding()
}

/**
 * Immutable icon button variant configuration.
 * Icon buttons don't need textStyle or itemSpacing since they only contain icons.
 * Constructor is internal to avoid creation of any other variant outside design system.
 */
@Immutable
class IconButtonVariant internal constructor(
    val colors: ButtonColors,
    val shape: Shape,
    val iconSize: Dp,
    val paddingValues: PaddingValues,
    val borderColor: Color,
    val borderWidth: Dp?
)

/**
 * Provides button variants with proper memoization.
 */
object ButtonVariants {

    // Small buttons
    val primarySmall: ButtonVariant
        @Composable get() = rememberButtonVariant(
            colorScheme = ButtonColorScheme.Primary,
            size = ButtonSize.Small
        )

    val secondarySmall: ButtonVariant
        @Composable get() = rememberButtonVariant(
            colorScheme = ButtonColorScheme.Secondary,
            size = ButtonSize.Small
        )

    val tertiarySmall: ButtonVariant
        @Composable get() = rememberButtonVariant(
            colorScheme = ButtonColorScheme.Tertiary,
            size = ButtonSize.Small
        )

    val errorSmall: ButtonVariant
        @Composable get() = rememberButtonVariant(
            colorScheme = ButtonColorScheme.Error,
            size = ButtonSize.Small
        )

    val accentOutlineSmall: ButtonVariant
        @Composable get() = rememberButtonVariant(
            colorScheme = ButtonColorScheme.AccentOutline,
            size = ButtonSize.Small
        )

    val accentFillSmall: ButtonVariant
        @Composable get() = rememberButtonVariant(
            colorScheme = ButtonColorScheme.AccentFill,
            size = ButtonSize.Small
        )

    // Regular buttons
    val primaryRegular: ButtonVariant
        @Composable get() = rememberButtonVariant(
            colorScheme = ButtonColorScheme.Primary,
            size = ButtonSize.Regular
        )

    val secondaryRegular: ButtonVariant
        @Composable get() = rememberButtonVariant(
            colorScheme = ButtonColorScheme.Secondary,
            size = ButtonSize.Regular
        )

    val tertiaryRegular: ButtonVariant
        @Composable get() = rememberButtonVariant(
            colorScheme = ButtonColorScheme.Tertiary,
            size = ButtonSize.Regular
        )

    val errorRegular: ButtonVariant
        @Composable get() = rememberButtonVariant(
            colorScheme = ButtonColorScheme.Error,
            size = ButtonSize.Regular
        )

    val accentOutlineRegular: ButtonVariant
        @Composable get() = rememberButtonVariant(
            colorScheme = ButtonColorScheme.AccentOutline,
            size = ButtonSize.Regular
        )

    val accentFillRegular: ButtonVariant
        @Composable get() = rememberButtonVariant(
            colorScheme = ButtonColorScheme.AccentFill,
            size = ButtonSize.Regular
        )
}

/**
 * Provides icon button variants. Icon buttons share the same color schemes but don't need text styling.
 */
object IconButtonVariants {

    // Small icon buttons
    val primarySmall: IconButtonVariant
        @Composable get() = rememberIconButtonVariant(
            colorScheme = ButtonColorScheme.Primary,
            size = ButtonSize.Small
        )

    val secondarySmall: IconButtonVariant
        @Composable get() = rememberIconButtonVariant(
            colorScheme = ButtonColorScheme.Secondary,
            size = ButtonSize.Small
        )


    val tertiarySmall: IconButtonVariant
        @Composable get() = rememberIconButtonVariant(
            colorScheme = ButtonColorScheme.Tertiary,
            size = ButtonSize.Small
        )

    val errorSmall: IconButtonVariant
        @Composable get() = rememberIconButtonVariant(
            colorScheme = ButtonColorScheme.Error,
            size = ButtonSize.Small
        )

    val accentOutlineSmall: IconButtonVariant
        @Composable get() = rememberIconButtonVariant(
            colorScheme = ButtonColorScheme.AccentOutline,
            size = ButtonSize.Small
        )

    val accentFillSmall: IconButtonVariant
        @Composable get() = rememberIconButtonVariant(
            colorScheme = ButtonColorScheme.AccentFill,
            size = ButtonSize.Small
        )

    // Regular icon buttons
    val primaryRegular: IconButtonVariant
        @Composable get() = rememberIconButtonVariant(
            colorScheme = ButtonColorScheme.Primary,
            size = ButtonSize.Regular
        )

    val secondaryRegular: IconButtonVariant
        @Composable get() = rememberIconButtonVariant(
            colorScheme = ButtonColorScheme.Secondary,
            size = ButtonSize.Regular
        )

    val tertiaryRegular: IconButtonVariant
        @Composable get() = rememberIconButtonVariant(
            colorScheme = ButtonColorScheme.Tertiary,
            size = ButtonSize.Regular
        )

    val errorRegular: IconButtonVariant
        @Composable get() = rememberIconButtonVariant(
            colorScheme = ButtonColorScheme.Error,
            size = ButtonSize.Regular
        )

    val accentOutlineRegular: IconButtonVariant
        @Composable get() = rememberIconButtonVariant(
            colorScheme = ButtonColorScheme.AccentOutline,
            size = ButtonSize.Regular
        )

    val accentFillRegular: IconButtonVariant
        @Composable get() = rememberIconButtonVariant(
            colorScheme = ButtonColorScheme.AccentFill,
            size = ButtonSize.Regular
        )
}

private enum class ButtonColorScheme {
    Primary, Secondary, Tertiary, Error, AccentOutline, AccentFill;

    val borderWidth
        get() : Dp? {
            return when (this) {
                Primary -> null
                Secondary -> 1.dp
                Tertiary -> null
                Error -> null
                AccentOutline -> 1.dp
                AccentFill -> null
            }
        }
}

private enum class ButtonSize {
    Small, Regular
}

/**
 * Remember a button variant with proper memoization, avoiding unnecessary recompositions.
 */
@Composable
private fun rememberButtonVariant(
    colorScheme: ButtonColorScheme,
    size: ButtonSize
): ButtonVariant {
    val colors = rememberButtonColors(colorScheme)
    val shapes = KaryaTheme.shapes
    val typography = KaryaTheme.typography
    val dimens = KaryaTheme.dimens
    val currentColorScheme = KaryaTheme.colorScheme

    return remember(colorScheme, size, colors, shapes, typography, dimens, currentColorScheme) {
        val (shape, textStyle, iconSize, paddingValues, itemSpacing) = when (size) {
            ButtonSize.Small -> ButtonSizeConfig(
                shape = shapes.small,
                textStyle = typography.labelMedium,
                iconSize = 16.dp,
                paddingValues = PaddingValues(8.dp),
                itemSpacing = dimens.xs
            )

            ButtonSize.Regular -> ButtonSizeConfig(
                shape = shapes.medium,
                textStyle = typography.labelLarge,
                iconSize = 24.dp,
                paddingValues = PaddingValues(12.dp),
                itemSpacing = dimens.s
            )
        }

        val borderColor = when (colorScheme) {
            ButtonColorScheme.Primary -> currentColorScheme.primary50
            ButtonColorScheme.Secondary -> currentColorScheme.primary50
            ButtonColorScheme.Tertiary -> Color.Transparent
            ButtonColorScheme.Error -> currentColorScheme.error50
            ButtonColorScheme.AccentOutline -> currentColorScheme.tertiary50
            ButtonColorScheme.AccentFill -> currentColorScheme.tertiary50
        }

        ButtonVariant(
            colors = colors,
            shape = shape,
            textStyle = textStyle,
            iconSize = iconSize,
            itemSpacing = itemSpacing,
            paddingValues = paddingValues,
            borderColor = borderColor,
            borderWidth = colorScheme.borderWidth
        )
    }
}

/**
 * Remember an icon button variant, avoiding unnecessary recompositions.
 */
@Composable
private fun rememberIconButtonVariant(
    colorScheme: ButtonColorScheme,
    size: ButtonSize
): IconButtonVariant {
    val colors = rememberButtonColors(colorScheme)
    val shapes = KaryaTheme.shapes
    val currentColorScheme = KaryaTheme.colorScheme

    return remember(colorScheme, size, colors, shapes, currentColorScheme) {
        val (shape, iconSize, paddingValues) = when (size) {
            ButtonSize.Small -> IconButtonSizeConfig(
                shape = shapes.small,
                iconSize = 16.dp,
                paddingValues = PaddingValues(8.dp)
            )

            ButtonSize.Regular -> IconButtonSizeConfig(
                shape = shapes.medium,
                iconSize = 24.dp,
                paddingValues = PaddingValues(12.dp)
            )
        }

        val borderColor = when (colorScheme) {
            ButtonColorScheme.Primary -> currentColorScheme.primary50
            ButtonColorScheme.Secondary -> currentColorScheme.primary50
            ButtonColorScheme.Tertiary -> Color.Transparent
            ButtonColorScheme.Error -> currentColorScheme.error50
            ButtonColorScheme.AccentOutline -> currentColorScheme.tertiary50
            ButtonColorScheme.AccentFill -> currentColorScheme.tertiary50
        }

        IconButtonVariant(
            colors = colors,
            shape = shape,
            iconSize = iconSize,
            paddingValues = paddingValues,
            borderColor = borderColor,
            borderWidth = colorScheme.borderWidth
        )
    }
}

/**
 * Remember button colors based on color scheme, avoiding unnecessary recompositions.
 */
@Composable
private fun rememberButtonColors(colorScheme: ButtonColorScheme): ButtonColors {
    val theme = KaryaTheme.colorScheme

    return remember(colorScheme, theme) {
        when (colorScheme) {
            ButtonColorScheme.Primary -> ButtonColors(
                containerColor = theme.primary50,
                contentColor = theme.neutral100,
                disabledContainerColor = theme.primary50.copy(alpha = 0.5f),
                disabledContentColor = theme.neutral100.copy(alpha = 0.5f),
            )

            ButtonColorScheme.Secondary -> ButtonColors(
                containerColor = theme.primary100,
                contentColor = theme.primary50,
                disabledContainerColor = theme.primary100.copy(alpha = 0.5f),
                disabledContentColor = theme.primary50.copy(alpha = 0.5f),
            )

            ButtonColorScheme.Tertiary -> ButtonColors(
                containerColor = Color.Transparent,
                contentColor = theme.primary50,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = theme.primary50.copy(alpha = 0.5f),
            )

            ButtonColorScheme.Error -> ButtonColors(
                containerColor = theme.error50,
                contentColor = theme.neutral100,
                disabledContainerColor = theme.error50.copy(alpha = 0.5f),
                disabledContentColor = theme.neutral100.copy(alpha = 0.5f),
            )

            ButtonColorScheme.AccentOutline -> ButtonColors(
                containerColor = theme.neutral100,
                contentColor = theme.neutral20,
                disabledContainerColor = theme.neutral100.copy(alpha = 0.5f),
                disabledContentColor = theme.neutral20.copy(alpha = 0.5f),
            )

            ButtonColorScheme.AccentFill -> ButtonColors(
                containerColor = theme.tertiary50,
                contentColor = theme.neutral100,
                disabledContainerColor = theme.tertiary50.copy(alpha = 0.5f),
                disabledContentColor = theme.neutral100.copy(alpha = 0.5f),
            )
        }
    }
}

private data class ButtonSizeConfig(
    val shape: Shape,
    val textStyle: TextStyle,
    val iconSize: Dp,
    val paddingValues: PaddingValues,
    val itemSpacing: Dp
)

private data class IconButtonSizeConfig(
    val shape: Shape,
    val iconSize: Dp,
    val paddingValues: PaddingValues
)
