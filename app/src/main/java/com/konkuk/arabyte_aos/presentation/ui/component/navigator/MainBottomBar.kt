package com.konkuk.arabyte_aos.presentation.ui.component.navigator

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.type.MainNavigationBarItemType
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun CustomNavigationBarItem(
    context: Context,
    mainNavigationBarItemType: MainNavigationBarItemType,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val color = if (isSelected) ArabyteTheme.colors.gray07 else ArabyteTheme.colors.gray02
    Column(
        modifier =
            modifier
                .padding(vertical = 10.dp)
                .noRippleClickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            painter = painterResource(id = mainNavigationBarItemType.iconRes),
            tint = color,
            contentDescription = null,
        )
        Text(
            text = context.getString(mainNavigationBarItemType.label),
            color = color,
            style = ArabyteTheme.typography.capSemi11,
        )
    }
}

@Composable
fun MainBottomBar(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    isVisible: Boolean,
    navigationBarItems: List<MainNavigationBarItemType>,
    currentNavigationBarItem: MainNavigationBarItemType?,
    onNavigationBarItemSelected: (MainNavigationBarItemType) -> Unit,
) {
    AnimatedVisibility(visible = isVisible) {
        val topBorderColor = ArabyteTheme.colors.gray01
        Row(
            modifier =
                modifier
                    .background(ArabyteTheme.colors.white)
                    .drawBehind {
                        val borderSize = 1.dp.toPx()
                        drawLine(
                            color = topBorderColor,
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = borderSize,
                        )
                    }
                    .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            navigationBarItems.forEach { mainNavigationBarItemType ->
                CustomNavigationBarItem(
                    context = context,
                    mainNavigationBarItemType = mainNavigationBarItemType,
                    isSelected = currentNavigationBarItem == mainNavigationBarItemType,
                    onClick = { onNavigationBarItemSelected(mainNavigationBarItemType) },
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}

@Preview
@Composable
private fun MainBottomBarPreview() {
    ArabyteAOSTheme {
        MainBottomBar(
            isVisible = true,
            navigationBarItems = MainNavigationBarItemType.entries.toList(),
            currentNavigationBarItem = MainNavigationBarItemType.HOME,
            onNavigationBarItemSelected = {},
        )
    }
}
