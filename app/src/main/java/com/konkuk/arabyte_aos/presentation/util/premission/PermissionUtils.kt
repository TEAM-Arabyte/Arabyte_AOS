package com.konkuk.arabyte_aos.presentation.util.premission

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat

object PermissionUtils {
    /**
     * 알림 권한이 필요한지 여부 (Android 13 이상만 true)
     */
    fun isNotificationPermissionRequired(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU
    }

    /**
     * 알림 권한이 부여되어 있는지 확인
     */
    fun isNotificationPermissionGranted(context: Context): Boolean {
        return if (!isNotificationPermissionRequired()) {
            true // Android 12 이하는 자동 허용
        } else {
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS,
            ) == PackageManager.PERMISSION_GRANTED
        }
    }
}
