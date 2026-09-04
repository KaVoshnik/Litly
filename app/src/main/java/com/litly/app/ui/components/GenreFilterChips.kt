package com.litly.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Множественный выбор жанров-фильтров (в отличие от GenreRow на
 * Главной, которая просто для просмотра, без выбора).
 * Пустой selected трактуется как "показать все".
 */
@Composable
fun GenreFilterChips(
    genres: List<String>,
    selected: Set<String>,
    onToggle: (String) -> Unit,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(genres, key = { it }) { genre ->
            FilterChip(
                selected = genre in selected,
                onClick = { onToggle(genre) },
                label = { Text(genre) }
            )
        }
    }
}
