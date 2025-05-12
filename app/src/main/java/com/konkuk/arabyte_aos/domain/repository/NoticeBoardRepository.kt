package com.konkuk.arabyte_aos.domain.repository

import com.konkuk.arabyte_aos.domain.model.NoticeBoardDetail
import com.konkuk.arabyte_aos.domain.model.NoticeBoardList

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
}
