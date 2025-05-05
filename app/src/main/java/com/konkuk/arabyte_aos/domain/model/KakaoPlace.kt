package com.konkuk.arabyte_aos.domain.model

data class KakaoPlace(
    var id: String,
    var placeName: String,
    var categoryName: String,
    var categoryGroupCode: String,
    var categoryGroupName: String,
    var phone: String,
    var addressName: String,
    var roadAddressName: String,
    var placeUrl: String,
)
