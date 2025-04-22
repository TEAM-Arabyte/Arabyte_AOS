package com.konkuk.arabyte_aos.data.dataremote.service

import com.konkuk.arabyte_aos.data.dataremote.model.response.AuthResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.PatchUserInfoResponseDto
import com.konkuk.arabyte_aos.data.util.ApiConstraints.AUTH
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthService {
    @POST("/$AUTH/kakao/authorize")
    suspend fun getAuthToken(): AuthResponseDto

    @PATCH("/$AUTH/register")
    suspend fun patchUserInfo(
        @Query("nickname") nickname: String,
        @Query("ageRange") ageRange: String,
        @Query("gender") gender: String,
        @Query("locationId") locationId: Int,
    ): PatchUserInfoResponseDto
}
