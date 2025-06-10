package com.konkuk.arabyte_aos.data.dataremote.datasourceimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.NoticeBoardRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.model.request.PostNoticeBoardLikeRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.request.PostNoticeBoardWriteRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetNoticeBoardDetailResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetNoticeBoardListResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.PostNoticeBoardLikeResponseDto
import com.konkuk.arabyte_aos.data.dataremote.service.NoticeBoardService
import retrofit2.Response
import javax.inject.Inject

class NoticeBoardRemoteDataSourceImpl
    @Inject
    constructor(
        private val service: NoticeBoardService,
    ) : NoticeBoardRemoteDataSource {
        override suspend fun getNoticeBoardList(
            articleKind: String?,
            page: Int,
            size: Int,
            sort: String,
        ): Response<GetNoticeBoardListResponseDto> =
            service.getNoticeBoardList(
                articleKind = articleKind,
                page = page,
                size = size,
                sort = sort,
            )

        override suspend fun getNoticeBoardDetail(articleId: Long): Response<GetNoticeBoardDetailResponseDto> =
            service.getNoticeBoardDetail(
                articleId = articleId,
            )

        override suspend fun postNoticeBoardWrite(postNoticeBoardWriteRequestDto: PostNoticeBoardWriteRequestDto): Response<Unit> =
            service.postNoticeBoardWrite(postNoticeBoardWriteRequestDto = postNoticeBoardWriteRequestDto)

        override suspend fun postNoticeBoardLike(postNoticeBoardLikeRequestDto: PostNoticeBoardLikeRequestDto): Response<PostNoticeBoardLikeResponseDto> =
            service.postNoticeBoardLike(postNoticeBoardLikeRequestDto = postNoticeBoardLikeRequestDto)
    }
