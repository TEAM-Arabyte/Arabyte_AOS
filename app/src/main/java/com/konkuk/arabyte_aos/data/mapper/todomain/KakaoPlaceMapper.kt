package com.konkuk.arabyte_aos.data.mapper.todomain

import com.konkuk.arabyte_aos.data.dataremote.model.response.KakaoSearchResponseDto
import com.konkuk.arabyte_aos.domain.model.KakaoPlace

fun KakaoSearchResponseDto.toDomainModel(): List<KakaoPlace> {
    return documents.map { document ->
        KakaoPlace(
            id = document.id,
            placeName = document.placeName,
            categoryName = document.categoryName,
            categoryGroupCode = document.categoryGroupCode,
            categoryGroupName = document.categoryGroupName,
            phone = document.phone,
            addressName = document.addressName,
            roadAddressName = document.roadAddressName,
            placeUrl = document.placeUrl,
        )
    }
}
