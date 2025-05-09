package com.konkuk.arabyte_aos.data.dataremote.service

import com.konkuk.arabyte_aos.data.dataremote.model.response.KakaoSearchResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface KakaoService {
    @GET("v2/local/search/keyword.json")
    suspend fun getSearchKeyword(
        @Query("query") query: String,
    ): Response<KakaoSearchResponseDto>
}
