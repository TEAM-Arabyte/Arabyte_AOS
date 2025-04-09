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

    private const val NICKNAME_IDLE_MESSAGE = ""
    private const val NICKNAME_VALID_MESSAGE = "닉네임은 공백 없이 한글로만 입력 가능합니다"
    private const val NICKNAME_INVALID_MESSAGE = "사용가능한 닉네임 입니다"

    val errorMessageList = listOf(NICKNAME_IDLE_MESSAGE, NICKNAME_VALID_MESSAGE, NICKNAME_INVALID_MESSAGE)

    val sidoList =
        listOf(
            "서울",
            "부산",
            "대구",
            "인천",
            "광주",
            "대전",
            "울산",
            "세종",
            "경기",
            "강원",
            "충북",
            "충남",
            "전북",
            "전남",
            "경북",
            "경남",
            "제주",
        )
    val guList =
        listOf(
            "강남구",
            "강동구",
            "강북구",
            "강서구",
            "관악구",
            "광진구",
            "구로구",
            "금천구",
            "노원구",
            "도봉구",
            "동대문구",
            "동작구",
            "마포구",
            "서대문구",
            "서초구",
            "성동구",
            "성북구",
            "송파구",
            "양천구",
            "영등포구",
            "용산구",
            "은평구",
            "종로구",
            "중구",
            "중랑구",
        )
    val dongList =
        listOf(
            "개포동",
            "논현동",
            "대치동",
            "도곡동",
            "삼성동",
            "세곡동",
            "수서동",
            "신사동",
            "압구정동",
            "역삼동",
            "일원동",
            "청담동",
        )
}
