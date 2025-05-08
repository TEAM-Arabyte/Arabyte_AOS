package com.konkuk.arabyte_aos.data.mapper.todomain

import com.konkuk.arabyte_aos.data.dataremote.model.response.KakaoSearchResponseDto
import com.konkuk.arabyte_aos.domain.model.KakaoPlace

fun KakaoSearchResponseDto.toDomainModel(): List<KakaoPlace> {
    return documents.map { document ->
        KakaoPlace(
            id = document.id,
            placeName = document.placeName,
            addressName = document.addressName,
            roadAddressName = document.roadAddressName,
        )
    }
}
