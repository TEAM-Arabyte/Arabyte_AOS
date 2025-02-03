package com.konkuk.arabyte_aos.domain.usecase

import com.konkuk.arabyte_aos.domain.repository.DummyRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DummyUseCase
    @Inject
    constructor(
        private val dummyRepository: DummyRepository,
    ) {
        suspend operator fun invoke() = dummyRepository.funName()
    }
