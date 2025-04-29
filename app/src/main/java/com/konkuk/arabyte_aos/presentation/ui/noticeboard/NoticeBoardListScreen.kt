package com.konkuk.arabyte_aos.presentation.ui.noticeboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteNoticeBoardCategoryType
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteNoticeBoardItem
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteAddFloatingButton
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteNoticeBoardCategoryButton
import com.konkuk.arabyte_aos.presentation.util.HandleDoubleBackToExit
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun NoticeBoardListRoute(
    modifier: Modifier = Modifier,
    navigateToNoticeBoardDetail: () -> Unit = {},
    viewModel: NoticeBoardListViewModel = hiltViewModel(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    HandleDoubleBackToExit()
    NoticeBoardListScreen(
        categoryOnClick = { viewModel.setEvent(NoticeBoardListContract.NoticeBoardListUiEvent.SelectCategory(it)) },
        addNoticeBoardButtonClicked = {},
        navigateToNoticeBoardDetail = navigateToNoticeBoardDetail,
        modifier = modifier,
        uiState = uiState,
        innerPaddingValues = innerPaddingValues,
    )
}

@Composable
fun NoticeBoardListScreen(
    categoryOnClick: (ArabyteNoticeBoardCategoryType) -> Unit,
    addNoticeBoardButtonClicked: () -> Unit,
    navigateToNoticeBoardDetail: () -> Unit = {},
    modifier: Modifier = Modifier,
    uiState: NoticeBoardListContract.NoticeBoardListUiState = NoticeBoardListContract.NoticeBoardListUiState(),
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
            modifier = Modifier.fillMaxSize(),
        ) {
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_notice_board_list_note_24),
                    contentDescription = null,
                    tint = Color.Unspecified,
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(text = "게시판", style = ArabyteTheme.typography.bodyBold17, color = ArabyteTheme.colors.black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_all_search_24),
                    contentDescription = null,
                    tint = Color.Unspecified,
                )
            }
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ArabyteNoticeBoardCategoryType.entries.forEach { item ->
                    ArabyteNoticeBoardCategoryButton(
                        noticeBoardCategoryType = item,
                        enabled = uiState.selectedCategory == item,
                        modifier = Modifier.padding(end = 6.dp),
                        buttonClicked = { categoryOnClick(item) },
                    )
                }
            }
            Text(
                text = "전체 ${uiState.noticeBoardList.size}",
                style = ArabyteTheme.typography.capMed11,
                color = ArabyteTheme.colors.gray06,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 17.dp, top = 15.dp, bottom = 8.dp),
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {
                items(
                    items = uiState.noticeBoardList,
                    key = { it.noticeBoardItemId },
                ) { noticeBoardItem ->
                    ArabyteNoticeBoardItem(
                        noticeBoardItem = noticeBoardItem,
                        navigateToNoticeBoardDetail = navigateToNoticeBoardDetail,
                    )
                }
            }
        }
        ArabyteAddFloatingButton(
            modifier =
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 82.dp, end = 16.dp),
            buttonText = stringResource(R.string.button_add_review),
            buttonClicked = addNoticeBoardButtonClicked,
        )
    }
}
