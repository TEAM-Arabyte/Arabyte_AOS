package com.konkuk.arabyte_aos.presentation.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteCategoryType
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteNoticeBoardItem
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteReviewItem
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteCategoryButton
import com.konkuk.arabyte_aos.presentation.ui.home.HomeContract

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreenContent(
    uiState: HomeContract.HomeUiState,
    onNavigateToNoticeBoard: () -> Unit,
    onNavigateToNoticeBoardDetail: (Int) -> Unit,
    onNavigateToReviewList: () -> Unit,
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
