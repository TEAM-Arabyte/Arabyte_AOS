package com.konkuk.arabyte_aos.data.util

import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.toTimeFormat(): String {
    return try {
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
        val createdAt = LocalDateTime.parse(this, formatter)
        val now = LocalDateTime.now()
        val duration = Duration.between(createdAt, now)

        when {
            duration.toMinutes() < 1 -> "방금 전"
            duration.toHours() < 1 -> "${duration.toMinutes()}분 전"
            duration.toHours() < 24 -> "${duration.toHours()}시간 전"
            else -> "${duration.toDays()}일 전"
        }
    } catch (e: Exception) {
        "알 수 없음"
    }
}
