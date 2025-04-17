package com.konkuk.arabyte_aos.presentation.model

enum class ArabyteJobCategory(val label: String) {
    FOOD("외식/음료"),
    SALES("매장관리/판매"),
    SERVICE("서비스"),
    CONSULTING("고객상담/영업"),
    MANUFACTURING("생산/건설"),
    IT("IT/기술"),
    DESIGN("디자인"),
    OFFICE("사무직"),
    EDUCATION("교육/강사"),
    DELIVERY("운전/배달"),
    MEDIA("미디어"),
    MEDICAL("병원/간호/연구"),
    ;

    companion object {
        private val categoryList = entries

        fun fromLabel(label: String): ArabyteJobCategory? {
            return categoryList.find { it.label == label }
        }
    }
}
