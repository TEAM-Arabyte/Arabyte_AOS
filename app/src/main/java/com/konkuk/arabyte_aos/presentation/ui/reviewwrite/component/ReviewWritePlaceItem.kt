package com.konkuk.arabyte_aos.presentation.ui.reviewwrite.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.domain.model.KakaoPlace
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteSelectSmallButton
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ReviewWritePlaceItem(
    place: KakaoPlace,
    itemClicked: (KakaoPlace) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .noRippleClickable { itemClicked(place) }
                .background(color = ArabyteTheme.colors.white)
                .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Text(text = place.placeName, style = ArabyteTheme.typography.bodyBold13, color = ArabyteTheme.colors.black)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = place.addressName, style = ArabyteTheme.typography.capReg11, color = ArabyteTheme.colors.gray05)
            Text(
                text = place.roadAddressName,
                style = ArabyteTheme.typography.capReg11,
                color = ArabyteTheme.colors.gray05,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        ArabyteSelectSmallButton(
            buttonText = "선택",
            enabled = false,
            buttonClicked = { itemClicked(place) },
        )
    }
}

@Preview
@Composable
private fun ReviewWritePlaceItemPreview() {
    ArabyteAOSTheme {
        ReviewWritePlaceItem(
            place =
                KakaoPlace(
                    id = "0",
                    placeName = "메가커피 건대점",
                    addressName = "서울 광진구 화양동 5-6",
                    roadAddressName = "서울 광진구 능동로 121",
                ),
            itemClicked = {},
        )
    }
}
