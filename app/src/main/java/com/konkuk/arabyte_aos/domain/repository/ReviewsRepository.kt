package com.konkuk.arabyte_aos.domain.repository

import com.konkuk.arabyte_aos.domain.model.ReviewList

interface ReviewsRepository {
    suspend fun getReviews(
        page: Int,
        size: Int,
    ): Result<ReviewList>
}
