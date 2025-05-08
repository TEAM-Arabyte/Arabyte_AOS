package com.konkuk.arabyte_aos.data.dataremote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KakaoSearchResponseDto(
    var documents: List<Place>,
)

@Serializable
data class Place(
    @SerialName("id") val id: String,
    @SerialName("place_name") val placeName: String,
    @SerialName("address_name") val addressName: String,
    @SerialName("road_address_name") val roadAddressName: String,
)
