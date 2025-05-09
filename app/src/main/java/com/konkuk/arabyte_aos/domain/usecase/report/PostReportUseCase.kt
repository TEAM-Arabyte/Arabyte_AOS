package com.konkuk.arabyte_aos.domain.usecase.report

import com.konkuk.arabyte_aos.domain.model.ReportData
import com.konkuk.arabyte_aos.domain.repository.ReportRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostReportUseCase
    @Inject
    constructor(
        private val reportRepository: ReportRepository,
    ) {
        suspend operator fun invoke(reportData: ReportData) = reportRepository.postReport(reportData = reportData)
    }
