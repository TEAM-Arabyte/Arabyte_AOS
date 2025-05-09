package com.konkuk.arabyte_aos.data.dataremote.datasource

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostReportRequestDto
import retrofit2.Response

interface ReportRemoteDataSource {
    suspend fun postReports(
        postReportRequestDto: PostReportRequestDto,
    ): Response<Unit>
}
