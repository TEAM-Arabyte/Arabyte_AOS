package com.konkuk.arabyte_aos.domain.usecase.mypage

import com.konkuk.arabyte_aos.domain.repository.MyPageRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostContractVerificationUseCase
@Inject
constructor(
    private val myPageRepository: MyPageRepository,
) {
    suspend operator fun invoke(companyName: String, imageUrl: String): Result<Boolean> {
        return myPageRepository.postContractVerification(
            companyName = companyName,
            imageUrl = imageUrl
        )
    }
}
