package com.konkuk.arabyte_aos.presentation.ui.signup.component

import android.util.Log
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteChipButton
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteNormalButton
import com.konkuk.arabyte_aos.presentation.util.SignUp.dongList
import com.konkuk.arabyte_aos.presentation.util.SignUp.guList
import com.konkuk.arabyte_aos.presentation.util.SignUp.sidoFullName
import com.konkuk.arabyte_aos.presentation.util.SignUp.sidoList
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun SignUpLocationBottomSheet(
    modifier: Modifier = Modifier,
    bottomSheetClose: () -> Unit = {},
    completeButtonClicked: (String) -> Unit = {},
    sidoList: List<String>,
    guList: List<String>,
    dongList: List<String>,
) {
    var selectedSido by remember { mutableStateOf(sidoList[0]) }
    var selectedGu by remember { mutableStateOf("") }
    var selectedDong by remember { mutableStateOf("") }

    val districtText by remember(selectedGu, selectedDong) {
        mutableStateOf(listOf(selectedGu, selectedDong).filter { it.isNotEmpty() }.joinToString(" "))
    }

    val fullLocationText by remember(selectedSido, selectedGu, selectedDong) {
        mutableStateOf(listOf(sidoFullName(selectedSido), selectedGu, selectedDong).filter { it.isNotEmpty() }.joinToString(" "))
    }

    Column(
        modifier =
            modifier
                .background(
                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
                    color = ArabyteTheme.colors.white,
                )
                .padding(top = 19.dp),
    ) {
        Text(
            "거주하는 지역을 선택해주세요",
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
                    ArabyteChipButton(
                        buttonText = sidoFullName(it),
                        enabled = true,
                    ) {}
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
            SignUpLocationSidoList(
                modifier = Modifier.weight(92f),
                locationList = sidoList,
                selectedItem = selectedSido,
                onItemSelected = { selectedSido = it },
            )
            VerticalDivider(thickness = 1.dp, color = ArabyteTheme.colors.gray02)
            SignUpLocationDistrictList(
                modifier = Modifier.weight(134f),
                locationList = guList,
                selectedItem = selectedGu,
                onItemSelected = { selectedGu = it },
            )
            VerticalDivider(thickness = 1.dp, color = ArabyteTheme.colors.gray02)
            SignUpLocationDistrictList(
                modifier = Modifier.weight(134f),
                locationList = dongList,
                selectedItem = selectedDong,
                onItemSelected = { selectedDong = it },
            )
        }
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
        ) {
            ArabyteNormalButton(
                buttonText = "취소",
                modifier = Modifier.weight(101f),
                enabled = false,
                buttonClicked = bottomSheetClose,
            )
            Spacer(modifier = Modifier.width(12.dp))
            ArabyteNormalButton(
                buttonText = "적용하기",
                modifier = Modifier.weight(218f),
                buttonClicked = {
                    if (fullLocationText.isNotEmpty()) completeButtonClicked(fullLocationText)
                    Log.d("zz", fullLocationText)
                },
            )
        }
    }
}

@Preview
@Composable
private fun SignUpLocationBottomSheetPreview() {
    ArabyteAOSTheme {
        SignUpLocationBottomSheet(
            sidoList = sidoList,
            guList = guList,
            dongList = dongList,
        )
    }
}
