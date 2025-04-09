package com.konkuk.arabyte_aos.presentation.util

object Login {
    const val PLATFORM = "KAKAO"
}

object Token {
    const val BEARER = "Bearer "
}

object SignUp {
    const val MALE = "남성"
    const val FEMALE = "여성"

    const val NICKNAME_IDLE_MESSAGE = ""
    const val NICKNAME_VALID_MESSAGE = "닉네임은 공백 없이 한글로만 입력 가능합니다"
    const val NICKNAME_INVALID_MESSAGE = "사용가능한 닉네임 입니다"

    val errorMessageList = listOf(NICKNAME_IDLE_MESSAGE, NICKNAME_VALID_MESSAGE, NICKNAME_INVALID_MESSAGE)
}
