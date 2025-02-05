package com.konkuk.arabyte_aos.di

import com.konkuk.arabyte_aos.data.repositoryimpl.DummyRepositoryImpl
import com.konkuk.arabyte_aos.domain.repository.DummyRepository
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
}
