package com.litly.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.litly.app.ui.book.BookScreen
import com.litly.app.ui.catalog.CatalogScreen
import com.litly.app.ui.home.HomeScreen
import com.litly.app.ui.library.LibraryScreen
import com.litly.app.ui.profile.ProfileScreen
import com.litly.app.ui.reader.ReaderScreen

@Composable
fun LitlyNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = LitlyDestination.Home.route,
        modifier = modifier
    ) {
        composable(LitlyDestination.Home.route) {
            HomeScreen(
                onOpenBook = { navController.navigate(LitlyDestination.Book.route) }
            )
        }
        composable(LitlyDestination.Catalog.route) {
            CatalogScreen()
        }
        composable(LitlyDestination.Library.route) {
            LibraryScreen()
        }
        composable(LitlyDestination.Profile.route) {
            ProfileScreen()
        }
        composable(LitlyDestination.Book.route) {
            BookScreen(
                onRead = { navController.navigate(LitlyDestination.Reader.route) }
            )
        }
        composable(LitlyDestination.Reader.route) {
            ReaderScreen()
        }
    }
}
