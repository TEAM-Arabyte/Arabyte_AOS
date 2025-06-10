package com.konkuk.arabyte_aos.domain.repository

import com.konkuk.arabyte_aos.domain.model.NoticeBoardDetail
import com.konkuk.arabyte_aos.domain.model.NoticeBoardLike
import com.konkuk.arabyte_aos.domain.model.NoticeBoardList
import com.konkuk.arabyte_aos.domain.model.PostNoticeBoardWrite

interface NoticeBoardRepository {
    suspend fun getNoticeBoardList(
        articleKind: String?,
        page: Int,
        size: Int,
        sort: String,
    ): Result<NoticeBoardList>

    suspend fun getNoticeBoardDetail(
        articleId: Long,
    ): Result<NoticeBoardDetail>

    suspend fun postNoticeBoardWrite(
        postNoticeBoardWrite: PostNoticeBoardWrite,
    ): Result<Unit>

    suspend fun postNoticeBoardLike(
        articleId: Long,
    ): Result<NoticeBoardLike>
}
