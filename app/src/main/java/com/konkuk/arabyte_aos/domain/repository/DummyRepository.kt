package com.konkuk.arabyte_aos.domain.repository

import com.konkuk.arabyte_aos.domain.model.DummyData

interface DummyRepository {
    suspend fun funName(): Result<List<DummyData>>
}
