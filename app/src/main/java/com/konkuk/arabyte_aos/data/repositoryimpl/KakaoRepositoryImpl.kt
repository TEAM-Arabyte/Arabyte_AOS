package com.konkuk.arabyte_aos.data.repositoryimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.KakaoRemoteDataSource
import com.konkuk.arabyte_aos.data.mapper.todomain.toDomainModel
import com.konkuk.arabyte_aos.domain.model.KakaoPlace
import com.konkuk.arabyte_aos.domain.repository.KakaoRepository
import javax.inject.Inject

class KakaoRepositoryImpl
@Inject
constructor(
    private val kakaoRemoteDataSource: KakaoRemoteDataSource,
) : KakaoRepository {
    override suspend fun getSearchKeyword(query: String): Result<List<KakaoPlace>> =
        runCatching {
            kakaoRemoteDataSource.getSearchKeyword(query = query).body()?.toDomainModel()
                ?: throw IllegalStateException("Response body is null")
        }

}
