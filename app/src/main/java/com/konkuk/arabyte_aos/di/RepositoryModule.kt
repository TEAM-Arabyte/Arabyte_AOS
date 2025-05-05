package com.konkuk.arabyte_aos.di

import com.konkuk.arabyte_aos.data.repositoryimpl.AuthRepositoryImpl
import com.konkuk.arabyte_aos.data.repositoryimpl.CommentRepositoryImpl
import com.konkuk.arabyte_aos.data.repositoryimpl.DummyRepositoryImpl
import com.konkuk.arabyte_aos.data.repositoryimpl.LocationsRepositoryImpl
import com.konkuk.arabyte_aos.data.repositoryimpl.NoticeBoardRepositoryImpl
import com.konkuk.arabyte_aos.data.repositoryimpl.UserInfoRepositoryImpl
import com.konkuk.arabyte_aos.domain.repository.AuthRepository
import com.konkuk.arabyte_aos.domain.repository.CommentRepository
import com.konkuk.arabyte_aos.domain.repository.DummyRepository
import com.konkuk.arabyte_aos.domain.repository.LocationsRepository
import com.konkuk.arabyte_aos.domain.repository.NoticeBoardRepository
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
}
