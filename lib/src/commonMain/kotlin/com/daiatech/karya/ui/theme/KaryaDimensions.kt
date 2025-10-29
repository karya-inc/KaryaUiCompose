package com.daiatech.karya.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class KaryaDimensions(
    val zero: Dp,
    val xxs: Dp,
    val xs: Dp,
    val s: Dp,
    val m: Dp,
    val l: Dp,
    val xl: Dp,
    val xxl: Dp,
    val xxxl: Dp
)

val defaultKaryaDimensions = KaryaDimensions(
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
