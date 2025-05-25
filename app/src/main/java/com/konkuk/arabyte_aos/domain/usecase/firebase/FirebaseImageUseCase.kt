package com.konkuk.arabyte_aos.domain.usecase.firebase

import android.net.Uri
import com.konkuk.arabyte_aos.domain.repository.FirebaseImageRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseImageUseCase
    @Inject
    constructor(
        private val firebaseImageRepository: FirebaseImageRepository,
    ) {
        suspend operator fun invoke(uri: Uri): Result<String> {
            return firebaseImageRepository.uploadImage(uri)
        }
    }
