package com.litly.app.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.litly.app.ui.components.BookSection
import com.litly.app.ui.components.GenreRow
import com.litly.app.ui.model.BookUi
import com.litly.app.ui.model.MockLibrary

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onOpenBook: (BookUi) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(28.dp)
    ) {
        item {
            Text(
                text = "Привет! Что читаем сегодня?",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }

        if (MockLibrary.continueReading.isNotEmpty()) {
            item {
                BookSection(
                    title = "Продолжить чтение",
                    books = MockLibrary.continueReading,
                    onBookClick = onOpenBook
                )
            }
        }

        item {
            BookSection(
                title = "Рекомендации",
                books = MockLibrary.recommended,
                onBookClick = onOpenBook
            )
        }

        item {
            BookSection(
                title = "Новинки",
                books = MockLibrary.newReleases,
                onBookClick = onOpenBook
            )
        }

        item {
            BookSection(
                title = "Популярное",
                books = MockLibrary.popular,
                onBookClick = onOpenBook
            )
        }

        item {
            GenreRow(genres = MockLibrary.genres)
        }
    }
}
