package com.konkuk.arabyte_aos.data.dataremote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class KakaoSearchResponseDto(
    var documents: List<Place>,
)

@Serializable
data class Place(
    var id: String,
    var placeName: String,
    var addressName: String,
    var roadAddressName: String,
)
