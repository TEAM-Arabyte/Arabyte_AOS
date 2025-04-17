package com.konkuk.arabyte_aos.presentation.util.log

import android.text.TextUtils
import android.util.Log
import com.konkuk.arabyte_aos.BuildConfig

object DebugLog {
    fun d(
        tag: String?,
        message: String?,
    ) {
        if (BuildConfig.DEBUG && !TextUtils.isEmpty(message)) {
            Log.d(tag, message!!)
        }
    }

    fun d(
        tag: String?,
        message: String?,
        tr: Throwable?,
    ) {
        if (BuildConfig.DEBUG && !TextUtils.isEmpty(message)) {
            Log.d(tag, message, tr)
        }
    }

    fun w(
        tag: String?,
        message: String?,
    ) {
        if (BuildConfig.DEBUG && !TextUtils.isEmpty(message)) {
            Log.w(tag, message!!)
        }
    }

    fun w(
        tag: String?,
        message: String?,
        tr: Throwable?,
    ) {
        if (BuildConfig.DEBUG && !TextUtils.isEmpty(message)) {
            Log.w(tag, message, tr)
        }
    }

    fun e(
        tag: String?,
        message: String?,
    ) {
        if (BuildConfig.DEBUG && !TextUtils.isEmpty(message)) {
            Log.e(tag, message!!)
        }
    }

    fun e(
        tag: String?,
        message: String?,
        tr: Throwable?,
    ) {
        if (BuildConfig.DEBUG && !TextUtils.isEmpty(message)) {
            Log.e(tag, message, tr)
        }
    }

    fun i(
        tag: String?,
        message: String?,
    ) {
        if (BuildConfig.DEBUG && !TextUtils.isEmpty(message)) {
            Log.i(tag, message!!)
        }
    }

    fun i(
        tag: String?,
        message: String?,
        tr: Throwable?,
    ) {
        if (BuildConfig.DEBUG && !TextUtils.isEmpty(message)) {
            Log.i(tag, message, tr)
        }
    }
}
