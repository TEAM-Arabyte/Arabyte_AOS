package com.konkuk.arabyte_aos.presentation.ui.reviewwrite.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.domain.model.KakaoPlace
import com.konkuk.arabyte_aos.presentation.ui.component.textfield.ArabyteNormalTextField
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.view.TextFieldValidationState
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ReviewWritePlaceBottomSheet(
    placeList: List<KakaoPlace>,
    placeClicked: (KakaoPlace) -> Unit,
    placeTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    textFieldText: String = "",
    validationState: TextFieldValidationState = TextFieldValidationState.IDLE,
) {
    Column(
        modifier =
            modifier
                .background(
                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
                    color = ArabyteTheme.colors.white,
                )
                .fillMaxWidth()
                .noRippleClickable { }
                .padding(top = 19.dp, start = 16.dp, end = 16.dp),
    ) {
        ArabyteNormalTextField(
            title = stringResource(R.string.review_write_company),
            textMaxLength = 20,
            text = textFieldText,
            onValueChange = { text ->
                placeTextChanged(text)
            },
            validationState = validationState,
            placeholder = stringResource(R.string.review_write_company_placeholder),
        )
        Spacer(modifier = Modifier.height(21.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth().height(180.dp)) {
            items(placeList) { place ->
                ReviewWritePlaceItem(
                    place = place,
                    itemClicked = placeClicked,
                )
            }
        }
        Spacer(modifier = Modifier.height(28.dp))
    }
}

@Preview
@Composable
private fun ReviewWritePlaceBottomSheetPreview() {
    ArabyteAOSTheme {
        ReviewWritePlaceBottomSheet(
            placeList =
                listOf(
                    KakaoPlace(
                        id = "0",
                        placeName = "메가커피 건대점",
                        addressName = "서울 광진구 화양동 5-6",
                        roadAddressName = "서울 광진구 능동로 121",
                    ),
                    KakaoPlace(
                        id = "0",
                        placeName = "메가커피 건대점",
                        addressName = "서울 광진구 화양동 5-6",
                        roadAddressName = "서울 광진구 능동로 121",
                    ),
                    KakaoPlace(
                        id = "0",
                        placeName = "메가커피 건대점",
                        addressName = "서울 광진구 화양동 5-6",
                        roadAddressName = "서울 광진구 능동로 121",
                    ),
                    KakaoPlace(
                        id = "0",
                        placeName = "메가커피 건대점",
                        addressName = "서울 광진구 화양동 5-6",
                        roadAddressName = "서울 광진구 능동로 121",
                    ),
                    KakaoPlace(
                        id = "0",
                        placeName = "메가커피 건대점",
                        addressName = "서울 광진구 화양동 5-6",
                        roadAddressName = "서울 광진구 능동로 121",
                    ),
                    KakaoPlace(
                        id = "0",
                        placeName = "메가커피 건대점",
                        addressName = "서울 광진구 화양동 5-6",
                        roadAddressName = "서울 광진구 능동로 121",
                    ),
                ),
            placeClicked = {},
            placeTextChanged = {},
        )
    }
}
