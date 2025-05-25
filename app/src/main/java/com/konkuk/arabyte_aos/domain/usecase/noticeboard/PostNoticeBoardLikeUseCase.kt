package com.konkuk.arabyte_aos.domain.usecase.noticeboard

import com.konkuk.arabyte_aos.domain.model.NoticeBoardLike
import com.konkuk.arabyte_aos.domain.repository.NoticeBoardRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostNoticeBoardLikeUseCase
    @Inject
    constructor(
        private val noticeBoardRepository: NoticeBoardRepository,
    ) {
        suspend operator fun invoke(
            articleId: Long,
        ): Result<NoticeBoardLike> {
            return noticeBoardRepository.postNoticeBoardLike(
                articleId = articleId,
            )
        }
    }
