package com.litly.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Все маршруты приложения.
 */
sealed class LitlyDestination(val route: String) {
    data object Home : LitlyDestination("home")
    data object Catalog : LitlyDestination("catalog")
    data object Library : LitlyDestination("library")
    data object Profile : LitlyDestination("profile")

    // Страница книги принимает id книги через аргумент маршрута.
    data object Book : LitlyDestination("book/{$ARG_BOOK_ID}") {
        fun createRoute(bookId: String) = "book/$bookId"
    }

    data object Reader : LitlyDestination("reader")

    companion object {
        const val ARG_BOOK_ID = "bookId"
    }
}

data class BottomNavItem(
    val destination: LitlyDestination,
    val label: String,
    val icon: ImageVector
)

// Экраны нижней навигации: Book и Reader открываются поверх них,
// поэтому в список не входят.
val bottomNavItems = listOf(
    BottomNavItem(LitlyDestination.Home, "Главная", Icons.Filled.Home),
    BottomNavItem(LitlyDestination.Catalog, "Каталог", Icons.Filled.Search),
    BottomNavItem(LitlyDestination.Library, "Библиотека", Icons.Filled.Favorite),
    BottomNavItem(LitlyDestination.Profile, "Профиль", Icons.Filled.Person)
)
