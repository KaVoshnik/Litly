package com.litly.app.ui.model

/**
 * Моковые данные для UI-спринтов (1-6), пока нет backend/Repository.
 */
object MockLibrary {
    val continueReading = listOf(
        BookUi("b1", "Мастер и Маргарита", "Михаил Булгаков", genre = "Классика", progress = 0.62f),
        BookUi("b2", "Три товарища", "Эрих Мария Ремарк", genre = "Роман", progress = 0.18f)
    )

    val recommended = listOf(
        BookUi("b3", "Дюна", "Фрэнк Герберт", genre = "Фантастика"),
        BookUi("b4", "Убить пересмешника", "Харпер Ли", genre = "Классика"),
        BookUi("b5", "1984", "Джордж Оруэлл", genre = "Фантастика"),
        BookUi("b6", "Портрет Дориана Грея", "Оскар Уайльд", genre = "Классика")
    )

    val newReleases = listOf(
        BookUi("b7", "Дом, в котором…", "Мариам Петросян", genre = "Роман"),
        BookUi("b8", "Пищеблок", "Алексей Иванов", genre = "Фантастика"),
        BookUi("b9", "Финист — Ясный сокол", "Наталья Осояну", genre = "Фэнтези")
    )

    val popular = listOf(
        BookUi("b10", "Гарри Поттер и философский камень", "Дж. К. Роулинг", genre = "Фэнтези"),
        BookUi("b11", "Маленький принц", "Антуан де Сент-Экзюпери", genre = "Роман"),
        BookUi("b12", "Преступление и наказание", "Фёдор Достоевский", genre = "Классика"),
        BookUi("b13", "Собачье сердце", "Михаил Булгаков", genre = "Классика")
    )

    val genres = listOf(
        "Фантастика", "Фэнтези", "Детектив", "Роман", "Классика",
        "Young Adult", "Нон-фикшн", "Поэзия"
    )

    // Единый список для Каталога/Библиотеки — без дублей по id.
    val all: List<BookUi> =
        (continueReading + recommended + newReleases + popular).distinctBy { it.id }
}
