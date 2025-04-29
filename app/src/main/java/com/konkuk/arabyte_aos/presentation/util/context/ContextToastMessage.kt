package com.konkuk.arabyte_aos.presentation.util.context

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.animation.TranslateAnimation
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import com.konkuk.arabyte_aos.R

fun Context.arabyteToastMessage(
    @StringRes messageResId: Int,
    length: Int = Toast.LENGTH_SHORT,
) {
    val layoutInflater = LayoutInflater.from(this)
    val layout = layoutInflater.inflate(R.layout.arabyte_toast, null)

    val textView = layout.findViewById<TextView>(R.id.arabyte_toast_message)
    textView.text = this.getString(messageResId)

    val toastContainer =
        FrameLayout(this).apply {
            setPadding(16, 0, 16, 0)
            addView(layout)
        }

    val toast =
        Toast(this).apply {
            duration = length
            view = toastContainer
        }

    val yOffsetDp = 12
    val yOffsetPx = (yOffsetDp * this.resources.displayMetrics.density).toInt()
    toast.setGravity(Gravity.TOP or Gravity.FILL_HORIZONTAL, 0, yOffsetPx)

    toast.show()

    val toastDurationMs =
        when (length) {
            Toast.LENGTH_SHORT -> 2000L
            Toast.LENGTH_LONG -> 3500L
            else -> 2000L
        }

    layout.postDelayed({
        val slideUp =
            TranslateAnimation(0f, 0f, 0f, -layout.height.toFloat()).apply {
                duration = 500L
                fillAfter = true
            }
        layout.startAnimation(slideUp)
    }, toastDurationMs - 500L)
}
