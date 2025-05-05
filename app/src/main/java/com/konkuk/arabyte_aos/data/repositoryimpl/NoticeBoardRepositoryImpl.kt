package com.konkuk.arabyte_aos.data.repositoryimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.NoticeBoardRemoteDataSource
import com.konkuk.arabyte_aos.data.mapper.todomain.toDomainModel
import com.konkuk.arabyte_aos.domain.model.NoticeBoardDetail
import com.konkuk.arabyte_aos.domain.model.NoticeBoardList
import com.konkuk.arabyte_aos.domain.repository.NoticeBoardRepository
import javax.inject.Inject

class NoticeBoardRepositoryImpl
    @Inject
    constructor(
        private val noticeBoardListRemoteDataSource: NoticeBoardRemoteDataSource,
    ) : NoticeBoardRepository {
        override suspend fun getNoticeBoardList(
            articleKind: String?,
            page: Int,
            size: Int,
            sort: String,
        ): Result<NoticeBoardList> =
            runCatching {
                noticeBoardListRemoteDataSource.getNoticeBoardList(
                    articleKind = articleKind,
                    page = page,
                    size = size,
                    sort = sort,
                ).body()?.toDomainModel()
                    ?: throw IllegalStateException("Response body is null")
            }

        override suspend fun getNoticeBoardDetail(articleId: Long): Result<NoticeBoardDetail> =
            runCatching {
                noticeBoardListRemoteDataSource.getNoticeBoardDetail(
                    articleId = articleId,
                ).body()?.toDomainModel()
                    ?: throw IllegalStateException("Response body is null")
            }
    }
