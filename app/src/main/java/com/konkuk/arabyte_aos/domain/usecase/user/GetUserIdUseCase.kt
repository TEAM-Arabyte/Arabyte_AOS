package com.konkuk.arabyte_aos.domain.usecase.user

import com.konkuk.arabyte_aos.domain.repository.UserInfoRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetUserIdUseCase
    @Inject
    constructor(
        private val userInfoRepository: UserInfoRepository,
    ) {
        operator fun invoke(): Int {
            return userInfoRepository.getUserId()
        }
    }
