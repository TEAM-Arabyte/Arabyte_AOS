package com.konkuk.arabyte_aos.domain.usecase.reivew

import com.konkuk.arabyte_aos.domain.repository.ReviewsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeleteReviewDetailUseCase
    @Inject
    constructor(
        private val reviewsRepository: ReviewsRepository,
    ) {
        suspend operator fun invoke(
            reviewId: Int,
        ): Result<Unit> {
            return reviewsRepository.deleteReviewDetail(
                reviewId = reviewId,
            )
        }
    }
