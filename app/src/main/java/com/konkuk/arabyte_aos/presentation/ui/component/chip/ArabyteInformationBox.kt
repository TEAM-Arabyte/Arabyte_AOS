package com.konkuk.arabyte_aos.presentation.ui.component.chip

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteInformationBox(
    @StringRes infoResId: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .roundedBackgroundWithPadding(
                    backgroundColor = ArabyteTheme.colors.lightBlue,
                    cornerRadius = 9.dp,
                    padding = PaddingValues(10.dp),
                ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_all_information_14),
            tint = Color.Unspecified,
            contentDescription = null,
        )
        Spacer(Modifier.width(7.dp))
        Text(
            text = stringResource(infoResId),
            style = ArabyteTheme.typography.capMed9,
            color = ArabyteTheme.colors.mainBlue,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ArabyteInformationBoxPrev() {
    ArabyteAOSTheme {
        ArabyteInformationBox(
            infoResId = R.string.notice_board_write_anonymous_description,
        )
    }
}
