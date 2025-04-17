package com.konkuk.arabyte_aos.data.dataremote.datasourceimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.LocationsRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.model.response.LocationDataDto
import com.konkuk.arabyte_aos.data.dataremote.service.LocationsService
import javax.inject.Inject

class LocationsRemoteDataSourceImpl
    @Inject
    constructor(
        private val service: LocationsService,
    ) : LocationsRemoteDataSource {
        override suspend fun getSido(): List<LocationDataDto> = service.getSido()

        override suspend fun getGu(sidoCode: String): List<LocationDataDto> = service.getGu(sidoCode = sidoCode)

        override suspend fun getDong(
            sidoCode: String,
            guCode: String,
        ): List<LocationDataDto> = service.getDong(sidoCode = sidoCode, guCode = guCode)
    }
