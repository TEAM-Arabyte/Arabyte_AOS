package com.konkuk.arabyte_aos.presentation.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.ui.home.HomeContract
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun HomeExpandedTopBarContent(
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
