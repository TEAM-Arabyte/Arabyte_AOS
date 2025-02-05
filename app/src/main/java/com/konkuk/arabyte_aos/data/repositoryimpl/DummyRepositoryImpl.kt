package com.konkuk.arabyte_aos.data.repositoryimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.DummyRemoteDataSource
import com.konkuk.arabyte_aos.data.mapper.toDomainModel
import com.konkuk.arabyte_aos.domain.model.DummyData
import com.konkuk.arabyte_aos.domain.repository.DummyRepository
import javax.inject.Inject

class DummyRepositoryImpl
    @Inject
    constructor(
        private val remoteDataSource: DummyRemoteDataSource,
    ) : DummyRepository {
        override suspend fun funName(): Result<List<DummyData>> =
            runCatching {
                remoteDataSource.funName().map {
                    it.toDomainModel()
                }
            }
    }
