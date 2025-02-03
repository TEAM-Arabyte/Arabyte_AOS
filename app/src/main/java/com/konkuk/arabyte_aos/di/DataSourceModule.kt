package com.konkuk.arabyte_aos.di

import com.konkuk.arabyte_aos.data.datalocal.datasource.DummyLocalDataSource
import com.konkuk.arabyte_aos.data.datalocal.datasourceimpl.DummyLocalDataSourceImpl
import com.konkuk.arabyte_aos.data.dataremote.datasource.DummyRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.datasourceimpl.DummyRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsDummyRemoteDataSource(dummyRemoteDataSourceImpl: DummyRemoteDataSourceImpl): DummyRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsDummyLocalDataSource(dummyLocalDataSourceImpl: DummyLocalDataSourceImpl): DummyLocalDataSource
}
