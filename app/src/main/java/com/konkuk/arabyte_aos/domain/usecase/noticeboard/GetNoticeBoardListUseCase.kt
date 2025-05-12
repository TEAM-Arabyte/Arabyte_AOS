package com.konkuk.arabyte_aos.domain.usecase.noticeboard

import com.konkuk.arabyte_aos.domain.model.NoticeBoardList
import com.konkuk.arabyte_aos.domain.repository.NoticeBoardRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetNoticeBoardListUseCase
    @Inject
    constructor(
        private val noticeBoardRepository: NoticeBoardRepository,
    ) {
        suspend operator fun invoke(
            articleKind: String?,
            page: Int,
            size: Int,
            sort: String,
        ): Result<NoticeBoardList> {
            return noticeBoardRepository.getNoticeBoardList(
                articleKind = articleKind,
                page = page,
                size = size,
                sort = sort,
            )
        }
    }
