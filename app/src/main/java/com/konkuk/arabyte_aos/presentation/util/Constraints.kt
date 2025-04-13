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

    const val FIRST_KEYWORD = "닉네임"
    const val SECOND_KEYWORD = "간단한 정보"

    const val ONE = "1"
    const val SLASH_TWO = "/2"
    const val TWO_SLASH_TWO = "2/2"

    private const val NICKNAME_IDLE_MESSAGE = ""
    private const val NICKNAME_VALID_MESSAGE = "닉네임은 공백 없이 한글로만 입력 가능합니다"
    private const val NICKNAME_INVALID_MESSAGE = "사용가능한 닉네임 입니다"

    val errorMessageList = listOf(NICKNAME_IDLE_MESSAGE, NICKNAME_VALID_MESSAGE, NICKNAME_INVALID_MESSAGE)

    private val fullToShortMap =
        mapOf(
            "서울특별시" to "서울",
            "부산광역시" to "부산",
            "대구광역시" to "대구",
            "인천광역시" to "인천",
            "광주광역시" to "광주",
            "대전광역시" to "대전",
            "울산광역시" to "울산",
            "세종특별자치시" to "세종",
            "경기도" to "경기",
            "강원도" to "강원",
            "충청북도" to "충북",
            "충청남도" to "충남",
            "전라북도" to "전북",
            "전라남도" to "전남",
            "경상북도" to "경북",
            "경상남도" to "경남",
            "제주특별자치도" to "제주",
        )

    private val shortToFullMap = fullToShortMap.entries.associate { (k, v) -> v to k }

    fun sidoShortName(fullName: String): String = fullToShortMap[fullName] ?: fullName

    fun sidoFullName(shortName: String): String = shortToFullMap[shortName] ?: shortName

    val sidoList =
        listOf(
            "서울특별시",
            "부산광역시",
            "대구광역시",
            "인천광역시",
            "광주광역시",
            "대전광역시",
            "울산광역시",
            "세종특별자치시",
            "경기도",
            "강원도",
            "충청북도",
            "충청남도",
            "전라북도",
            "전라남도",
            "경상북도",
            "경상남도",
            "제주특별자치도",
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

object Onboarding {
    private const val CATEGORY_FOOD = "외식/음료"
    private const val CATEGORY_MANAGEMENT = "매장관리/판매"
    private const val CATEGORY_SERVICE = "서비스"
    private const val CATEGORY_CONSULTING = "고객상담/영업"
    private const val CATEGORY_PRODUCTION = "생산/건설"
    private const val CATEGORY_TECH = "IT/기술"
    private const val CATEGORY_DESIGN = "디자인"
    private const val CATEGORY_OFFICE = "사무직"
    private const val CATEGORY_EDUCATION = "교육/강사"
    private const val CATEGORY_DELIVERY = "운전/배달"
    private const val CATEGORY_MEDIA = "미디어"
    private const val CATEGORY_MEDICAL = "병원/간호/연구"

    val categoryList =
        listOf(
            CATEGORY_FOOD,
            CATEGORY_MANAGEMENT,
            CATEGORY_SERVICE,
            CATEGORY_CONSULTING,
            CATEGORY_PRODUCTION,
            CATEGORY_TECH,
            CATEGORY_DESIGN,
            CATEGORY_OFFICE,
            CATEGORY_EDUCATION,
            CATEGORY_DELIVERY,
            CATEGORY_MEDIA,
            CATEGORY_MEDICAL,
        )
}
