package com.konkuk.arabyte_aos.data.dataremote.service

import com.konkuk.arabyte_aos.data.dataremote.model.response.GetNoticeBoardDetailResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetNoticeBoardListResponseDto
import com.konkuk.arabyte_aos.data.util.ApiConstraints.ARTICLES
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NoticeBoardService {
    @GET("/$ARTICLES")
    suspend fun getNoticeBoardList(
        @Query("articleKind") articleKind: String?,
        @Query("page") page: Int,
        @Query("size") size: Int,
        @Query("sort") sort: String = "createdAt,desc",
    ): Response<GetNoticeBoardListResponseDto>

    @GET("/$ARTICLES/{articleId}")
    suspend fun getNoticeBoardDetail(
        @Path("articleId") articleId: Long,
    ): Response<GetNoticeBoardDetailResponseDto>
}
