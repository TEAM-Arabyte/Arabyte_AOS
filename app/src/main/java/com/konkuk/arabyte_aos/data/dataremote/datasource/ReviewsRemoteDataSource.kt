package com.konkuk.arabyte_aos.data.dataremote.datasource

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostReviewHelpfulRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.request.PostReviewRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetReviewDetailResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetReviewsResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.ReviewContentDto
import retrofit2.Response

interface ReviewsRemoteDataSource {
    suspend fun getReviews(
        page: Int,
        size: Int,
    ): Response<GetReviewsResponseDto>

    suspend fun getReviewDetail(
        reviewId: Int,
    ): Response<GetReviewDetailResponseDto>

    suspend fun postReview(postReviewRequestDto: PostReviewRequestDto): Response<Unit>

    suspend fun deleteReviewDetail(
        reviewId: Int,
    ): Response<Unit>

    suspend fun postReviewHelpful(
        reviewId: Int,
        postReviewHelpfulRequestDto: PostReviewHelpfulRequestDto,
    ): Response<GetReviewDetailResponseDto>

    suspend fun getFilteredReviews(
        locationId: Int?,
        categories: List<String>?,
        isCertified: Boolean?,
    ): Response<List<ReviewContentDto>>
}
