package com.konkuk.arabyte_aos.domain.usecase.noticeboard

import com.konkuk.arabyte_aos.domain.model.PostNoticeBoardWrite
import com.konkuk.arabyte_aos.domain.repository.NoticeBoardRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostNoticeBoardWriteUseCase
    @Inject
    constructor(
        private val noticeBoardRepository: NoticeBoardRepository,
    ) {
        suspend operator fun invoke(
            postNoticeBoardWrite: PostNoticeBoardWrite,
        ): Result<Unit> {
            return noticeBoardRepository.postNoticeBoardWrite(
                postNoticeBoardWrite = postNoticeBoardWrite,
            )
        }
    }
