package com.konkuk.arabyte_aos.presentation.ui.mypage.component

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.domain.model.MyContract
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteTopAppBar
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteCheckButton
import com.konkuk.arabyte_aos.presentation.ui.component.dialog.ArabyteTwoButtonDialog
import com.konkuk.arabyte_aos.presentation.ui.component.loading.ArabyteLoadingAnimation
import com.konkuk.arabyte_aos.presentation.ui.component.textfield.ArabyteNormalTextField
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun MyPageContractView(
    backButtonClicked: () -> Unit,
    enrollButtonClicked: () -> Unit,
    changeAddContractViewVisible: () -> Unit,
    onCompanyNameValueChanged: (String) -> Unit,
    galleryPickButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
    contractList: List<MyContract> = emptyList(),
    companyName: String = "",
    contractImageUri: String = "",
    imageUploadState:LoadState,
    addContractViewVisible: Boolean = true,
) {
    val enrollButtonEnabled by remember(companyName, contractImageUri) {
        mutableStateOf(companyName.isNotEmpty() && contractImageUri.isNotEmpty())
    }

    BackHandler {
        if (addContractViewVisible) {
            changeAddContractViewVisible()
        } else {
            backButtonClicked()
        }
    }

    Box(
        modifier =
            modifier
                .fillMaxSize()
                .background(color = ArabyteTheme.colors.white),
    ) {
        if (addContractViewVisible) {
            Column(modifier = Modifier.fillMaxSize().noRippleClickable(), horizontalAlignment = Alignment.CenterHorizontally) {
                ArabyteTopAppBar(
                    modifier = modifier,
                    useBack = true,
                    title = "근로계약서 인증",
                    onBackClick = backButtonClicked,
                )
                Spacer(modifier = Modifier.height(22.dp))
                ArabyteNormalTextField(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    textMaxLength = 10,
                    placeholder = "근무지명을 입력해주세요",
                    text = companyName,
                    title = "근무지명",
                    onValueChange = onCompanyNameValueChanged,
                )
                Spacer(modifier = Modifier.height(14.dp))
                if (contractImageUri.isEmpty()) {
                    MyPageAddContractButton(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        buttonClicked = galleryPickButtonClicked,
                    )
                } else {
                    AsyncImage(
                        model = contractImageUri,
                        contentDescription = null,
                        modifier =
                            Modifier
                                .weight(1f)
                                .padding(horizontal = 16.dp)
                                .border(
                                    width = 1.dp,
                                    color = ArabyteTheme.colors.mainBlue,
                                    shape = RoundedCornerShape(7.dp),
                                )
                                .clip(shape = RoundedCornerShape(7.dp))
                                .noRippleClickable { galleryPickButtonClicked() },
                        contentScale = ContentScale.Fit,
                    )
                }
                Spacer(modifier = Modifier.weight(0.2f))
                Text(
                    textAlign = TextAlign.Center,
                    text = "등록하기",
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .roundedBackgroundWithPadding(
                                cornerRadius = 7.dp,
                                backgroundColor = if (enrollButtonEnabled) ArabyteTheme.colors.mainBlue else ArabyteTheme.colors.gray01,
                                padding = PaddingValues(vertical = 16.dp),
                            )
                            .noRippleClickable {
                                if (enrollButtonEnabled) {
                                    enrollButtonClicked()
                                }
                            },
                    style = ArabyteTheme.typography.bodySemi15,
                    color = if (enrollButtonEnabled) ArabyteTheme.colors.white else ArabyteTheme.colors.gray05,
                )
                Spacer(modifier = Modifier.height(18.dp))
            }
        } else {
            Column(modifier = Modifier.fillMaxSize().noRippleClickable(), horizontalAlignment = Alignment.CenterHorizontally) {
                ArabyteTopAppBar(
                    modifier = modifier,
                    useBack = true,
                    title = "나의 근로계약서",
                    onBackClick = backButtonClicked,
                )
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .background(color = ArabyteTheme.colors.lightBlue)
                            .padding(horizontal = 16.dp, vertical = 10.dp),
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_all_information_14),
                        contentDescription = null,
                        tint = Color.Unspecified,
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(
                        text =
                            "근로계약서 인증시, 해당 근무지의 인증 뱃지를 받을 수 있어요\n" +
                                "사진으로 간편하게 인증하고 신뢰도를 높여보세요! ",
                        style = ArabyteTheme.typography.capMed11,
                        color = ArabyteTheme.colors.mainBlue,
                    )
                }
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    text = "나의 근로계약서",
                    color = ArabyteTheme.colors.black,
                    style = ArabyteTheme.typography.bodySemi15,
                    textAlign = TextAlign.Start,
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                )
                LazyColumn(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(11.dp),
                ) {
                    item {}
                    items(contractList) {
                        MyPageMyContractItem(
                            companyName = it.companyName,
                            isCertified = it.valid,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(11.dp))
                ArabyteCheckButton(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    buttonClicked = changeAddContractViewVisible,
                )
            }
        }

        if (imageUploadState == LoadState.Loading){
            Box(
                modifier =
                Modifier
                    .fillMaxSize()
                    .background(ArabyteTheme.colors.black.copy(alpha = 0.5f))
                    .noRippleClickable(),
                contentAlignment = Alignment.Center,
            ) {
                ArabyteLoadingAnimation(
                    modifier = Modifier.padding(horizontal = 36.dp),
                    isLoading = imageUploadState == LoadState.Loading,
                    loadingText = "이미지 업로드 중",
                )
            }
        }
    }
}

@Preview
@Composable
private fun MyPageContractViewPreview() {
    ArabyteAOSTheme {
        MyPageContractView(
            contractList =
            listOf(
                MyContract(companyName = "스타벅스", valid = true),
                MyContract(
                    companyName = "컴포즈 커피",
                    valid = false,
                ),
            ),
            backButtonClicked = {},
            changeAddContractViewVisible = {},
            galleryPickButtonClicked = {},
            onCompanyNameValueChanged = {},
            enrollButtonClicked = {},
            imageUploadState = LoadState.Idle,
        )
    }
}
