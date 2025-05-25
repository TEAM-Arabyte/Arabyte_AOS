package com.konkuk.arabyte_aos.data.dataremote.datasourceimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.ReportRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.model.request.PostReportRequestDto
import com.konkuk.arabyte_aos.data.dataremote.service.ReportService
import retrofit2.Response
import javax.inject.Inject

class ReportRemoteDataSourceImpl
    @Inject
    constructor(
        private val service: ReportService,
    ) : ReportRemoteDataSource {
        override suspend fun postReports(postReportRequestDto: PostReportRequestDto): Response<Unit> =
            service.postReports(
                postReportRequestDto = postReportRequestDto,
            )
    }
