package com.konkuk.arabyte_aos.data.dataremote.model.request

import kotlinx.serialization.Serializable

@Serializable
data class PostReviewRequestDto(
    val companyId: Int,
    val locationId: Int,
    val category: String,
    val text: String,
    val rating: Int,
    val workIntensity: String,
    val workAtmosphere: String,
    val salary: String,
    val salaryDate: String,
    val overtime: String,
    val difficulty: String,
)
