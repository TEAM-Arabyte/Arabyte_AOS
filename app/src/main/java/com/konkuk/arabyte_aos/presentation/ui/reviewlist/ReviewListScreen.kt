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
import androidx.compose.runtime.LaunchedEffect
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
import com.konkuk.arabyte_aos.domain.model.LocationData
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteFilteringType
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteReviewItem
import com.konkuk.arabyte_aos.presentation.ui.component.bottomsheet.ArabyteCategoryBottomSheet
import com.konkuk.arabyte_aos.presentation.ui.component.bottomsheet.ArabyteLocationBottomSheet
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteAddFloatingButton
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteFilteringButton
import com.konkuk.arabyte_aos.presentation.ui.component.view.ArabyteEmptyView
import com.konkuk.arabyte_aos.presentation.util.HandleDoubleBackToExit
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ReviewListRoute(
    modifier: Modifier = Modifier,
    navigateToReviewDetail: (reviewId: Int) -> Unit = {},
    navigateToReviewWrite: () -> Unit = {},
    viewModel: ReviewListViewModel = hiltViewModel(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    HandleDoubleBackToExit()
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(Unit) {
        viewModel.setEvent(ReviewListContract.ReviewListEvent.LoadSidoList)
        viewModel.setEvent(ReviewListContract.ReviewListEvent.LoadReviewList)
    }

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is ReviewListContract.ReviewListSideEffect.NavigateToReviewDetail -> {
                        navigateToReviewDetail(sideEffect.reviewId)
                    }

                    is ReviewListContract.ReviewListSideEffect.NavigateToReviewWrite -> navigateToReviewWrite()
                }
            }
    }

    ReviewListScreen(
        uiState = uiState,
        innerPaddingValues = innerPaddingValues,
        checkFilterClicked = {
            viewModel.setEvent(ReviewListContract.ReviewListEvent.ClickCertifiedFilterButton)
        },
        changeRegionBottomSheetVisible = {
            viewModel.setEvent(ReviewListContract.ReviewListEvent.ChangeRegionBottomSheetVisible)
        },
        regionBottomSheetCompleteButtonClicked = {
            viewModel.setEvent(ReviewListContract.ReviewListEvent.SetRegionFilter)
        },
        sidoOnclick = { sido ->
            viewModel.setEvent(ReviewListContract.ReviewListEvent.SelectSido(sido))
        },
        guOnclick = { gu ->
            viewModel.setEvent(ReviewListContract.ReviewListEvent.SelectGu(gu))
        },
        dongOnclick = { dong ->
            viewModel.setEvent(ReviewListContract.ReviewListEvent.SelectDong(dong))
        },
        resetRegionFilter = {
            viewModel.setEvent(ReviewListContract.ReviewListEvent.ResetRegionFilter)
        },
        resetAllButtonClicked = {
            viewModel.setEvent(ReviewListContract.ReviewListEvent.ResetAllFilter)
        },
        changeCategoryBottomSheetVisible = {
            viewModel.setEvent(ReviewListContract.ReviewListEvent.ChangeCategoryBottomSheetVisible)
        },
        categoryChipClicked = { category ->
            viewModel.setEvent(ReviewListContract.ReviewListEvent.SelectJobCategory(category = category))
        },
        categoryBottomSheetCompleteButtonClicked = {
            viewModel.setEvent(ReviewListContract.ReviewListEvent.ClickCategoryBottomSheetCompleteButton)
        },
        resetCategoryFilter = {
            viewModel.setEvent(ReviewListContract.ReviewListEvent.ResetCategoryFilter)
        },
        reviewItemClicked = { reviewId ->
            viewModel.setSideEffect(ReviewListContract.ReviewListSideEffect.NavigateToReviewDetail(reviewId = reviewId))
        },
        addReviewButtonClicked = {
            viewModel.setSideEffect(ReviewListContract.ReviewListSideEffect.NavigateToReviewWrite)
        },
    )
}

@Composable
fun ReviewListScreen(
    modifier: Modifier = Modifier,
    uiState: ReviewListContract.ReviewListUiState = ReviewListContract.ReviewListUiState(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
    checkFilterClicked: () -> Unit = {},
    addReviewButtonClicked: () -> Unit = {},
    changeRegionBottomSheetVisible: () -> Unit = {},
    changeCategoryBottomSheetVisible: () -> Unit = {},
    regionBottomSheetCompleteButtonClicked: () -> Unit = {},
    resetRegionFilter: () -> Unit = {},
    sidoOnclick: (LocationData) -> Unit = {},
    guOnclick: (LocationData) -> Unit = {},
    dongOnclick: (LocationData) -> Unit = {},
    resetAllButtonClicked: () -> Unit = {},
    resetCategoryFilter: () -> Unit = {},
    categoryBottomSheetCompleteButtonClicked: () -> Unit = {},
    categoryChipClicked: (String) -> Unit = {},
    reviewItemClicked: (reviewId: Int) -> Unit = {},
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
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_review_list_pencil_24),
                    contentDescription = null,
                    tint = Color.Unspecified,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "리뷰", style = ArabyteTheme.typography.bodyBold17, color = ArabyteTheme.colors.black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_all_search_24),
                    contentDescription = null,
                    tint = Color.Unspecified,
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_all_refresh_30),
                    contentDescription = null,
                    modifier =
                        Modifier
                            .noRippleClickable { resetAllButtonClicked() },
                    tint = Color.Unspecified,
                )
                LazyRow(
                    modifier =
                        Modifier
                            .weight(1f)
                            .padding(start = 5.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                ) {
                    item {
                        ArabyteFilteringButton(
                            arabyteFilteringType = ArabyteFilteringType.CHECK,
                            enabled = uiState.certifiedFilterSelected,
                            buttonClicked = checkFilterClicked,
                        )
                    }
                    item {
                        ArabyteFilteringButton(
                            arabyteFilteringType = ArabyteFilteringType.REGION,
                            enabled = uiState.selectedRegion.isNotEmpty(),
                            buttonClicked = changeRegionBottomSheetVisible,
                            buttonText = uiState.selectedRegion,
                        )
                    }

                    item {
                        ArabyteFilteringButton(
                            arabyteFilteringType = ArabyteFilteringType.CATEGORY,
                            enabled = uiState.selectedCategory.isNotEmpty(),
                            buttonClicked = changeCategoryBottomSheetVisible,
                            buttonText = uiState.selectedCategory,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "전체 ${uiState.reviewList.size}",
                style = ArabyteTheme.typography.capMed11,
                color = ArabyteTheme.colors.gray06,
            )
            if (uiState.reviewList.isEmpty()) {
                ReviewListEmptyView()
            } else {
                Spacer(modifier = Modifier.height(11.dp))
                LazyColumn(verticalArrangement = Arrangement.spacedBy(11.dp)) {
                    items(
                        uiState.reviewList,
                        key = { it.reviewItemId },
                    ) { reviewItem ->
                        ArabyteReviewItem(
                            reviewItem = reviewItem,
                            modifier =
                                Modifier.noRippleClickable {
                                    reviewItemClicked(reviewItem.reviewItemId)
                                },
                        )
                    }
                }
            }
        }
        ArabyteAddFloatingButton(
            modifier =
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 21.dp, end = 16.dp),
            buttonText = stringResource(R.string.button_add_review),
            buttonClicked = addReviewButtonClicked,
        )

        if (uiState.regionBottomSheetVisible) {
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(ArabyteTheme.colors.black.copy(alpha = 0.3f))
                        .noRippleClickable {
                            changeRegionBottomSheetVisible()
                            if (uiState.selectedRegion.isEmpty()) resetRegionFilter()
                        },
            )
            ArabyteLocationBottomSheet(
                modifier = Modifier.align(Alignment.BottomCenter),
                bottomSheetClose = resetRegionFilter,
                completeButtonClicked = { regionBottomSheetCompleteButtonClicked() },
                selectedSido = uiState.selectedSido,
                sidoList = uiState.sidoList,
                sidoOnclick = { sido ->
                    sidoOnclick(sido)
                },
                selectedGu = uiState.selectedGu,
                guList = uiState.guList,
                guOnclick = { gu ->
                    guOnclick(gu)
                },
                selectedDong = uiState.selectedDong,
                dongList = uiState.dongList,
                dongOnclick = { dong ->
                    dongOnclick(dong)
                },
            )
        }

        if (uiState.categoryBottomSheetVisible) {
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(ArabyteTheme.colors.black.copy(alpha = 0.3f))
                        .noRippleClickable {
                            changeCategoryBottomSheetVisible()
                            if (uiState.selectedCategory.isEmpty()) resetCategoryFilter()
                        },
            )

            ArabyteCategoryBottomSheet(
                modifier = Modifier.align(Alignment.BottomCenter),
                bottomSheetClose = resetCategoryFilter,
                completeButtonClicked = categoryBottomSheetCompleteButtonClicked,
                selectedCategories = uiState.selectedCategories,
                categoryChipClicked = categoryChipClicked,
            )
        }
    }
}

@Preview
@Composable
private fun ReviewListScreenPreview() {
    ArabyteAOSTheme { ReviewListScreen() }
}
