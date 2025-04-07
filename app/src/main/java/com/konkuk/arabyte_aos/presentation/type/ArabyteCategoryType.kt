package com.konkuk.arabyte_aos.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.konkuk.arabyte_aos.R

enum class ArabyteCategoryType(
    @DrawableRes val imageDrawableRes: Int,
    @StringRes val stringRes: Int,
) {
    FOOD(
        imageDrawableRes = R.drawable.ic_home_category_drink_45,
        stringRes = R.string.all_category_food,
    ),
    MANAGEMENT(
        imageDrawableRes = R.drawable.ic_home_category_store_management_45,
        stringRes = R.string.all_category_management,
    ),
    SERVICE(
        imageDrawableRes = R.drawable.ic_home_category_service_45,
        stringRes = R.string.all_category_service,
    ),
    TECH(
        imageDrawableRes = R.drawable.ic_home_category_tech_45,
        stringRes = R.string.all_category_tech,
    ),
    PRODUCTION(
        imageDrawableRes = R.drawable.ic_home_category_production_45,
        stringRes = R.string.all_category_production,
    ),
    DESIGN(
        imageDrawableRes = R.drawable.ic_home_category_design_45,
        stringRes = R.string.all_category_design,
    ),
    EDUCATION(
        imageDrawableRes = R.drawable.ic_home_category_education_45,
        stringRes = R.string.all_category_education,
    ),
    OFFICE(
        imageDrawableRes = R.drawable.ic_home_category_office_45,
        stringRes = R.string.all_category_office,
    ),
}
