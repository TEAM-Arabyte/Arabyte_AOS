package com.konkuk.arabyte_aos.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteCategoryType
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteNoticeBoardItem
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteReviewItem
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteCategoryButton
import com.konkuk.arabyte_aos.presentation.ui.home.component.HomeContentTitle
import com.konkuk.arabyte_aos.presentation.ui.home.component.HomePagerIndicator
import com.konkuk.arabyte_aos.presentation.ui.home.component.HomeRegionChip
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun HomeRoute(
    onNavigateToNoticeBoard: () -> Unit,
    onNavigateToNoticeBoardDetail: (Int) -> Unit,
    onNavigateToReview: () -> Unit,
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
    }
    LaunchedEffect(Unit) {
        viewModel.setEvent(HomeContract.HomeEvent.LoadRegion)
    }
    LaunchedEffect(Unit) {
        viewModel.setEvent(HomeContract.HomeEvent.LoadReviewList)
    }
    LaunchedEffect(Unit) {
        viewModel.setEvent(HomeContract.HomeEvent.LoadNoticeBoardList)
    }
    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is HomeContract.HomeSideEffect.NavigateToNoticeBoard -> onNavigateToNoticeBoard()
                    is HomeContract.HomeSideEffect.NavigateToNoticeBoardDetail -> onNavigateToNoticeBoardDetail(sideEffect.noticeBoardId)
                    is HomeContract.HomeSideEffect.NavigateToReview -> onNavigateToReview()
                    is HomeContract.HomeSideEffect.NavigateToReviewCategory -> onNavigateToReviewCategory(sideEffect.categoryType)
                    is HomeContract.HomeSideEffect.NavigateToReviewDetail -> onNavigateToReviewDetail(sideEffect.reviewId)
                    is HomeContract.HomeSideEffect.NavigateToMyPage -> onNavigateToMyPage()
                }
            }
    }

    HomeScreen(
        onNavigateToNoticeBoard = onNavigateToNoticeBoard,
        onNavigateToNoticeBoardDetail = onNavigateToNoticeBoardDetail,
        onNavigateToReview = onNavigateToReview,
        onNavigateToReviewDetail = onNavigateToReviewDetail,
        onNavigateToReviewCategory = onNavigateToReviewCategory,
        onNavigateToMyPage = onNavigateToMyPage,
        modifier = modifier,
        uiState = uiState,
        innerPaddingValues = innerPaddingValues,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    onNavigateToNoticeBoard: () -> Unit,
    onNavigateToNoticeBoardDetail: (Int) -> Unit,
    onNavigateToReview: () -> Unit,
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
            ExpandedTopBarContent(
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
                CollapsedTopBar()
            }
        }
        item {
            HomeScreenContent(
                uiState = uiState,
                onNavigateToNoticeBoard = {},
                onNavigateToNoticeBoardDetail = {},
                onNavigateToReview = {},
                onNavigateToReviewDetail = {},
                onNavigateToReviewCategory = {},
                onNavigateToMyPage = {},
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreenContent(
    uiState: HomeContract.HomeUiState,
    onNavigateToNoticeBoard: () -> Unit,
    onNavigateToNoticeBoardDetail: (Int) -> Unit,
    onNavigateToReview: () -> Unit,
    onNavigateToReviewDetail: (Int) -> Unit,
    onNavigateToReviewCategory: (ArabyteCategoryType) -> Unit,
    onNavigateToMyPage: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val categoryList =
        remember {
            listOf(
                ArabyteCategoryType.FOOD,
                ArabyteCategoryType.MANAGEMENT,
                ArabyteCategoryType.SERVICE,
                ArabyteCategoryType.TECH,
                ArabyteCategoryType.PRODUCTION,
                ArabyteCategoryType.DESIGN,
                ArabyteCategoryType.EDUCATION,
                ArabyteCategoryType.OFFICE,
            )
        }
    val pagerState =
        rememberPagerState(
            initialPage = 0,
            pageCount = { 3 },
        )

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.height(14.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalArrangement = Arrangement.spacedBy(9.dp),
            maxItemsInEachRow = 4,
        ) {
            categoryList.forEach { category ->
                ArabyteCategoryButton(categoryType = category) {
                    onNavigateToReviewCategory(category)
                }
            }
        }
        Spacer(Modifier.height(28.dp))
        HomeContentTitle(
            titleResId = R.string.home_review_title,
            subtitleResId = R.string.home_review_sub_title,
            onClickMore = {},
            modifier = Modifier.padding(horizontal = 20.dp),
        )
        Spacer(Modifier.height(11.dp))
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally),
        ) { page ->
            ArabyteReviewItem(
                reviewItem = uiState.reviewList[page],
                modifier = Modifier.padding(horizontal = 20.dp),
            )
        }
        Spacer(Modifier.height(11.dp))
        HomePagerIndicator(
            pageCount = 3,
            currentPage = pagerState.currentPage,
        )
        Spacer(Modifier.height(30.dp))
        HomeContentTitle(
            titleResId = R.string.home_notice_board_title,
            subtitleResId = R.string.home_notice_board_sub_title,
            modifier = Modifier.padding(horizontal = 20.dp),
            onClickMore = {},
        )
        Spacer(Modifier.height(11.dp))
        uiState.noticeBoardItem.forEachIndexed { index, item ->
            ArabyteNoticeBoardItem(
                noticeBoardItem = item,
                navigateToReviewDetail = {},
            )
        }
    }
}

@Composable
fun ExpandedTopBarContent(
    uiState: HomeContract.HomeUiState,
    modifier: Modifier = Modifier,
) {
    val topBarText = stringResource(id = R.string.home_top_bar)
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .background(
                    color = ArabyteTheme.colors.gray01,
                    shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp),
                )
                .padding(top = 30.dp, start = 16.dp, end = 16.dp, bottom = 23.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text =
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = ArabyteTheme.colors.mainBlue)) {
                            append(text = uiState.userName)
                        }
                        withStyle(style = SpanStyle(color = ArabyteTheme.colors.black)) {
                            append(text = topBarText)
                        }
                    },
                style = ArabyteTheme.typography.titleBold18,
            )
            HomeRegionChip(
                region = uiState.region,
                buttonClicked = {},
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.img_home_character),
            contentDescription = null,
        )
    }
}

@Composable
fun CollapsedTopBar() {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    color = ArabyteTheme.colors.gray01,
                    shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp),
                )
                .padding(start = 5.dp, top = 5.dp, bottom = 10.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_logo), contentDescription = null, tint = ArabyteTheme.colors.mainBlue)
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev() {
    ArabyteAOSTheme {
        HomeRoute(
            onNavigateToNoticeBoard = {},
            onNavigateToNoticeBoardDetail = {},
            onNavigateToReview = {},
            onNavigateToReviewDetail = {},
            onNavigateToReviewCategory = {},
            onNavigateToMyPage = {},
        )
    }
}
