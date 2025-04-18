package com.konkuk.arabyte_aos.presentation.ui.home.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme
import com.konkuk.arabyte_aos.ui.theme.arabyteColors

@Composable
fun HomeContentTitle(
    @StringRes titleResId: Int,
    @StringRes subtitleResId: Int,
    modifier: Modifier = Modifier,
    onClickMore: () -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            text = stringResource(id = titleResId),
            style = ArabyteTheme.typography.bodyBold17,
            color = arabyteColors.black,
        )
        Row {
            Text(
                text = stringResource(id = subtitleResId),
                style = ArabyteTheme.typography.capMed11,
                color = arabyteColors.gray05,
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = stringResource(R.string.home_more),
                style = ArabyteTheme.typography.capSemi11,
                color = arabyteColors.gray03,
                modifier = Modifier.noRippleClickable(onClickMore),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeContentTitlePreview() {
    ArabyteAOSTheme {
        HomeContentTitle(
            titleResId = R.string.home_review_title,
            subtitleResId = R.string.home_review_sub_title,
        )
    }
}
