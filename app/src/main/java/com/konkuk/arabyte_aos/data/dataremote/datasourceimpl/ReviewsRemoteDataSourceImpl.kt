package com.konkuk.arabyte_aos.data.dataremote.datasourceimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.ReviewsRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.model.request.PostReviewHelpfulRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.request.PostReviewRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetReviewDetailResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetReviewsResponseDto
import com.konkuk.arabyte_aos.data.dataremote.service.ReviewService
import retrofit2.Response
import javax.inject.Inject

class ReviewsRemoteDataSourceImpl
@Inject
constructor(
    private val service: ReviewService,
) : ReviewsRemoteDataSource {
    override suspend fun getReviews(
        page: Int,
        size: Int,
    ): Response<GetReviewsResponseDto> =
        service.getReviews(
            page = page,
            size = size,
        )

    override suspend fun getReviewDetail(reviewId: Int): Response<GetReviewDetailResponseDto> =
        service.getReviewDetail(
            reviewId = reviewId,
        )

    override suspend fun postReview(postReviewRequestDto: PostReviewRequestDto): Response<Unit> =
        service.postReview(postReviewRequestDto = postReviewRequestDto)

    override suspend fun deleteReviewDetail(reviewId: Int): Response<Unit> =
        service.deleteReviewDetail(reviewId = reviewId)

    override suspend fun postReviewHelpful(reviewId: Int, postReviewHelpfulRequestDto: PostReviewHelpfulRequestDto): Response<GetReviewDetailResponseDto> =
        service.postReviewHelpful(reviewId = reviewId, postReviewHelpfulDto = postReviewHelpfulRequestDto)
}
