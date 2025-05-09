package com.konkuk.arabyte_aos.presentation.util

import android.app.Activity
import android.content.Context
import com.konkuk.arabyte_aos.R
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.konkuk.arabyte_aos.presentation.util.context.arabyteToastMessage

@Composable
fun Context.HandleDoubleBackToExit() {
    var backPressedTime by remember { mutableLongStateOf(0L) }

    BackHandler {
        val currentTime = System.currentTimeMillis()
        if (currentTime - backPressedTime <= 2000) {
            (this as? Activity)?.finish()
        } else {
            backPressedTime = currentTime
            arabyteToastMessage(messageResId = R.string.toast_message_nickname_back_handler)
        }
    }
}
