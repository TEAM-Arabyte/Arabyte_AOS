package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.konkuk.arabyte_aos.presentation.type.ArabyteCategoryType
import com.konkuk.arabyte_aos.presentation.util.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.arabyteColors

@Composable
fun ArabyteCategoryButton(
    categoryType: ArabyteCategoryType,
    modifier: Modifier = Modifier,
    buttonClicked: () -> Unit = {},
) {
    Column(
        modifier = modifier.noRippleClickable { buttonClicked() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier =
            Modifier.border(width = 1.dp, color = arabyteColors.gray01, shape = RoundedCornerShape(9.dp))
                .roundedBackgroundWithPadding(
                    padding = PaddingValues(10.dp),
                    cornerRadius = 9.dp,
                ),
            imageVector = ImageVector.vectorResource(categoryType.imageDrawableRes),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = stringResource(categoryType.stringRes),
            color = arabyteColors.gray07
        )
    }
}

@Preview
@Composable
private fun ArabyteCategoryButtonPreview() {
    Column(modifier = Modifier.background(color = arabyteColors.white).padding(10.dp)) {
        ArabyteCategoryButton(categoryType = ArabyteCategoryType.FOOD)
        ArabyteCategoryButton(categoryType = ArabyteCategoryType.MANAGEMENT)
        ArabyteCategoryButton(categoryType = ArabyteCategoryType.SERVICE)
        ArabyteCategoryButton(categoryType = ArabyteCategoryType.TECH)
        ArabyteCategoryButton(categoryType = ArabyteCategoryType.PRODUCTION)
        ArabyteCategoryButton(categoryType = ArabyteCategoryType.DESIGN)
        ArabyteCategoryButton(categoryType = ArabyteCategoryType.EDUCATION)
        ArabyteCategoryButton(categoryType = ArabyteCategoryType.OFFICE)
    }
}
