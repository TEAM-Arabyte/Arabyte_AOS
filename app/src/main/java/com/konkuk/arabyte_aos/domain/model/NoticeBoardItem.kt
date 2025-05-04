package com.konkuk.arabyte_aos.domain.model

import com.konkuk.arabyte_aos.presentation.type.component.ArabyteNoticeBoardCategoryType

// Todo : 없애도 될듯?
data class NoticeBoardItem(
    val noticeBoardItemId: Int,
    val title: String,
    val text: String,
    val likeCount: Int,
    val commentCount: Int,
    val uploadAt: String,
    val thumbnailImage: String,
    val noticeBoardCategoryType: ArabyteNoticeBoardCategoryType,
    val isLiked: Boolean,
)
