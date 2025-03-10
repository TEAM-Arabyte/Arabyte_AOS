package com.konkuk.arabyte_aos.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.konkuk.arabyte_aos.R

@Immutable
data class ArabyteTypography(
    // Title
    val titleExtra24: TextStyle,
    val titleExtra20: TextStyle,
    val titleBold20: TextStyle,
    val titleBold18: TextStyle,
    // Body
    val bodyBold17: TextStyle,
    val bodySemi17: TextStyle,
    val bodyMed17: TextStyle,
    val bodyBold15: TextStyle,
    val bodySemi15: TextStyle,
    val bodyMed15: TextStyle,
    val bodyBold13: TextStyle,
    val bodySemi13: TextStyle,
    val bodyMed13: TextStyle,
    // Caption
    val capSemi11: TextStyle,
    val capMed11: TextStyle,
    val capReg11: TextStyle,
    val capSemi9: TextStyle,
    val capMed9: TextStyle,
)

val arabyteTypography =
    ArabyteTypography(
        // Title
        titleExtra24 =
            TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 1.3.em,
            ),
        titleExtra20 =
            TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 1.4.em,
            ),
        titleBold20 =
            TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.Bold,
                lineHeight = 1.4.em,
            ),
        titleBold18 =
            TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.Bold,
                lineHeight = 1.4.em,
            ),
        bodyBold17 =
            TextStyle(
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.Bold,
                lineHeight = 1.4.em,
            ),
        bodySemi17 =
            TextStyle(
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.SemiBold,
                lineHeight = 1.4.em,
            ),
        bodyMed17 =
            TextStyle(
                fontSize = 17.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.Medium,
                lineHeight = 1.4.em,
            ),
        bodyBold15 =
            TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.Bold,
                lineHeight = 1.4.em,
            ),
        bodySemi15 =
            TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.SemiBold,
                lineHeight = 1.4.em,
            ),
        bodyMed15 =
            TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.Medium,
                lineHeight = 1.4.em,
            ),
        bodyBold13 =
            TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.Bold,
                lineHeight = 1.4.em,
            ),
        bodySemi13 =
            TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.SemiBold,
                lineHeight = 1.4.em,
            ),
        bodyMed13 =
            TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.Medium,
                lineHeight = 1.4.em,
            ),
        capSemi11 =
            TextStyle(
                fontSize = 11.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.SemiBold,
                lineHeight = 1.4.em,
            ),
        capMed11 =
            TextStyle(
                fontSize = 11.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.Medium,
                lineHeight = 1.4.em,
            ),
        capReg11 =
            TextStyle(
                fontSize = 11.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.Normal,
                lineHeight = 1.4.em,
            ),
        capSemi9 =
            TextStyle(
                fontSize = 9.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.SemiBold,
                lineHeight = 1.4.em,
            ),
        capMed9 =
            TextStyle(
                fontSize = 9.sp,
                fontFamily = FontFamily(Font(R.font.suit)),
                fontWeight = FontWeight.Medium,
                lineHeight = 1.4.em,
            ),
    )

val LocalArabyteTypography = staticCompositionLocalOf { arabyteTypography }
