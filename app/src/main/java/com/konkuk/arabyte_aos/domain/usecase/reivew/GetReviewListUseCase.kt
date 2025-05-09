package com.konkuk.arabyte_aos.domain.usecase.reivew

import com.konkuk.arabyte_aos.domain.model.ReviewList
import com.konkuk.arabyte_aos.domain.repository.ReviewsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetReviewListUseCase
    @Inject
    constructor(
        private val reviewsRepository: ReviewsRepository,
    ) {
        suspend operator fun invoke(
            page: Int,
            size: Int,
        ): Result<ReviewList> {
            return reviewsRepository.getReviews(
                page = page,
                size = size,
            )
        }
    }
