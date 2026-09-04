package com.litly.app.ui.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.litly.app.ui.components.BookCover
import com.litly.app.ui.components.GenreFilterChips
import com.litly.app.ui.model.MockLibrary

@Composable
fun CatalogScreen(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }
    var selectedGenres by remember { mutableStateOf(setOf<String>()) }
    var sortOption by remember { mutableStateOf(CatalogSortOption.POPULAR) }

    val filteredBooks = remember(query, selectedGenres, sortOption) {
        MockLibrary.all
            .filter { book ->
                (selectedGenres.isEmpty() || book.genre in selectedGenres) &&
                    (query.isBlank() ||
                        book.title.contains(query, ignoreCase = true) ||
                        book.author.contains(query, ignoreCase = true))
            }
            .let { list ->
                when (sortOption) {
                    CatalogSortOption.POPULAR -> list
                    CatalogSortOption.ALPHABETICAL -> list.sortedBy { it.title }
                    CatalogSortOption.NEWEST -> list.reversed()
                }
            }
    }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(20.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            Column {
                Text(
                    text = "Каталог",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(16.dp))
                CatalogSearchField(query = query, onQueryChange = { query = it })
                Spacer(Modifier.height(16.dp))
                GenreFilterChips(
                    genres = MockLibrary.genres,
                    selected = selectedGenres,
                    onToggle = { genre ->
                        selectedGenres = if (genre in selectedGenres) {
                            selectedGenres - genre
                        } else {
                            selectedGenres + genre
                        }
                    }
                )
                Spacer(Modifier.height(12.dp))
                CatalogSortRow(
                    selected = sortOption,
                    onSelect = { sortOption = it }
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "Найдено: ${filteredBooks.size}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                )
            }
        }

        if (filteredBooks.isEmpty()) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    text = "Ничего не нашлось — попробуйте другой запрос или фильтр",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp)
                )
            }
        } else {
            items(filteredBooks, key = { it.id }) { book ->
                BookCover(book = book, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
