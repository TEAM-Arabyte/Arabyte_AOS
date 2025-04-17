package com.konkuk.arabyte_aos.data.datalocal.datasourceimpl

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.kakao.sdk.auth.Constants.ACCESS_TOKEN
import com.kakao.sdk.auth.Constants.REFRESH_TOKEN
import com.konkuk.arabyte_aos.BuildConfig
import com.konkuk.arabyte_aos.data.datalocal.datasource.UserInfoLocalDataSource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserInfoLocalDataSourceImpl
    @Inject
    constructor(
        @ApplicationContext context: Context,
    ) : UserInfoLocalDataSource {
        private val masterKey =
            MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()

        private val sharedPreferences: SharedPreferences =
            if (BuildConfig.DEBUG) {
                context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
            } else {
                EncryptedSharedPreferences.create(
                    context,
                    FILE_NAME,
                    masterKey,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
                )
            }

        override var accessToken: String
            get() = getValue(ACCESS_TOKEN)
            set(value) = setValue(ACCESS_TOKEN, value)

        override var refreshToken: String
            get() = getValue(REFRESH_TOKEN)
            set(value) = setValue(REFRESH_TOKEN, value)

        override fun clear() {
            setValue(REFRESH_TOKEN, "")
            setValue(ACCESS_TOKEN, "")
        }

        private fun getValue(key: String): String =
            sharedPreferences.getString(key, INITIAL_VALUE).orEmpty()

        private fun setValue(
            key: String,
            value: String,
        ) =
            sharedPreferences.edit { putString(key, value) }

        companion object {
            private const val FILE_NAME = "ArabyteLocalDataSource"
            private const val INITIAL_VALUE = ""
        }
    }
