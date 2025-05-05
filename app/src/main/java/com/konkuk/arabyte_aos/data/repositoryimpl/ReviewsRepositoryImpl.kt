package com.konkuk.arabyte_aos.data.repositoryimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.ReviewsRemoteDataSource
import com.konkuk.arabyte_aos.data.mapper.todata.toRequestDto
import com.konkuk.arabyte_aos.data.mapper.todomain.toDomainModel
import com.konkuk.arabyte_aos.domain.model.PostReview
import com.konkuk.arabyte_aos.domain.model.ReviewDetail
import com.konkuk.arabyte_aos.domain.model.ReviewList
import com.konkuk.arabyte_aos.domain.repository.ReviewsRepository
import com.konkuk.arabyte_aos.presentation.model.ReviewHelpfulType
import javax.inject.Inject

class ReviewsRepositoryImpl
@Inject
constructor(
    private val reviewsRemoteDataSource: ReviewsRemoteDataSource,
) : ReviewsRepository {
    override suspend fun getReviews(
        page: Int,
        size: Int,
    ): Result<ReviewList> =
        runCatching {
            reviewsRemoteDataSource.getReviews(
                page = page,
                size = size,
            ).body()?.toDomainModel()
                ?: throw IllegalStateException("Response body is null")
        }

    override suspend fun getReviewDetail(reviewId: Int): Result<ReviewDetail> =
        runCatching {
            reviewsRemoteDataSource.getReviewDetail(reviewId = reviewId).body()?.toDomainModel()
                ?: throw IllegalStateException("Response body is null")
        }

    override suspend fun postReview(postReview: PostReview): Result<Unit> =
        runCatching {
            reviewsRemoteDataSource.postReview(postReviewRequestDto = postReview.toRequestDto())
        }

    override suspend fun deleteReviewDetail(reviewId: Int): Result<Unit> =
        runCatching {
            reviewsRemoteDataSource.deleteReviewDetail(reviewId = reviewId)
        }

    override suspend fun postReviewHelpful(reviewId: Int, helpful: ReviewHelpfulType): Result<ReviewDetail> =
        runCatching {
            reviewsRemoteDataSource.postReviewHelpful(reviewId = reviewId, postReviewHelpfulRequestDto = helpful.toRequestDto()).body()?.toDomainModel()
                ?: throw IllegalStateException("Response body is null")
        }
}
