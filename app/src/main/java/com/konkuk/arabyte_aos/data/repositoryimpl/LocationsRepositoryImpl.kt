package com.konkuk.arabyte_aos.data.repositoryimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.LocationsRemoteDataSource
import com.konkuk.arabyte_aos.data.mapper.todomain.toDomainModel
import com.konkuk.arabyte_aos.domain.model.LocationData
import com.konkuk.arabyte_aos.domain.repository.LocationsRepository
import javax.inject.Inject

class LocationsRepositoryImpl
@Inject
constructor(
    private val locationsDataSource: LocationsRemoteDataSource,
) : LocationsRepository {
    override suspend fun getSido(): Result<List<LocationData>> =
        runCatching {
            locationsDataSource.getSido().toDomainModel()
        }

    override suspend fun getGu(sidoCode: String): Result<List<LocationData>> =
        runCatching {
            locationsDataSource.getGu(sidoCode = sidoCode).toDomainModel()
        }


    override suspend fun getDong(sidoCode: String, guCode: String): Result<List<LocationData>> =
        runCatching {
            locationsDataSource.getDong(sidoCode = sidoCode, guCode = guCode).toDomainModel()
        }

}
