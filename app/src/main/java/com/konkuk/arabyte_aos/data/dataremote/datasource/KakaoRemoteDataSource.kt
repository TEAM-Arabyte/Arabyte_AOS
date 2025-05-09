package com.konkuk.arabyte_aos.data.dataremote.datasource

import com.konkuk.arabyte_aos.data.dataremote.model.response.KakaoSearchResponseDto
import retrofit2.Response

interface KakaoRemoteDataSource {
    suspend fun getSearchKeyword(query: String): Response<KakaoSearchResponseDto>
}
