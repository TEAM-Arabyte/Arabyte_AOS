package com.konkuk.arabyte_aos.di

import com.konkuk.arabyte_aos.data.datalocal.datasource.DummyLocalDataSource
import com.konkuk.arabyte_aos.data.datalocal.datasource.UserInfoLocalDataSource
import com.konkuk.arabyte_aos.data.datalocal.datasourceimpl.DummyLocalDataSourceImpl
import com.konkuk.arabyte_aos.data.datalocal.datasourceimpl.UserInfoLocalDataSourceImpl
import com.konkuk.arabyte_aos.data.dataremote.datasource.AuthRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.datasource.DummyRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.datasource.LocationsRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.datasourceimpl.AuthRemoteDataSourceImpl
import com.konkuk.arabyte_aos.data.dataremote.datasourceimpl.DummyRemoteDataSourceImpl
import com.konkuk.arabyte_aos.data.dataremote.datasourceimpl.LocationsRemoteDataSourceImpl
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

    @Binds
    @Singleton
    abstract fun bindsUserInfoLocalDataSource(userInfoLocalDataSourceImpl: UserInfoLocalDataSourceImpl): UserInfoLocalDataSource

    @Binds
    @Singleton
    abstract fun bindsLocationsDataSource(locationsRemoteDataSourceImpl: LocationsRemoteDataSourceImpl): LocationsRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsAuthDataSource(authRemoteDataSourceImpl: AuthRemoteDataSourceImpl): AuthRemoteDataSource
}
