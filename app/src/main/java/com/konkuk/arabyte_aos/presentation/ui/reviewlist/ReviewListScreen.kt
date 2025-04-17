package com.konkuk.arabyte_aos.presentation.ui.reviewlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteFilteringType
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteReviewItem
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteAddFloatingButton
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteFilteringButton
import com.konkuk.arabyte_aos.presentation.ui.component.view.ArabyteEmptyView
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ReviewListRoute(
    modifier: Modifier = Modifier,
    viewModel: ReviewListViewModel = hiltViewModel(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    ReviewListScreen(uiState = uiState, innerPaddingValues = innerPaddingValues)
}

@Composable
fun ReviewListScreen(
    modifier: Modifier = Modifier,
    uiState: ReviewListContract.ReviewListUiState = ReviewListContract.ReviewListUiState(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    Box(
        modifier =
            modifier
                .fillMaxSize()
                .background(color = ArabyteTheme.colors.white)
                .padding(innerPaddingValues),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
        ) {
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_review_list_pencil_24), contentDescription = null, tint = Color.Unspecified)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "리뷰", style = ArabyteTheme.typography.bodyBold17, color = ArabyteTheme.colors.black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_search_24), contentDescription = null, tint = Color.Unspecified)
            }
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                item {
                    ArabyteFilteringButton(
                        arabyteFilteringType = ArabyteFilteringType.CHECK,
                        enabled = uiState.checkFilterSelected,
                        buttonClicked = { },
                    )
                }
                item {
                    ArabyteFilteringButton(
                        arabyteFilteringType = ArabyteFilteringType.REGION,
                        enabled = uiState.regionFilterSelected,
                        buttonClicked = { },
                    )
                }

                item {
                    ArabyteFilteringButton(
                        arabyteFilteringType = ArabyteFilteringType.CATEGORY,
                        enabled = uiState.categoryFilterSelected,
                        buttonClicked = { },
                    )
                }
                item {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_all_refresh_22),
                        contentDescription = null,
                        modifier =
                            Modifier
                                .padding(4.dp)
                                .noRippleClickable { },
                        tint = ArabyteTheme.colors.gray05,
                    )
                }
            }
            if (uiState.listSize == 0) {
                ArabyteEmptyView()
            } else {
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "전체 ${uiState.listSize}", style = ArabyteTheme.typography.capMed11, color = ArabyteTheme.colors.gray06)
                Spacer(modifier = Modifier.height(11.dp))
                LazyColumn(verticalArrangement = Arrangement.spacedBy(11.dp)) {
                    items(uiState.reviewList) { reviewItem ->
                        ArabyteReviewItem(reviewItem)
                    }
                }
            }
        }
        ArabyteAddFloatingButton(
            modifier = Modifier.align(Alignment.BottomEnd).padding(bottom = 82.dp, end = 16.dp),
            buttonText = stringResource(R.string.button_add_review),
            buttonClicked = {},
        )
    }
}

@Preview
@Composable
private fun ReviewListScreenPreview() {
    ArabyteAOSTheme { ReviewListScreen() }
}
