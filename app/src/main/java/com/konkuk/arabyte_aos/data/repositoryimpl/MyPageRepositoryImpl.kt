package com.konkuk.arabyte_aos.data.repositoryimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.MyPageRemoteDataSource
import com.konkuk.arabyte_aos.data.mapper.todomain.toDomainModel
import com.konkuk.arabyte_aos.domain.model.MyInfo
import com.konkuk.arabyte_aos.domain.repository.MyPageRepository
import javax.inject.Inject

class MyPageRepositoryImpl
@Inject
constructor(
    private val myPageRemoteDataSource: MyPageRemoteDataSource,
) : MyPageRepository {
    override suspend fun getMyInfo(): Result<MyInfo> =
        runCatching {
            myPageRemoteDataSource.getMyInfo().body()?.toDomainModel()
                ?: throw IllegalStateException("Response body is null")
        }

    override suspend fun postContractVerification(companyName: String, imageUrl: String): Result<Boolean> =
        runCatching {
            myPageRemoteDataSource.postContractVerification(
                companyName = companyName,
                imageUrl = imageUrl
            ).body()?.toDomainModel() ?: throw IllegalStateException("Response body is null")
        }
}
