package com.litly.app.ui.model

/**
 * Временная UI-модель книги для моковых данных (Sprint 1-6).
 * В Sprint 7, когда появится domain-слой, её заменит нормальная
 * доменная модель Book + маппинг из Repository.
 */
data class BookUi(
    val id: String,
    val title: String,
    val author: String,
    val genre: String,
    val description: String = "",
    val rating: Float = 0f,
    val progress: Float? = null // 0f..1f — прогресс чтения, null если книга не читается сейчас
)
