package com.konkuk.arabyte_aos.presentation.type.view

import androidx.annotation.StringRes
import com.konkuk.arabyte_aos.R

enum class SignUpType(
    @StringRes val titleStringRes: Int,
    val pageText:String,
    @StringRes val buttonTextStringRes : Int
) {
    FIRST(titleStringRes = R.string.sign_up_first_title, pageText = "1/2", buttonTextStringRes = R.string.sign_up_first_button),
    SECOND(titleStringRes = R.string.sign_up_second_title, pageText = "2/2",buttonTextStringRes = R.string.sign_up_second_button)
}
