package com.konkuk.arabyte_aos.domain.usecase.home

import com.konkuk.arabyte_aos.domain.repository.ReviewsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetHomeReviewsUseCase
    @Inject
    constructor(
        private val reviewsRepository: ReviewsRepository,
    ) {
        suspend operator fun invoke() =
            reviewsRepository.getReviews(
                page = 0,
                size = 3,
            )
    }
