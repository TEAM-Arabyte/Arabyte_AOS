package com.konkuk.arabyte_aos.domain.usecase.reivew

import com.konkuk.arabyte_aos.domain.model.ReviewDetail
import com.konkuk.arabyte_aos.domain.repository.ReviewsRepository
import com.konkuk.arabyte_aos.presentation.model.ReviewHelpfulType
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostReviewHelpfulUseCase
    @Inject
    constructor(
        private val reviewsRepository: ReviewsRepository,
    ) {
        suspend operator fun invoke(
            reviewId: Int,
            helpful: ReviewHelpfulType,
        ): Result<ReviewDetail> {
            return reviewsRepository.postReviewHelpful(
                reviewId = reviewId,
                helpful = helpful,
            )
        }
    }
