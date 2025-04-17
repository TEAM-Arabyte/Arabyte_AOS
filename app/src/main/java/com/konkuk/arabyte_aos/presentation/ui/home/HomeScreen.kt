package com.konkuk.arabyte_aos.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteCategoryType
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    navigateToReview: (ArabyteCategoryType?) -> Unit,
    navigateToNoticeBoard: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    HomeScreen(
        paddingValues = paddingValues,
        navigateToReview = navigateToReview,
        navigateToNoticeBoard = navigateToNoticeBoard,
        modifier = modifier,
        viewModel = viewModel,
    )
}

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navigateToReview: (ArabyteCategoryType?) -> Unit,
    navigateToNoticeBoard: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .background(color = ArabyteTheme.colors.gray01)
                .padding(paddingValues),
    ) {
        Text(text = "Home")
        Button(onClick = { navigateToReview(ArabyteCategoryType.MANAGEMENT) }) { Text("Review") }
        Button(onClick = { navigateToNoticeBoard() }) { Text("NoticeBoard") }
    }
}
