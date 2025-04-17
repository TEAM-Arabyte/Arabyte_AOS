package com.konkuk.arabyte_aos.presentation.ui.component.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.domain.model.LocationData
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteChipButton
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteNormalButton
import com.konkuk.arabyte_aos.presentation.ui.component.location.ArabyteLocationDistrictList
import com.konkuk.arabyte_aos.presentation.ui.component.location.ArabyteLocationSidoList
import com.konkuk.arabyte_aos.presentation.util.SignUp.sidoFullName
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteLocationBottomSheet(
    modifier: Modifier = Modifier,
    bottomSheetClose: () -> Unit = {},
    completeButtonClicked: (String) -> Unit = {},
    selectedSido: LocationData? = null,
    sidoList: List<LocationData>,
    sidoOnclick: (LocationData) -> Unit = {},
    selectedGu: LocationData? = null,
    guList: List<LocationData>,
    guOnclick: (LocationData) -> Unit = {},
    selectedDong: LocationData? = null,
    dongList: List<LocationData>,
    dongOnclick: (LocationData) -> Unit = {},
) {
    val districtText by remember(selectedGu, selectedDong) {
        mutableStateOf(
            listOfNotNull(selectedGu?.guName, selectedDong?.dongName)
                .filter { it.isNotBlank() }
                .joinToString(" "),
        )
    }

    val fullLocationText by remember(selectedSido, selectedGu, selectedDong) {
        mutableStateOf(
            listOfNotNull(
                selectedSido?.let { sidoFullName(it.sidoName) },
                selectedGu?.guName,
                selectedDong?.dongName,
            ).filter { it.isNotBlank() }
                .joinToString(" "),
        )
    }

    Column(
        modifier =
            modifier
                .background(
                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
                    color = ArabyteTheme.colors.white,
                )
                .noRippleClickable { }
                .padding(top = 19.dp),
    ) {
        Text(
            stringResource(R.string.sign_up_bottom_sheet_title),
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            style = ArabyteTheme.typography.bodyBold15,
        )
        LazyRow(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            selectedSido.let {
                item {
                    if (it != null) {
                        ArabyteChipButton(
                            buttonText = sidoFullName(it.sidoName),
                            enabled = true,
                        ) {}
                    }
                }
            }

            if (districtText.isNotEmpty()) {
                item {
                    ArabyteChipButton(
                        buttonText = districtText,
                        enabled = true,
                    ) {}
                }
            }
        }
        HorizontalDivider(thickness = 1.dp, color = ArabyteTheme.colors.gray02)
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(380.dp),
        ) {
            ArabyteLocationSidoList(
                modifier = Modifier.weight(92f),
                locationList = sidoList,
                selectedItem = selectedSido,
                onItemSelected = { sido ->
                    sidoOnclick(sido)
                },
            )
            VerticalDivider(thickness = 1.dp, color = ArabyteTheme.colors.gray02)
            ArabyteLocationDistrictList(
                modifier = Modifier.weight(134f),
                locationList = guList,
                selectedItem = selectedGu,
                onItemSelected = { gu ->
                    guOnclick(gu)
                },
            )
            VerticalDivider(thickness = 1.dp, color = ArabyteTheme.colors.gray02)
            ArabyteLocationDistrictList(
                modifier = Modifier.weight(134f),
                locationList = dongList,
                selectedItem = selectedDong,
                onItemSelected = { dong ->
                    dongOnclick(dong)
                },
            )
        }
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
        ) {
            ArabyteNormalButton(
                buttonText = stringResource(R.string.sign_up_bottom_sheet_close),
                modifier = Modifier.weight(101f),
                enabled = false,
                buttonClicked = bottomSheetClose,
            )
            Spacer(modifier = Modifier.width(12.dp))
            ArabyteNormalButton(
                buttonText = stringResource(R.string.sign_up_bottom_sheet_confirm),
                modifier = Modifier.weight(218f),
                buttonClicked = {
                    if (fullLocationText.isNotEmpty()) completeButtonClicked(fullLocationText)
                },
            )
        }
    }
}

// @Preview
// @Composable
// private fun SignUpLocationBottomSheetPreview() {
//    ArabyteAOSTheme {
//        SignUpLocationBottomSheet(
//            sidoList = sidoList,
//            guList = guList,
//            dongList = dongList,
//        )
//    }
// }
