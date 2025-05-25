package com.konkuk.arabyte_aos.data.dataremote.service

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostReportRequestDto
import com.konkuk.arabyte_aos.data.util.ApiConstraints.REPORTS
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ReportService {
    @POST("/$REPORTS")
    suspend fun postReports(
        @Body postReportRequestDto: PostReportRequestDto,
    ): Response<Unit>
}
