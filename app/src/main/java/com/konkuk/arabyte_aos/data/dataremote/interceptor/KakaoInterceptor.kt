package com.konkuk.arabyte_aos.data.dataremote.interceptor

import com.konkuk.arabyte_aos.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class KakaoInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "KakaoAK ${BuildConfig.KAKAO_REST_API_KEY}")
            .build()
        return chain.proceed(request)
    }
}