package com.litly.app.ui.library

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.litly.app.ui.components.ScreenPlaceholder

@Composable
fun LibraryScreen(modifier: Modifier = Modifier) {
    ScreenPlaceholder(
        title = "Моя библиотека",
        subtitle = "Читаю сейчас · Прочитано · Хочу прочитать · Загрузки — Sprint 4",
        modifier = modifier
    )
}
