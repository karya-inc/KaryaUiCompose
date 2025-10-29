package com.daiatech.karya.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp


@Immutable
data class KaryaShapes(
    val small: Shape,
    val medium: Shape,
    val large: Shape
)

val defaultKaryaShapes  = KaryaShapes(
    small = RoundedCornerShape(4.dp),
    medium =RoundedCornerShape(8.dp),
    large =  RoundedCornerShape(16.dp)
)

