package com.konkuk.arabyte_aos.domain.repository

import com.konkuk.arabyte_aos.domain.model.PostReview
import com.konkuk.arabyte_aos.domain.model.ReviewDetail
import com.konkuk.arabyte_aos.domain.model.ReviewList

interface ReviewsRepository {
    suspend fun getReviews(
        page: Int,
        size: Int,
    ): Result<ReviewList>

    suspend fun getReviewDetail(
        reviewId: Int,
    ): Result<ReviewDetail>

    suspend fun postReview(
        postReview: PostReview,
    ): Result<Unit>

    suspend fun deleteReviewDetail(
        reviewId: Int,
    ): Result<Unit>
}
