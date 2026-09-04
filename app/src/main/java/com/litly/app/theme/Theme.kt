package com.litly.app.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LitlyLightColorScheme = lightColorScheme(
    primary = LitlyBlue,
    onPrimary = LitlyText,
    secondary = LitlyPink,
    onSecondary = LitlyText,
    tertiary = LitlyPurpleAccent,
    onTertiary = LitlyText,
    background = LitlyBackground,
    onBackground = LitlyText,
    surface = LitlySurface,
    onSurface = LitlyText
)

private val LitlyDarkColorScheme = darkColorScheme(
    primary = LitlyBlue,
    onPrimary = LitlyDarkText,
    secondary = LitlyPink,
    onSecondary = LitlyDarkText,
    tertiary = LitlyPurpleAccent,
    onTertiary = LitlyDarkText,
    background = LitlyDarkBackground,
    onBackground = LitlyDarkText,
    surface = LitlyDarkSurface,
    onSurface = LitlyDarkText
)

@Composable
fun LitlyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) LitlyDarkColorScheme else LitlyLightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = LitlyTypography,
        content = content
    )
}
