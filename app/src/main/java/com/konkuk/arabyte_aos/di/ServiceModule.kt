package com.konkuk.arabyte_aos.di

import com.konkuk.arabyte_aos.data.dataremote.service.DummyService
import com.konkuk.arabyte_aos.data.dataremote.service.LocationsService
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
    @Singleton
    fun providesService(retrofit: Retrofit): DummyService =
        retrofit.create(DummyService::class.java)

    @Provides
    @Singleton
    fun providesLocationsService(retrofit: Retrofit): LocationsService =
        retrofit.create(LocationsService::class.java)
}
