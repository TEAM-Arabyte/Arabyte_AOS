package com.konkuk.arabyte_aos.domain.repository

import com.konkuk.arabyte_aos.domain.model.PostReview
import com.konkuk.arabyte_aos.domain.model.ReviewDetail
import com.konkuk.arabyte_aos.domain.model.ReviewHelpfulType
import com.konkuk.arabyte_aos.domain.model.ReviewItem
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

    suspend fun postReviewHelpful(
        reviewId: Int,
        helpful: ReviewHelpfulType,
    ): Result<ReviewDetail>

    suspend fun getFilteredReviews(
        locationId: Int?,
        categories: List<String>?,
        isCertified: Boolean?,
    ): Result<List<ReviewItem>>
}
