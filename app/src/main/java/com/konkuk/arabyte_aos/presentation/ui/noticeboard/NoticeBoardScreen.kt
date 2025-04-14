package com.konkuk.arabyte_aos.presentation.ui.noticeboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NoticeBoardRoute(
    paddingValues: PaddingValues,
    // navigateToMyInfoScreen : ()->Unit,
    modifier: Modifier = Modifier,
    viewModel: NoticeBoardViewModel = hiltViewModel(),
) {
    NoticeBoardScreen(
        paddingValues = paddingValues,
        modifier = modifier,
        viewModel = viewModel,
    )
}

@Composable
fun NoticeBoardScreen(
    paddingValues: PaddingValues,
    // navigateToMyInfoScreen : ()->Unit,
    modifier: Modifier = Modifier,
    viewModel: NoticeBoardViewModel = hiltViewModel(),
) {
    Column(
        modifier =
            modifier
                .fillMaxSize(),
    ) {
        Text(text = "NoticeBoard")
    }
}
