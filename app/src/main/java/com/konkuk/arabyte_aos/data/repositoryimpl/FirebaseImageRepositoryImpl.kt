package com.konkuk.arabyte_aos.data.repositoryimpl

import android.net.Uri
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.konkuk.arabyte_aos.domain.repository.FirebaseImageRepository
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import kotlinx.coroutines.tasks.await
import java.util.UUID
import javax.inject.Inject

class FirebaseImageRepositoryImpl
    @Inject
    constructor() : FirebaseImageRepository {
        override suspend fun uploadImage(uri: Uri): Result<String> {
            return try {
                val fileName = "images/${UUID.randomUUID()}.jpg"
                val storageRef = Firebase.storage.reference.child(fileName)

                val uploadTask = storageRef.putFile(uri).await()
                DebugLog.d("FirebaseImage", "업로드 완료: ${uploadTask.metadata?.path}")

                val url = storageRef.downloadUrl.await().toString()
                DebugLog.d("FirebaseImage", "다운로드 URL: $url")

                Result.success(url)
            } catch (e: Exception) {
                DebugLog.e("FirebaseImage", "업로드 실패: ${e.message}", e)
                Result.failure(e)
            }
        }
    }
