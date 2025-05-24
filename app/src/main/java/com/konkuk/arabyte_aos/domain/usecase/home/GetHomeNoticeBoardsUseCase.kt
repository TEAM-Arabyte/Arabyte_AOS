package com.konkuk.arabyte_aos.domain.usecase.home

import com.konkuk.arabyte_aos.domain.repository.NoticeBoardRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetHomeNoticeBoardsUseCase
    @Inject
    constructor(
        private val noticeBoardRepository: NoticeBoardRepository,
    ) {
        suspend operator fun invoke() =
            noticeBoardRepository.getNoticeBoardList(
                articleKind = null,
                page = 0,
                size = 3,
                sort = "createdAt,desc",
            )
    }
