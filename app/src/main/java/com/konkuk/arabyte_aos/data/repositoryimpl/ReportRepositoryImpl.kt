package com.konkuk.arabyte_aos.data.repositoryimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.ReportRemoteDataSource
import com.konkuk.arabyte_aos.data.mapper.todata.toRequestDto
import com.konkuk.arabyte_aos.domain.model.ReportData
import com.konkuk.arabyte_aos.domain.repository.ReportRepository
import javax.inject.Inject

class ReportRepositoryImpl
    @Inject
    constructor(
        private val remoteDataSource: ReportRemoteDataSource,
    ) : ReportRepository {
        override suspend fun postReport(reportData: ReportData): Result<Unit> =
            runCatching {
                remoteDataSource.postReports(
                    postReportRequestDto = reportData.toRequestDto(),
                )
            }
    }
