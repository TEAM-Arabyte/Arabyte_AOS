package com.konkuk.arabyte_aos.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ArabyteColors(
    // Gray Scale
    val black: Color,
    val white: Color,
    val gray08: Color,
    val gray07: Color,
    val gray06: Color,
    val gray05: Color,
    val gray04: Color,
    val gray03: Color,
    val gray02: Color,
    val gray01: Color,
    // Primary
    val mainBlue: Color,
    val subBlue: Color,
    val lightBlue: Color,
    // Symentic
    val alertRed: Color,
    val kakaoYellow: Color,
)

val arabyteColors =
    ArabyteColors(
        // Gray Scale
        black = Color(0xFF000000),
        gray08 = Color(0xFF1D1D1D),
        gray07 = Color(0xFF373737),
        gray06 = Color(0xFF585D62),
        gray05 = Color(0xFF7B7C87),
        gray04 = Color(0xFF999AAB),
        gray03 = Color(0xFFD5D5DE),
        gray02 = Color(0xFFE6E6EB),
        gray01 = Color(0xFFF3F3F6),
        white = Color(0xFFFFFFFF),
        // Primary
        mainBlue = Color(0xFF5E76ED),
        subBlue = Color(0xFF889CFC),
        lightBlue = Color(0xFFE5E8FC),
        // Symentic
        alertRed = Color(0xFFFF3636),
        kakaoYellow = Color(0xFFFEE500),
    )

val LocalArabyteColors = staticCompositionLocalOf { arabyteColors }
