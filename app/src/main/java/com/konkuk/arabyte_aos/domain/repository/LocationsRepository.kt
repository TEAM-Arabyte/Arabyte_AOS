package com.konkuk.arabyte_aos.domain.repository

import com.konkuk.arabyte_aos.domain.model.LocationData

interface LocationsRepository {
    suspend fun getSido(): Result<List<LocationData>>

    suspend fun getGu(sidoCode: String): Result<List<LocationData>>

    suspend fun getDong(
        sidoCode: String,
        guCode: String,
    ): Result<List<LocationData>>
}
