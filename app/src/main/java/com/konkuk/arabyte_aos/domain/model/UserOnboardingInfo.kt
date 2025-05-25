package com.konkuk.arabyte_aos.domain.model

data class UserOnboardingInfo(
    val experienceYears: Int?,
    val experienceMonths: Int?,
    val jobInterests: List<ArabyteJobCategory>,
)
