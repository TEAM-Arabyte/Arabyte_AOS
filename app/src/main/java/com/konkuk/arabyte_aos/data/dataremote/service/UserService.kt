package com.konkuk.arabyte_aos.data.dataremote.service

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostOnboardingRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetCheckNicknameResponseDto
import com.konkuk.arabyte_aos.data.util.ApiConstraints.USERS
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {
    @POST("/$USERS/onboarding")
    suspend fun postOnboarding(
        @Body onboardingRequestDto: PostOnboardingRequestDto,
    )

    @DELETE("/$USERS")
    suspend fun deleteUser()

    @GET("/$USERS/nickname/check")
    suspend fun getCheckNickname(
        @Query("nickname") nickname: String,
    ): Response<GetCheckNicknameResponseDto>
}
