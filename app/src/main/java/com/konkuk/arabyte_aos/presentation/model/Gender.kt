package com.konkuk.arabyte_aos.presentation.model

enum class Gender(val label: String) {
    MALE("남성"),
    FEMALE("여성"),
    ANONYMITY("");

    companion object {
        fun fromLabel(label: String): Gender {
            return entries.find { it.label == label } ?: ANONYMITY
        }
    }
}
