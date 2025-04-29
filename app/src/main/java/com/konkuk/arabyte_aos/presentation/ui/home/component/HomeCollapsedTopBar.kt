package com.konkuk.arabyte_aos.presentation.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun HomeCollapsedTopBar(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .background(
                    color = ArabyteTheme.colors.gray01,
                    shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp),
                )
                .padding(start = 5.dp, top = 5.dp, bottom = 10.dp)
                .padding(WindowInsets.statusBars.asPaddingValues()),
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            modifier = Modifier.height(40.dp),
            imageVector = ImageVector.vectorResource(R.drawable.ic_all_logo),
            contentDescription = null,
            tint = ArabyteTheme.colors.mainBlue,
        )
    }
}
