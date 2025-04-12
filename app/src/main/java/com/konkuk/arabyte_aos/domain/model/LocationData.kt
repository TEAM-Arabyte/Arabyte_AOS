package com.konkuk.arabyte_aos.domain.model

data class LocationData(
    val locationCode: String,
    val sidoName: String,
    val sidoCode: String,
    val guName: String,
    val guCode: String,
    val dongName: String,
    val dongCode: String,
    val depth: Int,
    val id: Int
)
