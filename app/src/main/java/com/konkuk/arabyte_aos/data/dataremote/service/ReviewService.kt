package com.konkuk.arabyte_aos.data.dataremote.service

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostReviewHelpfulRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.request.PostReviewRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetReviewDetailResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetReviewsResponseDto
import com.konkuk.arabyte_aos.data.util.ApiConstraints.REVIEWS
import com.konkuk.arabyte_aos.data.util.ApiConstraints.REVIEW_ID
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
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
        @Path(REVIEW_ID) reviewId: Int,
    ): Response<GetReviewDetailResponseDto>

    @POST("/$REVIEWS")
    suspend fun postReview(
        @Body postReviewRequestDto: PostReviewRequestDto,
    ): Response<Unit>

    @DELETE("/$REVIEWS/{reviewId}")
    suspend fun deleteReviewDetail(
        @Path(REVIEW_ID) reviewId: Int,
    ): Response<Unit>

    @POST("/$REVIEWS/{reviewId}/helpful")
    suspend fun postReviewHelpful(
        @Path(REVIEW_ID) reviewId: Int,
        @Body postReviewHelpfulDto: PostReviewHelpfulRequestDto,
    ): Response<GetReviewDetailResponseDto>
}
