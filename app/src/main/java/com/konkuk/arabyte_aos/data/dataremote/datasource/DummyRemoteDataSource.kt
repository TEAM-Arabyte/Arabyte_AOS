package com.konkuk.arabyte_aos.data.dataremote.datasource

import com.konkuk.arabyte_aos.data.dataremote.model.response.DummyResponseDto

interface DummyRemoteDataSource {
    suspend fun funName(): List<DummyResponseDto>
}
