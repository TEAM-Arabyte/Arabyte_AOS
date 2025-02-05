package com.konkuk.arabyte_aos.data.mapper

import com.konkuk.arabyte_aos.data.dataremote.model.response.DummyResponseDto
import com.konkuk.arabyte_aos.domain.model.DummyData

fun DummyResponseDto.toDomainModel(): DummyData {
    return DummyData(
        description = this.dummy + "입니다 ",
    )
}
