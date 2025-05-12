package com.konkuk.arabyte_aos.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteCategoryType
import com.konkuk.arabyte_aos.presentation.ui.home.component.HomeCollapsedTopBar
import com.konkuk.arabyte_aos.presentation.ui.home.component.HomeExpandedTopBarContent
import com.konkuk.arabyte_aos.presentation.ui.home.component.HomeScreenContent
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme

@Composable
fun HomeRoute(
    onNavigateToNoticeBoard: () -> Unit,
    onNavigateToNoticeBoardDetail: (Long) -> Unit,
    onNavigateToReviewList: () -> Unit,
    onNavigateToReviewDetail: (Int) -> Unit,
    onNavigateToReviewCategory: (ArabyteCategoryType) -> Unit,
    onNavigateToMyPage: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(Unit) {
        viewModel.setEvent(HomeContract.HomeEvent.LoadUserName)
        viewModel.setEvent(HomeContract.HomeEvent.LoadRegion)
        viewModel.setEvent(HomeContract.HomeEvent.LoadReviewList)
        viewModel.setEvent(HomeContract.HomeEvent.LoadNoticeBoardList)
    }
    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is HomeContract.HomeSideEffect.NavigateToNoticeBoard -> onNavigateToNoticeBoard()
                    is HomeContract.HomeSideEffect.NavigateToNoticeBoardDetail -> onNavigateToNoticeBoardDetail(sideEffect.articleId)
                    is HomeContract.HomeSideEffect.NavigateToReviewList -> onNavigateToReviewList()
                    is HomeContract.HomeSideEffect.NavigateToReviewCategory -> onNavigateToReviewCategory(sideEffect.categoryType)
                    is HomeContract.HomeSideEffect.NavigateToReviewDetail -> onNavigateToReviewDetail(sideEffect.reviewId)
                    is HomeContract.HomeSideEffect.NavigateToMyPage -> onNavigateToMyPage()
                }
            }
    }

    HomeScreen(
        onNavigateToNoticeBoard = { viewModel.setSideEffect(HomeContract.HomeSideEffect.NavigateToNoticeBoard) },
        onNavigateToNoticeBoardDetail = { viewModel.setSideEffect(HomeContract.HomeSideEffect.NavigateToNoticeBoardDetail(it)) },
        onNavigateToReviewList = { viewModel.setSideEffect(HomeContract.HomeSideEffect.NavigateToReviewList) },
        onNavigateToReviewDetail = { viewModel.setSideEffect(HomeContract.HomeSideEffect.NavigateToReviewDetail(it)) },
        onNavigateToReviewCategory = { viewModel.setSideEffect(HomeContract.HomeSideEffect.NavigateToReviewCategory(it)) },
        onNavigateToMyPage = { viewModel.setSideEffect(HomeContract.HomeSideEffect.NavigateToMyPage) },
        modifier = modifier,
        uiState = uiState,
        innerPaddingValues = innerPaddingValues,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    onNavigateToNoticeBoard: () -> Unit,
    onNavigateToNoticeBoardDetail: (Long) -> Unit,
    onNavigateToReviewList: () -> Unit,
    onNavigateToReviewDetail: (Int) -> Unit,
    onNavigateToReviewCategory: (ArabyteCategoryType) -> Unit,
    onNavigateToMyPage: () -> Unit,
    modifier: Modifier = Modifier,
    uiState: HomeContract.HomeUiState = HomeContract.HomeUiState(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    val scrollState = rememberLazyListState()
    val expandedTopBarIndex = 0
    var topBarHeightPx by remember { mutableIntStateOf(0) }
    val showCollapsedTopBar by remember {
        derivedStateOf {
            val index = scrollState.firstVisibleItemIndex
            val offset = scrollState.firstVisibleItemScrollOffset
            val threshold = (topBarHeightPx * 0.5f).toInt()
            index > expandedTopBarIndex || (index == expandedTopBarIndex && offset > threshold)
        }
    }

    LazyColumn(
        state = scrollState,
        modifier =
            modifier
                .fillMaxSize()
                .padding(innerPaddingValues),
    ) {
        item {
            HomeExpandedTopBarContent(
                uiState = uiState,
                modifier =
                    Modifier
                        .onGloballyPositioned { layoutCoordinates ->
                            topBarHeightPx = layoutCoordinates.size.height
                        },
            )
        }
        if (showCollapsedTopBar) {
            stickyHeader {
                HomeCollapsedTopBar()
            }
        }
        item {
            HomeScreenContent(
                uiState = uiState,
                onNavigateToNoticeBoard = {},
                onNavigateToNoticeBoardDetail = {},
                onNavigateToReviewList = {},
                onNavigateToReviewDetail = {},
                onNavigateToReviewCategory = {},
                onNavigateToMyPage = {},
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev() {
    ArabyteAOSTheme {
        HomeRoute(
            onNavigateToNoticeBoard = {},
            onNavigateToNoticeBoardDetail = {},
            onNavigateToReviewList = {},
            onNavigateToReviewDetail = {},
            onNavigateToReviewCategory = {},
            onNavigateToMyPage = {},
        )
    }
}
