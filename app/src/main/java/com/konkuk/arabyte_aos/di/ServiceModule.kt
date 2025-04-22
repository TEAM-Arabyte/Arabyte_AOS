package com.konkuk.arabyte_aos.di

import com.konkuk.arabyte_aos.data.dataremote.service.AuthService
import com.konkuk.arabyte_aos.data.dataremote.service.DummyService
import com.konkuk.arabyte_aos.data.dataremote.service.LocationsService
import com.konkuk.arabyte_aos.data.dataremote.service.UserService
import com.konkuk.arabyte_aos.di.qualifier.Arabyte
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    fun providesService(
        @Arabyte retrofit: Retrofit,
    ): DummyService =
        retrofit.create(DummyService::class.java)

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
}
