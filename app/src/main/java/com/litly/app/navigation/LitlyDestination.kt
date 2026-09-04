package com.litly.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Все маршруты приложения. Пока без аргументов — bookId и т.п.
 * добавим, когда дойдём до реальных данных (Sprint 3, 7).
 */
sealed class LitlyDestination(val route: String) {
    data object Home : LitlyDestination("home")
    data object Catalog : LitlyDestination("catalog")
    data object Library : LitlyDestination("library")
    data object Profile : LitlyDestination("profile")
    data object Book : LitlyDestination("book")
    data object Reader : LitlyDestination("reader")
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
