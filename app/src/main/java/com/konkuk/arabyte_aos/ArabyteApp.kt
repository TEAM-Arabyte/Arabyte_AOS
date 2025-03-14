package com.konkuk.arabyte_aos

import android.app.Application
import android.content.pm.PackageManager
import android.os.Build
import android.util.Base64
import androidx.appcompat.app.AppCompatDelegate
import com.kakao.sdk.common.KakaoSdk
import com.konkuk.arabyte_aos.BuildConfig.KAKAO_NATIVE_APP_KEY
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import dagger.hilt.android.HiltAndroidApp
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

@HiltAndroidApp
class ArabyteApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setDarkMode()
        setKakao()
    }

    private fun setDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun setKakao() {
        getKeyHash()
        KakaoSdk.init(this, KAKAO_NATIVE_APP_KEY)
    }

    private fun getKeyHash() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val packageInfo = this.packageManager.getPackageInfo(this.packageName, PackageManager.GET_SIGNING_CERTIFICATES)
            for (signature in packageInfo.signingInfo?.apkContentsSigners!!) {
                try {
                    val md = MessageDigest.getInstance("SHA")
                    md.update(signature.toByteArray())
                    DebugLog.d("ArabyteApp", "kakao key hash: ${Base64.encodeToString(md.digest(), Base64.NO_WRAP)}")
                } catch (e: NoSuchAlgorithmException) {
                    DebugLog.w("ArabyteApp", "Unable to get MessageDigest. signature=$signature", e)
                }
            }
        }
    }
}
