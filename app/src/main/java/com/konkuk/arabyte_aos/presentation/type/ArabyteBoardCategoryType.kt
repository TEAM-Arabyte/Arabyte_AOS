package com.konkuk.arabyte_aos.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.konkuk.arabyte_aos.R

enum class ArabyteBoardCategoryType(
    @DrawableRes val imageDrawableRes: Int,
    @StringRes val stringRes: Int,
) {
    FREE(
        imageDrawableRes = R.drawable.ic_notice_board_type_free,
        stringRes = R.string.board_category_free,
    ),
    INFO(
        imageDrawableRes = R.drawable.ic_notice_board_type_info,
        stringRes = R.string.board_category_info,
    ),
}
