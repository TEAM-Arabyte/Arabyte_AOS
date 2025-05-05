package com.konkuk.arabyte_aos.di

import com.konkuk.arabyte_aos.data.dataremote.datasource.KakaoRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.datasourceimpl.KakaoRemoteDataSourceImpl
import com.konkuk.arabyte_aos.data.dataremote.service.KakaoService
import com.konkuk.arabyte_aos.di.qualifier.Kakao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object KakaoDataSourceProvidesModule {
    @Provides
    @Singleton
    fun provideKakaoRemoteDataSource(
        @Kakao kakaoService: KakaoService
    ): KakaoRemoteDataSource =
        KakaoRemoteDataSourceImpl(kakaoService)
}
