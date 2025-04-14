package com.konkuk.arabyte_aos.presentation.ui.review

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.konkuk.arabyte_aos.presentation.type.ArabyteCategoryType

@Composable
fun ReviewRoute(
    paddingValues: PaddingValues,
    // navigateToReviewDetailScreen : () -> Unit
    categoryType: ArabyteCategoryType?,
    modifier: Modifier = Modifier,
    viewModel: ReviewViewModel = hiltViewModel(),
) {
    ReviewScreen(
        paddingValues = paddingValues,
        modifier = modifier,
        categoryType = categoryType,
        viewModel = viewModel,
    )
}

@Composable
fun ReviewScreen(
    paddingValues: PaddingValues,
    // navigateToReviewDetailScreen : () -> Unit
    categoryType: ArabyteCategoryType?,
    modifier: Modifier = Modifier,
    viewModel: ReviewViewModel = hiltViewModel(),
) {
    Column(
        modifier =
            modifier
                .fillMaxSize(),
    ) {
        Text("Review Screen")
        Text("Category: ${categoryType?.name ?: "전체"}")
    }
}
