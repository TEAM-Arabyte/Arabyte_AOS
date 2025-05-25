package com.konkuk.arabyte_aos.di

import com.konkuk.arabyte_aos.data.dataremote.service.AuthService
import com.konkuk.arabyte_aos.data.dataremote.service.CommentService
import com.konkuk.arabyte_aos.data.dataremote.service.KakaoService
import com.konkuk.arabyte_aos.data.dataremote.service.LocationsService
import com.konkuk.arabyte_aos.data.dataremote.service.MyPageService
import com.konkuk.arabyte_aos.data.dataremote.service.NoticeBoardService
import com.konkuk.arabyte_aos.data.dataremote.service.ReportService
import com.konkuk.arabyte_aos.data.dataremote.service.ReviewService
import com.konkuk.arabyte_aos.data.dataremote.service.UserService
import com.konkuk.arabyte_aos.di.qualifier.Arabyte
import com.konkuk.arabyte_aos.di.qualifier.Kakao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    fun providesService(
        @Arabyte retrofit: Retrofit,
    ): ReportService =
        retrofit.create(ReportService::class.java)

    @Provides
    fun providesLocationsService(
        @Arabyte retrofit: Retrofit,
    ): LocationsService =
        retrofit.create(LocationsService::class.java)

    @Provides
    fun providesAuthService(
        @Arabyte retrofit: Retrofit,
    ): AuthService =
        retrofit.create(AuthService::class.java)

    @Provides
    fun providesUserService(
        @Arabyte retrofit: Retrofit,
    ): UserService =
        retrofit.create(UserService::class.java)

    @Provides
    fun providesReviewService(
        @Arabyte retrofit: Retrofit,
    ): ReviewService =
        retrofit.create(ReviewService::class.java)

    @Provides
    fun providesMyPageService(
        @Arabyte retrofit: Retrofit,
    ): MyPageService =
        retrofit.create(MyPageService::class.java)

    @Provides
    @Singleton
    @Kakao
    fun provideKakaoService(
        @Kakao retrofit: Retrofit,
    ): KakaoService =
        retrofit.create(KakaoService::class.java)

    @Provides
    fun providesNoticeBoardService(
        @Arabyte retrofit: Retrofit,
    ): NoticeBoardService =
        retrofit.create(NoticeBoardService::class.java)

    @Provides
    fun providesCommentService(
        @Arabyte retrofit: Retrofit,
    ): CommentService =
        retrofit.create(CommentService::class.java)
}
