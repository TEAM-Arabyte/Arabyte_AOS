package com.konkuk.arabyte_aos.domain.model

data class ReviewItem(
    val reviewItemId: Int,
    val companyName: String,
    val isCertified: Boolean,
    val star: Float,
    val content: String,
    val region: String,
    val category: String,
)
