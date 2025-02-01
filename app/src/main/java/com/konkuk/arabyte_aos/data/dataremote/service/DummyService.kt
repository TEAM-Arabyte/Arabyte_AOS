package com.konkuk.arabyte_aos.data.dataremote.service

import com.konkuk.arabyte_aos.data.dataremote.model.response.DummyResponseDto
import retrofit2.http.POST

interface DummyService {
    @POST("/API")
    suspend fun funName(): List<DummyResponseDto>
}