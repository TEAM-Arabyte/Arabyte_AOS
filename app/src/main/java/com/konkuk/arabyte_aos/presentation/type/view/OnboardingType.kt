package com.konkuk.arabyte_aos.presentation.type.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.konkuk.arabyte_aos.R

enum class OnboardingType(
    @DrawableRes val pageIconRes:Int,
    @StringRes val titleStringRes: Int,
    @StringRes val descriptionStringRes: Int,
) {
    FIRST(pageIconRes = R.drawable.ic_all_auth_check_16,titleStringRes = R.string.sign_up_first_title, descriptionStringRes = R.string.sign_up_first_button),
    SECOND(pageIconRes = R.drawable.ic_all_auth_check_16,titleStringRes = R.string.sign_up_second_title, descriptionStringRes = R.string.sign_up_second_button),
}
