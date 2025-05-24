package com.konkuk.arabyte_aos.domain.repository

import android.net.Uri

interface FirebaseImageRepository {
    suspend fun uploadImage(uri: Uri): Result<String>
}
