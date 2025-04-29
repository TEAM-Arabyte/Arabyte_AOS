package com.konkuk.arabyte_aos.data.dataremote.datasourceimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.ReviewsRemoteDataSource
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
    }
