package com.konkuk.arabyte_aos.presentation.ui.reviewlist.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
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
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ReviewListEmptyView(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(130f))
        Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_review_empty_100), contentDescription = null, tint = Color.Unspecified, modifier = Modifier.size(182.dp))
        Text(text = stringResource(R.string.review_list_empty_main_title), color = ArabyteTheme.colors.gray06, style = ArabyteTheme.typography.bodyBold15)
        Text(text = stringResource(R.string.review_list_empty_sub_title), color = ArabyteTheme.colors.gray04, style = ArabyteTheme.typography.bodyMed13)
        Spacer(modifier = Modifier.weight(226f))
    }
}

@Preview
@Composable
private fun ReviewListEmptyViewPreview() {
    ArabyteAOSTheme {
        ReviewListEmptyView()
    }
}
