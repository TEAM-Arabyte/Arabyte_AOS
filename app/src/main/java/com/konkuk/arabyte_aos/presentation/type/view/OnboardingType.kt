package com.konkuk.arabyte_aos.presentation.type.view

import androidx.annotation.StringRes
import com.konkuk.arabyte_aos.R

enum class OnboardingType(
    @StringRes val titleStringRes: Int,
    @StringRes val descriptionStringRes: Int,
) {
    FIRST(titleStringRes = R.string.onboarding_first_title, descriptionStringRes = R.string.onboarding_first_description),
    SECOND(titleStringRes = R.string.onboarding_second_title, descriptionStringRes = R.string.onboarding_second_description),
}
