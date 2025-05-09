package com.konkuk.arabyte_aos.domain.usecase.reivew

import com.konkuk.arabyte_aos.domain.model.ReviewItem
import com.konkuk.arabyte_aos.domain.repository.ReviewsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetFilteredReviewListUseCase
    @Inject
    constructor(
        private val reviewsRepository: ReviewsRepository,
    ) {
        suspend operator fun invoke(
            locationId: Int?,
            categories: List<String>?,
            isCertified: Boolean?,
        ): Result<List<ReviewItem>> {
            return reviewsRepository.getFilteredReviews(
                locationId = locationId,
                categories = categories,
                isCertified = isCertified,
            )
        }
    }
