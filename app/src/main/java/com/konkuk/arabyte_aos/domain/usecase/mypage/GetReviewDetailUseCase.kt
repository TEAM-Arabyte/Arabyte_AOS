package com.konkuk.arabyte_aos.domain.usecase.mypage

import com.konkuk.arabyte_aos.domain.model.MyInfo
import com.konkuk.arabyte_aos.domain.model.ReviewDetail
import com.konkuk.arabyte_aos.domain.repository.MyPageRepository
import com.konkuk.arabyte_aos.domain.repository.ReviewsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetMyInfoUseCase
    @Inject
    constructor(
        private val myPageRepository: MyPageRepository,
    ) {
        suspend operator fun invoke(): Result<MyInfo> {
            return myPageRepository.getMyInfo()
        }
    }
