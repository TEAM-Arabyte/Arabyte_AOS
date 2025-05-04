package com.konkuk.arabyte_aos.data.dataremote.service

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostReviewRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetReviewDetailResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetReviewsResponseDto
import com.konkuk.arabyte_aos.data.util.ApiConstraints.REVIEWS
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ReviewService {
    @GET("/$REVIEWS")
    suspend fun getReviews(
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): Response<GetReviewsResponseDto>

    @GET("/$REVIEWS/{reviewId}")
    suspend fun getReviewDetail(
        @Path("reviewId") reviewId: Int,
    ): Response<GetReviewDetailResponseDto>

    @POST("/$REVIEWS")
    suspend fun postReview(
        @Body postReviewRequestDto: PostReviewRequestDto,
    ): Response<Unit>
}
