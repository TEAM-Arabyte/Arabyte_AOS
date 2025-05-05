package com.konkuk.arabyte_aos.domain.usecase.noticeboard

import com.konkuk.arabyte_aos.domain.model.NoticeBoardDetail
import com.konkuk.arabyte_aos.domain.repository.NoticeBoardRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetNoticeBoardDetailUseCase
    @Inject
    constructor(
        private val noticeBoardRepository: NoticeBoardRepository,
    ) {
        suspend operator fun invoke(
            articleId: Int,
        ): Result<NoticeBoardDetail> {
            return noticeBoardRepository.getNoticeBoardDetail(
                articleId = articleId,
            )
        }
    }
