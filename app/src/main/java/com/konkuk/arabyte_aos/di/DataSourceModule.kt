package com.konkuk.arabyte_aos.di

import com.konkuk.arabyte_aos.data.datalocal.datasource.UserInfoLocalDataSource
import com.konkuk.arabyte_aos.data.datalocal.datasourceimpl.UserInfoLocalDataSourceImpl
import com.konkuk.arabyte_aos.data.dataremote.datasource.AuthRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.datasource.CommentDataSource
import com.konkuk.arabyte_aos.data.dataremote.datasource.LocationsRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.datasource.MyPageRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.datasource.NoticeBoardRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.datasource.ReportRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.datasource.ReviewsRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.datasource.UserRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.datasourceimpl.AuthRemoteDataSourceImpl
import com.konkuk.arabyte_aos.data.dataremote.datasourceimpl.CommentDataSourceImpl
import com.konkuk.arabyte_aos.data.dataremote.datasourceimpl.LocationsRemoteDataSourceImpl
import com.konkuk.arabyte_aos.data.dataremote.datasourceimpl.MyPageRemoteDataSourceImpl
import com.konkuk.arabyte_aos.data.dataremote.datasourceimpl.NoticeBoardRemoteDataSourceImpl
import com.konkuk.arabyte_aos.data.dataremote.datasourceimpl.ReportRemoteDataSourceImpl
import com.konkuk.arabyte_aos.data.dataremote.datasourceimpl.ReviewsRemoteDataSourceImpl
import com.konkuk.arabyte_aos.data.dataremote.datasourceimpl.UserRemoteDataSourceImpl
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
    abstract fun bindsReportRemoteDataSource(reportRemoteDataSourceImpl: ReportRemoteDataSourceImpl): ReportRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsUserInfoLocalDataSource(userInfoLocalDataSourceImpl: UserInfoLocalDataSourceImpl): UserInfoLocalDataSource

    @Binds
    @Singleton
    abstract fun bindsUserRemoteDataSource(userRemoteDataSourceImpl: UserRemoteDataSourceImpl): UserRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsLocationsDataSource(locationsRemoteDataSourceImpl: LocationsRemoteDataSourceImpl): LocationsRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsAuthDataSource(authRemoteDataSourceImpl: AuthRemoteDataSourceImpl): AuthRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsNoticeBoardDataSource(noticeBoardRemoteDataSourceImpl: NoticeBoardRemoteDataSourceImpl): NoticeBoardRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsCommentDataSource(commentDataSourceImpl: CommentDataSourceImpl): CommentDataSource

    @Binds
    @Singleton
    abstract fun bindsReviewDataSource(reviewsRemoteDataSourceImpl: ReviewsRemoteDataSourceImpl): ReviewsRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsMyPageDataSource(myPageRemoteDataSourceImpl: MyPageRemoteDataSourceImpl): MyPageRemoteDataSource
}
