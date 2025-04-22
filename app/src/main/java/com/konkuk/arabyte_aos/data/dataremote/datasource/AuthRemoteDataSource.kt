package com.konkuk.arabyte_aos.data.dataremote.datasource

import com.konkuk.arabyte_aos.data.dataremote.model.response.AuthResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.PatchUserInfoResponseDto

interface AuthRemoteDataSource {
    suspend fun getAuthToken(): AuthResponseDto

    suspend fun patchUserInfo(nickname: String, ageRange: String, gender: String, locationId: Int): PatchUserInfoResponseDto
}
