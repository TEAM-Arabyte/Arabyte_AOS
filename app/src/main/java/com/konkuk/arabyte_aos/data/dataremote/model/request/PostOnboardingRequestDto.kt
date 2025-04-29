package com.konkuk.arabyte_aos.data.dataremote.model.request

import kotlinx.serialization.Serializable

@Serializable
data class PostOnboardingRequestDto(
    val experienceYears: Int?,
    val experienceMonths: Int?,
    val jobInterests: List<String>,
)
