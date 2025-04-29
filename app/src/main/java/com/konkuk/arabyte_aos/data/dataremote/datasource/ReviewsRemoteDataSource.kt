package com.konkuk.arabyte_aos.data.dataremote.datasource

import com.konkuk.arabyte_aos.data.dataremote.model.response.GetReviewsResponseDto
import retrofit2.Response

interface ReviewsRemoteDataSource {
    suspend fun getReviews(
        page: Int,
        size: Int,
    ): Response<GetReviewsResponseDto>
}
