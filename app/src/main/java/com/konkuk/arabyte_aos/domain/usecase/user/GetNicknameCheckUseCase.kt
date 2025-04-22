package com.konkuk.arabyte_aos.domain.usecase.user

import com.konkuk.arabyte_aos.domain.model.NicknameCheck
import com.konkuk.arabyte_aos.domain.repository.UserInfoRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetNicknameCheckUseCase
    @Inject
    constructor(
        private val userInfoRepository: UserInfoRepository,
    ) {
        suspend operator fun invoke(nickname: String): Result<NicknameCheck> {
            return userInfoRepository.getNicknameCheck(nickname = nickname)
        }
    }
