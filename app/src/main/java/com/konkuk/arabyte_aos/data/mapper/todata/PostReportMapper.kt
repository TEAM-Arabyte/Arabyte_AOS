package com.konkuk.arabyte_aos.data.mapper.todata

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostReportRequestDto
import com.konkuk.arabyte_aos.domain.model.ReportData

fun ReportData.toRequestDto(): PostReportRequestDto {
    return PostReportRequestDto(
        reportType = this.reportType.name,
        targetId = this.targetId,
        reason = this.reason,
    )
}
