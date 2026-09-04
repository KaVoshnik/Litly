package com.litly.app.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Litly brand palette (см. Litly.md)
val LitlyBackground = Color(0xFFF7F9FF)
val LitlySurface = Color(0xFFFFFFFF)
val LitlyBlue = Color(0xFF6BCBFF)
val LitlyPink = Color(0xFFFF82C8)
val LitlyPurpleAccent = Color(0xFFA78BFA)
val LitlyText = Color(0xFF202333)

// Тёмная тема — тот же акцент, более тёмная база
val LitlyDarkBackground = Color(0xFF14151F)
val LitlyDarkSurface = Color(0xFF1D1F2B)
val LitlyDarkText = Color(0xFFF1F2FA)

// Фирменный градиент #6BCBFF -> #FF82C8 для акцентных элементов
val LitlyBrandGradient = Brush.linearGradient(
    colors = listOf(LitlyBlue, LitlyPink)
)

// Ротация пастельных цветов для обложек-заглушек (пока нет реальных
// картинок с backend). Sprint 1+.
val LitlyCoverPalette = listOf(
    LitlyBlue,
    LitlyPink,
    LitlyPurpleAccent,
    Color(0xFFB6E5FF),
    Color(0xFFFFC2E5),
    Color(0xFFC9B6FA)
)
