package com.konkuk.arabyte_aos.domain.model

import com.konkuk.arabyte_aos.presentation.model.ArabyteJobCategory

data class PostReview(
    val companyId: Int,
    val locationId: Int,
    val category: ArabyteJobCategory,
    val text: String,
    val star: Int,
    val reviewRating: ReviewRating,
)
