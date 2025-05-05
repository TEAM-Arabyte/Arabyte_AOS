package com.konkuk.arabyte_aos.domain.usecase.kakao

import com.konkuk.arabyte_aos.domain.model.KakaoPlace
import com.konkuk.arabyte_aos.domain.repository.KakaoRepository
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetKakaoSearchUseCase
    @Inject
    constructor(
        private val kakaoRepository: KakaoRepository,
    ) {
        suspend operator fun invoke(
            query: String,
        ): Result<List<KakaoPlace>> {
            return kakaoRepository.getSearchKeyword(query = query)
        }
    }
