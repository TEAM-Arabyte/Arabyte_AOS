package com.konkuk.arabyte_aos.domain.model

data class ReportData(
    val reportType: ReportType,
    val targetId: Long,
    val reason: String,
)

enum class ReportType {
    ARTICLE,
    COMMENT,
    REVIEW,
}
