package com.konkuk.arabyte_aos.presentation.ui.signup.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.domain.model.LocationData
import com.konkuk.arabyte_aos.presentation.util.SignUp.sidoShortName
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun SignUpLocationSidoList(
    modifier: Modifier = Modifier,
    locationList: List<LocationData>,
    selectedItem: LocationData? = null,
    onItemSelected: (LocationData) -> Unit = {},
) {
    LazyColumn(modifier = modifier) {
        items(locationList) { location ->
            val isSelect = location.sidoName == selectedItem?.sidoName
            Box(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .background(
                        color = if (isSelect) ArabyteTheme.colors.white else ArabyteTheme.colors.gray01,
                    )
                    .noRippleClickable {
                        onItemSelected(location)
                    },
            ) {
                Column {
                    if (isSelect) {
                        HorizontalDivider(thickness = 1.dp, color = ArabyteTheme.colors.gray02)
                    }
                    Text(
                        text = sidoShortName(location.sidoName),
                        style = if (isSelect) ArabyteTheme.typography.bodySemi13 else ArabyteTheme.typography.bodyMed13,
                        color = if (isSelect) ArabyteTheme.colors.mainBlue else ArabyteTheme.colors.gray03,
                        modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        textAlign = TextAlign.Center,
                    )
                    if (isSelect) {
                        HorizontalDivider(color = ArabyteTheme.colors.gray02, thickness = 1.dp)
                    }
                }
            }
        }
    }
}

@Composable
fun SignUpLocationDistrictList(
    modifier: Modifier = Modifier,
    locationList: List<LocationData>,
    selectedItem: LocationData? = null,
    onItemSelected: (LocationData) -> Unit = {},
) {
    val isGu = locationList.firstOrNull()?.depth == 2
    LazyColumn(modifier = modifier) {
        items(locationList) { location ->
            val isSelect = if (isGu) location.guName == selectedItem?.guName else location.dongName == selectedItem?.dongName
            Row(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .background(color = if (isSelect) ArabyteTheme.colors.lightBlue else ArabyteTheme.colors.white)
                    .noRippleClickable { onItemSelected(location) }
                    .padding(top = 10.dp, start = 15.dp, bottom = 10.dp, end = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = if(isGu) location.guName else location.dongName,
                    style = if (isSelect) ArabyteTheme.typography.bodySemi13 else ArabyteTheme.typography.bodyMed13,
                    color = if (isSelect) ArabyteTheme.colors.mainBlue else ArabyteTheme.colors.gray07,
                )
                Spacer(modifier = Modifier.weight(1f))
                if (isSelect) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_all_location_check_14),
                        contentDescription = null,
                        tint = Color.Unspecified,
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//private fun SignUpLocationListPreview() {
//    ArabyteAOSTheme {
//        Row(modifier = Modifier.fillMaxWidth()) {
//            SignUpLocationSidoList(modifier = Modifier.weight(92f), locationList = sidoList)
//            VerticalDivider(thickness = 1.dp, color = ArabyteTheme.colors.gray02)
//            SignUpLocationDistrictList(modifier = Modifier.weight(134f), locationList = guList)
//            VerticalDivider(thickness = 1.dp, color = ArabyteTheme.colors.gray02)
//            SignUpLocationDistrictList(modifier = Modifier.weight(134f), locationList = dongList)
//        }
//    }
//}
