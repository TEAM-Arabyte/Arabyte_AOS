package com.konkuk.arabyte_aos.presentation.type.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.konkuk.arabyte_aos.R

enum class ArabyteFilteringType(
    @DrawableRes val imageDrawableRes: Int,
    @StringRes val stringRes: Int,
) {
    CHECK(
        imageDrawableRes = R.drawable.ic_all_auth_check_16,
        stringRes = R.string.review_filtering_check,
    ),
    REGION(
        imageDrawableRes = R.drawable.ic_all_arrow_down_13,
        stringRes = R.string.review_filtering_region,
    ),
    CATEGORY(
        imageDrawableRes = R.drawable.ic_all_arrow_down_13,
        stringRes = R.string.review_filtering_category,
    ),
}
