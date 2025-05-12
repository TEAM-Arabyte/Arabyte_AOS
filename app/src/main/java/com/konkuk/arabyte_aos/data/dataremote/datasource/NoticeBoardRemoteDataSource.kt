package com.konkuk.arabyte_aos.data.dataremote.datasource

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostNoticeBoardWriteRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetNoticeBoardDetailResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetNoticeBoardListResponseDto
import retrofit2.Response

interface NoticeBoardRemoteDataSource {
    suspend fun getNoticeBoardList(
        articleKind: String?,
        page: Int,
        size: Int,
        sort: String,
    ): Response<GetNoticeBoardListResponseDto>

    suspend fun getNoticeBoardDetail(
        articleId: Long,
    ): Response<GetNoticeBoardDetailResponseDto>

    suspend fun postNoticeBoardWrite(
        postNoticeBoardWriteRequestDto: PostNoticeBoardWriteRequestDto,
    ): Response<Unit>
}
