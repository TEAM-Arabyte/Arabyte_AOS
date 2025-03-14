package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.type.ArabyteBoardCategoryType
import com.konkuk.arabyte_aos.presentation.util.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.arabyteColors

@Composable
fun ArabyteBoardCategoryButton(
    arabyteBoardCategoryType: ArabyteBoardCategoryType,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    buttonClicked: () -> Unit = {},
) {
    Row(modifier = modifier
        .then(
            if (!enabled) Modifier.border(
                width = 1.dp,
                color = arabyteColors.gray01,
                shape = RoundedCornerShape(30.dp)
            ) else Modifier
        )
        .roundedBackgroundWithPadding(padding = PaddingValues(vertical = 6.dp, horizontal = 13.dp), cornerRadius = 30.dp, backgroundColor = if (enabled) arabyteColors.gray07 else arabyteColors.white)
        .noRippleClickable { buttonClicked() },
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Icon(imageVector = ImageVector.vectorResource(arabyteBoardCategoryType.imageDrawableRes), tint = if (enabled) arabyteColors.white else arabyteColors.gray07, contentDescription = null)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = stringResource(arabyteBoardCategoryType.stringRes), color = if (enabled) arabyteColors.white else arabyteColors.gray06)
    }
}

@Preview
@Composable
private fun ArabyteSelectSmallButtonPreview() {
    Column {
        ArabyteBoardCategoryButton(arabyteBoardCategoryType = ArabyteBoardCategoryType.FREE, enabled = true)
        ArabyteBoardCategoryButton(arabyteBoardCategoryType = ArabyteBoardCategoryType.FREE, enabled = false)
    }
}
