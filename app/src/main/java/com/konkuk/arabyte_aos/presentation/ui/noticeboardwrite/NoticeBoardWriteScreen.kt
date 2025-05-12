package com.konkuk.arabyte_aos.presentation.ui.noticeboardwrite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteNoticeBoardCategoryType
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteTopAppBar
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteNoticeBoardCategoryButton
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteToggleButton
import com.konkuk.arabyte_aos.presentation.ui.component.chip.ArabyteInformationBox
import com.konkuk.arabyte_aos.presentation.ui.component.textfield.ArabyteLargeTextField
import com.konkuk.arabyte_aos.presentation.ui.component.textfield.ArabyteNormalTextField
import com.konkuk.arabyte_aos.presentation.ui.noticeboardwrite.component.NoticeBoardWriteRequiredLabel
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun NoticeBoardWriteRoute(
    navigateToBack: () -> Unit,
    navigateToNoticeBoardList: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: NoticeBoardWriteViewModel = hiltViewModel(),
    paddingValues: PaddingValues = PaddingValues(0.dp),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    NoticeBoardWriteContract.NoticeBoardWriteSideEffect.NavigateToBack -> navigateToBack()
                    NoticeBoardWriteContract.NoticeBoardWriteSideEffect.NavigateToNoticeBoardList -> navigateToNoticeBoardList()
                }
            }
    }

    NoticeBoardWriteScreen(
        navigateToBack = {
            viewModel.setSideEffect(NoticeBoardWriteContract.NoticeBoardWriteSideEffect.NavigateToBack)
        },
        writeCompleteButtonClicked = {
            // viewModel.setSideEffect(NoticeBoardWriteContract.NoticeBoardWriteSideEffect.NavigateToNoticeBoardList)
            viewModel.setEvent(NoticeBoardWriteContract.NoticeBoardWriteEvent.WriteCompleteButtonClicked)
        },
        categoryChipClicked = { click ->
            viewModel.setEvent(NoticeBoardWriteContract.NoticeBoardWriteEvent.CategoryClick(click))
        },
        anonymousChipClicked = { click ->
            viewModel.setEvent(NoticeBoardWriteContract.NoticeBoardWriteEvent.AnonymousClick(click))
        },
        onTitleValueChanged = { title ->
            viewModel.setEvent(NoticeBoardWriteContract.NoticeBoardWriteEvent.TitleTextChanged(title))
        },
        onContentValueChanged = { content ->
            viewModel.setEvent(NoticeBoardWriteContract.NoticeBoardWriteEvent.ContentTextChanged(content))
        },
        modifier = modifier,
        paddingValues = paddingValues,
        uiState = uiState,
    )
}

@Composable
fun NoticeBoardWriteScreen(
    navigateToBack: () -> Unit,
    writeCompleteButtonClicked: () -> Unit,
    categoryChipClicked: (ArabyteNoticeBoardCategoryType) -> Unit,
    anonymousChipClicked: (Boolean) -> Unit,
    onTitleValueChanged: (String) -> Unit,
    onContentValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(0.dp),
    uiState: NoticeBoardWriteContract.NoticeBoardWriteUiState = NoticeBoardWriteContract.NoticeBoardWriteUiState(),
) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(paddingValues),
    ) {
        ArabyteTopAppBar(
            title = stringResource(R.string.notice_board_write_nav_title),
            optionalText = stringResource(R.string.notice_board_write_nav_option),
            optionalTextColor = ArabyteTheme.colors.mainBlue,
            onBackClick = navigateToBack,
            onOptionalClick = writeCompleteButtonClicked,
        )
        Spacer(Modifier.height(17.dp))
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
        ) {
            NoticeBoardWriteRequiredLabel(
                labelRedId = R.string.notice_board_write_category,
            )
            Spacer(Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(7.dp),
            ) {
                ArabyteNoticeBoardCategoryButton(
                    noticeBoardCategoryType = ArabyteNoticeBoardCategoryType.FREE,
                    enabled = uiState.selectCategory == ArabyteNoticeBoardCategoryType.FREE,
                    buttonClicked = { isSelected ->
                        if (isSelected) {
                            categoryChipClicked(ArabyteNoticeBoardCategoryType.FREE)
                        }
                    },
                )
                ArabyteNoticeBoardCategoryButton(
                    noticeBoardCategoryType = ArabyteNoticeBoardCategoryType.INFO,
                    enabled = uiState.selectCategory == ArabyteNoticeBoardCategoryType.INFO,
                    buttonClicked = { isSelected ->
                        if (isSelected) {
                            categoryChipClicked(ArabyteNoticeBoardCategoryType.INFO)
                        }
                    },
                )
            }
            Spacer(Modifier.height(20.dp))
            Row {
                NoticeBoardWriteRequiredLabel(
                    labelRedId = R.string.notice_board_write_is_anonymous,
                )
                Spacer(Modifier.weight(1f))
                ArabyteToggleButton(
                    enabled = uiState.selectIsAnonymous == true,
                    buttonClicked = { isClicked ->
                        anonymousChipClicked(isClicked)
                    },
                )
            }
            Spacer(Modifier.height(8.dp))
            ArabyteInformationBox(
                infoResId = R.string.notice_board_write_anonymous_description,
            )
        }
        Spacer(Modifier.height(17.dp))
        HorizontalDivider(
            thickness = 8.dp,
            color = ArabyteTheme.colors.gray01,
        )
        Spacer(Modifier.height(16.dp))
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
        ) {
            NoticeBoardWriteRequiredLabel(
                labelRedId = R.string.notice_board_write_title,
            )
            Spacer(Modifier.height(4.dp))
            ArabyteNormalTextField(
                textMaxLength = 10,
                placeholder = stringResource(R.string.notice_board_write_title_placeholder),
                text = uiState.titleText,
                onValueChange = onTitleValueChanged,
            )
            Spacer(Modifier.height(13.dp))
            NoticeBoardWriteRequiredLabel(
                labelRedId = R.string.notice_board_write_content,
            )
            Spacer(Modifier.height(4.dp))
            ArabyteLargeTextField(
                textMaxLength = 300,
                placeholder = stringResource(R.string.notice_board_write_content_placeholder),
                text = uiState.contentText,
                onValueChange = onContentValueChanged,
            )
        }
    }
}
