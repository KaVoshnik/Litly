package com.litly.app.ui.book

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.litly.app.ui.components.coverColor
import com.litly.app.ui.model.BookUi

@Composable
fun BookScreen(
    book: BookUi?,
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {},
    onRead: () -> Unit = {}
) {
    if (book == null) {
        // Книга не нашлась (например, устаревшая ссылка) — в норме не должно происходить.
        return
    }

    var inLibrary by remember(book.id) { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        IconButton(
            onClick = onBack,
            modifier = Modifier.padding(start = 8.dp, top = 8.dp)
        ) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp)
                .aspectRatio(2f / 3f)
                .clip(RoundedCornerShape(24.dp))
                .background(book.coverColor()),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = book.title.take(1).uppercase(),
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White.copy(alpha = 0.85f)
            )
        }

        Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp)) {
            Text(
                text = book.title,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = book.author,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
            )

            Spacer(Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                AssistChip(onClick = {}, label = { Text(book.genre) })
                Spacer(Modifier.width(12.dp))
                Icon(
                    Icons.Filled.Star,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "%.1f".format(book.rating),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Spacer(Modifier.height(20.dp))
            Text(
                text = "Описание",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = book.description.ifBlank {
                    "Описание появится, когда подключим реальные карточки книг."
                },
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.85f)
            )

            Spacer(Modifier.height(28.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                if (inLibrary) {
                    Button(
                        onClick = { inLibrary = false },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("В библиотеке ✓")
                    }
                } else {
                    OutlinedButton(
                        onClick = { inLibrary = true },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Добавить в библиотеку")
                    }
                }
                Button(
                    onClick = onRead,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Читать")
                }
            }
        }
    }
}
