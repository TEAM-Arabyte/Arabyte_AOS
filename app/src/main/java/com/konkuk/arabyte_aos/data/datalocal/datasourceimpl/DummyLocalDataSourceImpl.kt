package com.konkuk.arabyte_aos.data.datalocal.datasourceimpl

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.konkuk.arabyte_aos.data.datalocal.datasource.DummyLocalDataSource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DummyLocalDataSourceImpl @Inject constructor(
    @ApplicationContext context: Context
) : DummyLocalDataSource {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    override var token: String
        get() = sharedPreferences.getString(TOKEN, INITIAL_VALUE).toString()
        set(value) = sharedPreferences.edit { putString(TOKEN, value) }

    override var nickname: String
        get() = sharedPreferences.getString(NICKNAME, INITIAL_VALUE).toString()
        set(value) = sharedPreferences.edit { putString(NICKNAME, value) }

    override fun clear() = sharedPreferences.edit { clear() }

    companion object {
        private const val PREFERENCES_NAME = "user_preferences"
        private const val TOKEN = "token"
        private const val NICKNAME = "nickname"
        private const val INITIAL_VALUE = ""
    }
}
