package com.konkuk.arabyte_aos.di

import com.konkuk.arabyte_aos.data.repositoryimpl.DummyRepositoryImpl
import com.konkuk.arabyte_aos.data.repositoryimpl.UserInfoRepositoryImpl
import com.konkuk.arabyte_aos.data.repositoryimpl.LocationsRepositoryImpl
import com.konkuk.arabyte_aos.domain.repository.DummyRepository
import com.konkuk.arabyte_aos.domain.repository.UserInfoRepository
import com.konkuk.arabyte_aos.domain.repository.LocationsRepository
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
}
