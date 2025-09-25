package com.daiatech.karya.ui.buttons

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import com.daiatech.karya.ui.theme.errorColor
import com.daiatech.karya.ui.theme.neutral
import com.daiatech.karya.ui.theme.neutral5
import com.daiatech.karya.ui.theme.onErrorColor
import com.daiatech.karya.ui.theme.onNeutral
import com.daiatech.karya.ui.theme.onPrimary
import com.daiatech.karya.ui.theme.onSecondary
import com.daiatech.karya.ui.theme.onTertiary
import com.daiatech.karya.ui.theme.primary
import com.daiatech.karya.ui.theme.primaryDark
import com.daiatech.karya.ui.theme.secondary
import com.daiatech.karya.ui.theme.tertiary

val primaryButtonColors
    @Composable get() =
        ButtonDefaults.buttonColors(
            contentColor = onSecondary,
            containerColor = primaryDark,
            disabledContainerColor = primary.copy(0.4f),
            disabledContentColor = onPrimary.copy(0.4f),
        )

val commonButtonColors
    @Composable get() =
        ButtonDefaults.buttonColors(
            contentColor = onPrimary,
            containerColor = neutral5,
            disabledContainerColor = neutral5,
        )

val primaryButtonColorsDark
    @Composable get() =
        ButtonDefaults.buttonColors(
            contentColor = onSecondary,
            disabledContainerColor = primaryDark,
            disabledContentColor = primaryDark,
        )

val primaryIconButtonColors
    @Composable get() =
        IconButtonDefaults.iconButtonColors(
            containerColor = primaryDark,
            contentColor = onSecondary,
            disabledContainerColor = primary.copy(0.4f),
            disabledContentColor = onPrimary.copy(0.4f),
        )

val primaryOutlinedButtonColors
    @Composable get() =
        ButtonDefaults.outlinedButtonColors(
            contentColor = primary,
            disabledContainerColor = primary.copy(0.4f),
            disabledContentColor = onPrimary.copy(0.4f),
        )

val secondaryButtonColors
    @Composable get() =
        ButtonDefaults.buttonColors(
            containerColor = secondary,
            contentColor = onSecondary,
            disabledContainerColor = secondary.copy(0.4f),
            disabledContentColor = onSecondary.copy(0.4f),
        )

val secondaryIconButtonColors
    @Composable get() =
        IconButtonDefaults.iconButtonColors(
            containerColor = secondary,
            contentColor = onSecondary,
            disabledContainerColor = secondary.copy(0.4f),
            disabledContentColor = onSecondary.copy(0.4f),
        )

val tertiaryButtonColors
    @Composable get() =
        ButtonDefaults.buttonColors(
            containerColor = tertiary,
            contentColor = onTertiary,
            disabledContainerColor = tertiary.copy(0.4f),
            disabledContentColor = onTertiary.copy(0.4f),
        )

val tertiaryIconButtonColors
    @Composable get() =
        IconButtonDefaults.iconButtonColors(
            containerColor = tertiary,
            contentColor = onTertiary,
            disabledContainerColor = tertiary.copy(0.4f),
            disabledContentColor = onTertiary.copy(0.4f),
        )

val errorButtonColors
    @Composable get() =
        ButtonDefaults.buttonColors(
            containerColor = errorColor,
            disabledContainerColor = errorColor.copy(0.4f),
            contentColor = onErrorColor,
            disabledContentColor = onErrorColor.copy(0.4f),
        )

val errorIconButtonColors
    @Composable get() =
        IconButtonDefaults.iconButtonColors(
            containerColor = errorColor,
            disabledContainerColor = errorColor.copy(0.4f),
            contentColor = onErrorColor,
            disabledContentColor = onErrorColor.copy(0.4f),
        )

val neutralButtonColors
    @Composable get() =
        ButtonDefaults.buttonColors(
            containerColor = neutral,
            contentColor = onNeutral,
            disabledContainerColor = neutral.copy(0.4f),
            disabledContentColor = onNeutral.copy(0.4f),
        )

val neutralIconButtonColors
    @Composable get() =
        IconButtonDefaults.iconButtonColors(
            containerColor = neutral,
            contentColor = onNeutral,
            disabledContainerColor = neutral.copy(0.4f),
            disabledContentColor = onNeutral.copy(0.4f),
        )
