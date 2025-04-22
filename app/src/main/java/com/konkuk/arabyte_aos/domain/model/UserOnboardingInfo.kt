package com.konkuk.arabyte_aos.domain.model

import com.konkuk.arabyte_aos.presentation.model.ArabyteJobCategory

data class UserOnboardingInfo(
    val experienceYears: Int?,
    val experienceMonths: Int?,
    val jobInterests: List<ArabyteJobCategory>,
)
