package com.konkuk.arabyte_aos.data.repositoryimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.ReviewsRemoteDataSource
import com.konkuk.arabyte_aos.data.mapper.todomain.toDomainModel
import com.konkuk.arabyte_aos.domain.model.ReviewDetail
import com.konkuk.arabyte_aos.domain.model.ReviewList
import com.konkuk.arabyte_aos.domain.repository.ReviewsRepository
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
            kotlin.runCatching {
                reviewsRemoteDataSource.getReviewDetail(reviewId = reviewId).body()?.toDomainModel()
                    ?: throw IllegalStateException("Response body is null")
            }
    }
