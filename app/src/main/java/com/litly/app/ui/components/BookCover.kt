package com.litly.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.litly.app.theme.LitlyCoverPalette
import com.litly.app.ui.model.BookUi
import kotlin.math.abs

/**
 * Карточка книги: обложка-заглушка (цвет + первая буква названия,
 * пока нет реальных картинок с backend) + название/автор снизу.
 * Если у книги есть progress — показываем полоску прогресса поверх обложки.
 */
@Composable
fun BookCover(
    book: BookUi,
    modifier: Modifier = Modifier.width(120.dp),
    onClick: () -> Unit = {}
) {
    val coverColor = LitlyCoverPalette[abs(book.id.hashCode()) % LitlyCoverPalette.size]

    Column(
        modifier = modifier.clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(168.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(coverColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = book.title.take(1).uppercase(),
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White.copy(alpha = 0.85f)
            )
            book.progress?.let { progress ->
                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .height(4.dp),
                    color = MaterialTheme.colorScheme.background,
                    trackColor = Color.White.copy(alpha = 0.35f)
                )
            }
        }
        Text(
            text = book.title,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = book.author,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
