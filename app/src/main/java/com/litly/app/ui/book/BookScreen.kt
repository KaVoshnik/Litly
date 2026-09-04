package com.litly.app.ui.book

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.litly.app.ui.components.ScreenPlaceholder

@Composable
fun BookScreen(
    modifier: Modifier = Modifier,
    onRead: () -> Unit = {}
) {
    ScreenPlaceholder(
        title = "Страница книги",
        subtitle = "Обложка · Описание · Рейтинг · Добавить в библиотеку — Sprint 3",
        modifier = modifier,
        actionLabel = "Читать (демо)",
        onAction = onRead
    )
}
