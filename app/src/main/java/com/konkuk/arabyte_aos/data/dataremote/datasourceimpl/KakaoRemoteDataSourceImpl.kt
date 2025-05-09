package com.konkuk.arabyte_aos.data.dataremote.datasourceimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.KakaoRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.model.response.KakaoSearchResponseDto
import com.konkuk.arabyte_aos.data.dataremote.service.KakaoService
import com.konkuk.arabyte_aos.di.qualifier.Kakao
import retrofit2.Response
import javax.inject.Inject

class KakaoRemoteDataSourceImpl
    @Inject
    constructor(
        @Kakao private val service: KakaoService,
    ) : KakaoRemoteDataSource {
        override suspend fun getSearchKeyword(query: String): Response<KakaoSearchResponseDto> =
            service.getSearchKeyword(query = query)
    }
