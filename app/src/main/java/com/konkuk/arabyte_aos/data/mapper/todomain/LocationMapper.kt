package com.konkuk.arabyte_aos.data.mapper.todomain

import com.konkuk.arabyte_aos.data.dataremote.model.response.LocationDataDto
import com.konkuk.arabyte_aos.domain.model.LocationData

fun List<LocationDataDto>.toDomainModel(): List<LocationData> {
    return this.map { dto ->
        LocationData(
            locationCode = dto.locationCode,
            sidoName = dto.sido ?: "",
            sidoCode = dto.sidoCode,
            guName = dto.gu ?: "",
            guCode = dto.guCode,
            dongName = dto.dong ?: "",
            dongCode = dto.dongCode,
            depth = dto.depth,
            id = dto.id,
        )
    }
}
