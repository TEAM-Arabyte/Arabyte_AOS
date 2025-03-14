package com.konkuk.arabyte_aos.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.konkuk.arabyte_aos.R

enum class ArabyteBoardCategoryType(
    @DrawableRes val imageDrawableRes: Int,
    @StringRes val stringRes: Int,
) {
    FREE(
        imageDrawableRes = R.drawable.ic_home_category_drink_45,
        stringRes = R.string.board_category_free,
    ),
    INFO(
        imageDrawableRes = R.drawable.ic_home_category_store_management_45,
        stringRes = R.string.board_category_info,
    ),
}
