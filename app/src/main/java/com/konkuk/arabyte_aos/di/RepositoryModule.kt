package com.konkuk.arabyte_aos.di

import com.konkuk.arabyte_aos.data.repositoryimpl.AuthRepositoryImpl
import com.konkuk.arabyte_aos.data.repositoryimpl.CommentRepositoryImpl
import com.konkuk.arabyte_aos.data.repositoryimpl.DummyRepositoryImpl
import com.konkuk.arabyte_aos.data.repositoryimpl.FirebaseImageRepositoryImpl
import com.konkuk.arabyte_aos.data.repositoryimpl.KakaoRepositoryImpl
import com.konkuk.arabyte_aos.data.repositoryimpl.LocationsRepositoryImpl
import com.konkuk.arabyte_aos.data.repositoryimpl.NoticeBoardRepositoryImpl
import com.konkuk.arabyte_aos.data.repositoryimpl.ReviewsRepositoryImpl
import com.konkuk.arabyte_aos.data.repositoryimpl.UserInfoRepositoryImpl
import com.konkuk.arabyte_aos.domain.repository.AuthRepository
import com.konkuk.arabyte_aos.domain.repository.CommentRepository
import com.konkuk.arabyte_aos.domain.repository.DummyRepository
import com.konkuk.arabyte_aos.domain.repository.FirebaseImageRepository
import com.konkuk.arabyte_aos.domain.repository.KakaoRepository
import com.konkuk.arabyte_aos.domain.repository.LocationsRepository
import com.konkuk.arabyte_aos.domain.repository.NoticeBoardRepository
import com.konkuk.arabyte_aos.domain.repository.ReviewsRepository
import com.konkuk.arabyte_aos.domain.repository.UserInfoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindDummyRepository(dummyRepositoryImpl: DummyRepositoryImpl): DummyRepository

    @Binds
    @Singleton
    abstract fun bindUserInfoRepository(userInfoRepositoryImpl: UserInfoRepositoryImpl): UserInfoRepository

    @Binds
    @Singleton
    abstract fun bindLocationsRepository(locationsRepositoryImpl: LocationsRepositoryImpl): LocationsRepository

    @Binds
    @Singleton
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindNoticeBoardRepository(noticeBoardRepositoryImpl: NoticeBoardRepositoryImpl): NoticeBoardRepository

    @Binds
    @Singleton
    abstract fun bindCommentRepository(commentRepositoryImpl: CommentRepositoryImpl): CommentRepository

    @Binds
    @Singleton
    abstract fun bindReviewRepository(reviewsRepositoryImpl: ReviewsRepositoryImpl): ReviewsRepository

    @Binds
    @Singleton
    abstract fun bindKakaoRepository(kakaoRepositoryImpl: KakaoRepositoryImpl): KakaoRepository

    @Binds
    @Singleton
    abstract fun bindFirebaseImageRepository(firebaseImageRepositoryImpl: FirebaseImageRepositoryImpl): FirebaseImageRepository
}
