package com.konkuk.arabyte_aos.presentation.model

enum class ArabyteJobCategory(val label: String) {
    FOOD_BEVERAGE("외식/음료"),
    STORE_MANAGEMENT_SALES("매장관리/판매"),
    SERVICE("서비스"),
    CUSTOMER_SALES("고객상담/영업"),
    PRODUCTION_CONSTRUCTION("생산/건설"),
    IT_TECH("IT/기술"),
    DESIGN("디자인"),
    OFFICE("사무직"),
    EDUCATION("교육/강사"),
    DELIVERY("운전/배달"),
    MEDIA("미디어"),
    HOSPITAL_NURSE_RESEARCH("병원/간호/연구"),
    ;

    companion object {
        private val categoryList = entries

        fun fromLabel(label: String): ArabyteJobCategory? {
            return categoryList.find { it.label == label }
        }
    }
}
