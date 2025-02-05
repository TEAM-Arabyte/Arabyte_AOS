package com.konkuk.arabyte_aos.data.dataremote.datasourceimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.DummyRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.model.response.DummyResponseDto
import com.konkuk.arabyte_aos.data.dataremote.service.DummyService
import javax.inject.Inject

class DummyRemoteDataSourceImpl
    @Inject
    constructor(
        private val service: DummyService,
    ) : DummyRemoteDataSource {
        override suspend fun funName(): List<DummyResponseDto> = service.funName()
    }
