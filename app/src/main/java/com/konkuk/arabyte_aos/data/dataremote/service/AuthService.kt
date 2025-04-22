package com.konkuk.arabyte_aos.data.dataremote.service

import com.konkuk.arabyte_aos.data.dataremote.model.request.PatchUserInfoRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.AuthResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.PatchUserInfoResponseDto
import com.konkuk.arabyte_aos.data.util.ApiConstraints.AUTH
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST

interface AuthService {
    @POST("/$AUTH/kakao/authorize")
    suspend fun getAuthToken(): AuthResponseDto

    @PATCH("/auth/register")
    suspend fun patchUserInfo(@Body registerRequestDto: PatchUserInfoRequestDto): PatchUserInfoResponseDto
}
