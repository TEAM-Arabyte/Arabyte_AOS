package com.konkuk.arabyte_aos.presentation.ui.reviewdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ReviewDetailContent(
    content: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .background(color = ArabyteTheme.colors.white)
                .padding(horizontal = 16.dp, vertical = 13.dp),
    ) {
        Row {
            Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_file_27), contentDescription = null, tint = Color.Unspecified)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "상세 리뷰", style = ArabyteTheme.typography.bodyBold15, color = ArabyteTheme.colors.black)
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = content, style = ArabyteTheme.typography.bodyMed15, color = ArabyteTheme.colors.gray07, modifier = Modifier.fillMaxWidth().roundedBackgroundWithPadding(cornerRadius = 9.dp, backgroundColor = ArabyteTheme.colors.gray01, padding = PaddingValues(vertical = 11.dp, horizontal = 13.dp)))
    }
}
