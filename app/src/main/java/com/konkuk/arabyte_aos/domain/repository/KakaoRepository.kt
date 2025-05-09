package com.konkuk.arabyte_aos.domain.repository

import com.konkuk.arabyte_aos.domain.model.KakaoPlace

interface KakaoRepository {
    suspend fun getSearchKeyword(query: String): Result<List<KakaoPlace>>
}
