package com.konkuk.arabyte_aos.domain.repository

import com.konkuk.arabyte_aos.domain.model.ReportData

interface ReportRepository {
    suspend fun postReport(reportData: ReportData): Result<Unit>
}
