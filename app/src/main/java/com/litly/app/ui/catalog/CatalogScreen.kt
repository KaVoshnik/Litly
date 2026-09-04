package com.litly.app.ui.catalog

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.litly.app.ui.components.ScreenPlaceholder

@Composable
fun CatalogScreen(modifier: Modifier = Modifier) {
    ScreenPlaceholder(
        title = "Каталог",
        subtitle = "Поиск · Фильтры · Жанры · Сортировка — Sprint 2",
        modifier = modifier
    )
}
