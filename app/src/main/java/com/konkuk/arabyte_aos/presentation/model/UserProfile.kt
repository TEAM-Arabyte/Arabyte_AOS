package com.konkuk.arabyte_aos.presentation.model

data class UserProfile(
    val userName: String = "",
    val location: String = "",
    val age: String = "",
    val gender: Gender = Gender.ANONYMITY,
    val experienceYears: Int = 0,
    val experienceMonths: Int = 0,
    val jobInterests: List<ArabyteJobCategory> = emptyList(),
)
