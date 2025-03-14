package com.konkuk.arabyte_aos.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext

object ArabyteTheme {
    val colors: ArabyteColors
        @Composable
        @ReadOnlyComposable
        get() = LocalArabyteColors.current

    val typography: ArabyteTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalArabyteTypography.current
}

private val DarkColorScheme =
    darkColorScheme(
        primary = arabyteColors.mainBlue,
        secondary = arabyteColors.subBlue,
        tertiary = arabyteColors.lightBlue,
    )

private val LightColorScheme =
    lightColorScheme(
        primary = arabyteColors.mainBlue,
        secondary = arabyteColors.subBlue,
        tertiary = arabyteColors.lightBlue,
    )

@Composable
fun ProvideArabyteColorsAndTypography(
    colors: ArabyteColors,
    typography: ArabyteTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalArabyteColors provides colors,
        LocalArabyteTypography provides typography,
        content = content,
    )
}

@Composable
fun ArabyteAOSTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }

    val typography = provideArabyteTypography()

    ProvideArabyteColorsAndTypography(
        colors = arabyteColors,
        typography = typography,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content,
        )
    }
}
