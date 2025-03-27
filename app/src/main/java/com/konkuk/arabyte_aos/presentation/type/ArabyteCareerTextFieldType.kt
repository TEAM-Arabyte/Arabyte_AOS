package com.konkuk.arabyte_aos.presentation.type

import androidx.annotation.StringRes
import com.konkuk.arabyte_aos.R

enum class ArabyteCareerTextFieldType(
    val valueRange: IntRange,
    @StringRes val stringRes: Int,
) {
    MONTH(
        valueRange = 1..12,
        stringRes = R.string.career_text_field_month,
    ),
    YEAR(
        valueRange = 0..99,
        stringRes = R.string.career_text_field_year,
    ),
}
