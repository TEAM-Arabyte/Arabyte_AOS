package com.konkuk.arabyte_aos.presentation.type.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.konkuk.arabyte_aos.R

enum class ArabyteNoticeBoardCategoryType(
    @DrawableRes val imageDrawableRes: Int?,
    @StringRes val stringRes: Int,
) {
    ALL(
        imageDrawableRes = null,
        stringRes = R.string.notice_board_category_all,
    ),
    FREE(
        imageDrawableRes = R.drawable.ic_notice_board_type_free,
        stringRes = R.string.notice_board_category_free,
    ),
    INFO(
        imageDrawableRes = R.drawable.ic_notice_board_type_info,
        stringRes = R.string.notice_board_category_info,
    );

    fun toApiValue():String? = if (this == ALL) null else name
}
