package com.konkuk.arabyte_aos.presentation.ui.component.chip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme
import com.konkuk.arabyte_aos.ui.theme.arabyteColors

@Composable
fun LikeChip(
    count: Int,
    isLiked: Boolean,
    modifier: Modifier = Modifier,
) {
    val iconTint = if (isLiked) arabyteColors.gray07 else arabyteColors.gray03
    ArabyteIconTextChip(
        icon = R.drawable.ic_all_like_15,
        count = count,
        iconTint = iconTint,
        modifier = modifier,
    )
}

@Composable
fun CommentChip(
    count: Int,
    modifier: Modifier = Modifier,
) {
    ArabyteIconTextChip(
        icon = R.drawable.ic_all_comment_15,
        count = count,
        iconTint = arabyteColors.gray03,
        modifier = modifier,
    )
}

@Composable
private fun ArabyteIconTextChip(
    icon: Int,
    count: Int,
    iconTint: Color,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = icon),
            tint = iconTint,
            contentDescription = null,
        )
        Spacer(Modifier.width(2.dp))
        Text(
            text = count.toString(),
            style = ArabyteTheme.typography.capMed11,
            color = arabyteColors.gray05,
        )
    }
}
