package com.litly.app.ui.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.litly.app.ui.components.ScreenPlaceholder

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    ScreenPlaceholder(
        title = "Профиль",
        subtitle = "Статистика чтения · Достижения · Настройки — Sprint 5",
        modifier = modifier
    )
}
