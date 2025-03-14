package com.konkuk.arabyte_aos.presentation.util

import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

fun Dp.toSp(density: Density): TextUnit {
    return with(density) { this@toSp.toSp() }
}
