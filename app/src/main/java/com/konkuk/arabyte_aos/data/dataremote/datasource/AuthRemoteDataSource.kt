package com.konkuk.arabyte_aos.data.dataremote.datasource

import com.konkuk.arabyte_aos.data.dataremote.model.response.AuthResponseDto

interface AuthRemoteDataSource {
    suspend fun getAuthToken(): AuthResponseDto
}
