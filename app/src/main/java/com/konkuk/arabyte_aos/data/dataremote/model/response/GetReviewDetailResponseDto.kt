package com.konkuk.arabyte_aos.data.dataremote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class GetReviewDetailResponseDto(
    val reviewId: Int,
    val userId: Int,
    val companyName: String,
    val isCertified: Boolean,
    val star: Int,
    val text: String,
    val location: String,
    val category: String,
    val workIntensity: String,
    val workAtmosphere: String,
    val salary: String,
    val salaryDate: String,
    val overtime: String,
    val difficulty: String,
    val badCount: Int,
    val normalCount: Int,
    val goodCount: Int,
    val helpful: String?,
)
