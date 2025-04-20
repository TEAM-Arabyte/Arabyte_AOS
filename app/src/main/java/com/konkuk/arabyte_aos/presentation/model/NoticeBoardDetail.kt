package com.konkuk.arabyte_aos.presentation.model

data class NoticeBoardDetail(
    val profileImage: String,
    val nickname: String,
    val writeDate: String,
    val title: String,
    val content: String,
    val isLiked: Boolean,
    val commentList: List<NoticeBoardDetailComment>,
)
