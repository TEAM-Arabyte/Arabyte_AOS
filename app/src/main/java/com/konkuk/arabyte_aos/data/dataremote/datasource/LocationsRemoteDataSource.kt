package com.konkuk.arabyte_aos.data.dataremote.datasource

import com.konkuk.arabyte_aos.data.dataremote.model.response.LocationDataDto

interface LocationsRemoteDataSource {
    suspend fun getSido(): List<LocationDataDto>

    suspend fun getGu(sidoCode: String): List<LocationDataDto>

    suspend fun getDong(sidoCode: String, guCode: String): List<LocationDataDto>
}
