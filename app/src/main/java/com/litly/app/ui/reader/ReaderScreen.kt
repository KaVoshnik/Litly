package com.litly.app.ui.reader

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.litly.app.ui.components.ScreenPlaceholder

@Composable
fun ReaderScreen(modifier: Modifier = Modifier) {
    ScreenPlaceholder(
        title = "Читалка",
        subtitle = "Шрифт · Размер · Интервал · Тема · Прогресс · Закладки · Содержание — Sprint 6",
        modifier = modifier
    )
}
