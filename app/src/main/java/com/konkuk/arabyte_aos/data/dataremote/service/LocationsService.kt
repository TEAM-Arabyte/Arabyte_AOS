package com.konkuk.arabyte_aos.data.dataremote.service

import com.konkuk.arabyte_aos.data.dataremote.model.response.LocationDataDto
import com.konkuk.arabyte_aos.data.util.ApiConstraints.LOCATIONS
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationsService {
    @GET("/$LOCATIONS/sido")
    suspend fun getSido(): List<LocationDataDto>

    @GET("/$LOCATIONS/gu")
    suspend fun getGu(
        @Query("sidoCode") sidoCode: String,
    ): List<LocationDataDto>

    @GET("/$LOCATIONS/dong")
    suspend fun getDong(
        @Query("sidoCode") sidoCode: String,
        @Query("guCode") guCode: String,
    ): List<LocationDataDto>
}
