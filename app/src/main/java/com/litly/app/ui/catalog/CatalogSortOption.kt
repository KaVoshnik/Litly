package com.litly.app.ui.catalog

/**
 * Sprint 2: сортировка на моковых данных. POPULAR/NEWEST — заглушки
 * (порядок в списке и обратный порядок соответственно), станут
 * настоящими, когда появятся реальные метрики/даты с backend (Sprint 9).
 */
enum class CatalogSortOption(val label: String) {
    POPULAR("По популярности"),
    ALPHABETICAL("По алфавиту"),
    NEWEST("Сначала новые")
}
