package com.konkuk.arabyte_aos.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.konkuk.arabyte_aos.R

enum class ArabyteFilteringType(
    @DrawableRes val imageDrawableRes: Int,
    @StringRes val stringRes: Int,
) {
    CHECK(
        imageDrawableRes = R.drawable.ic_all_auth_check_16,
        stringRes = R.string.all_category_food,
    ),
    REGION(
        imageDrawableRes = R.drawable.ic_all_arrow_down_13,
        stringRes = R.string.all_category_management,
    ),
    CATEGORY(
        imageDrawableRes = R.drawable.ic_all_arrow_down_13,
        stringRes = R.string.all_category_service,
    ),
}
