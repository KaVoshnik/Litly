package com.litly.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.litly.app.ui.book.BookScreen
import com.litly.app.ui.catalog.CatalogScreen
import com.litly.app.ui.home.HomeScreen
import com.litly.app.ui.library.LibraryScreen
import com.litly.app.ui.model.MockLibrary
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
                onOpenBook = { book ->
                    navController.navigate(LitlyDestination.Book.createRoute(book.id))
                }
            )
        }
        composable(LitlyDestination.Catalog.route) {
            CatalogScreen(
                onBookClick = { book ->
                    navController.navigate(LitlyDestination.Book.createRoute(book.id))
                }
            )
        }
        composable(LitlyDestination.Library.route) {
            LibraryScreen()
        }
        composable(LitlyDestination.Profile.route) {
            ProfileScreen()
        }
        composable(
            route = LitlyDestination.Book.route,
            arguments = listOf(
                navArgument(LitlyDestination.ARG_BOOK_ID) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString(LitlyDestination.ARG_BOOK_ID)
            val book = MockLibrary.all.find { it.id == bookId }
            BookScreen(
                book = book,
                onBack = { navController.popBackStack() },
                onRead = { navController.navigate(LitlyDestination.Reader.route) }
            )
        }
        composable(LitlyDestination.Reader.route) {
            ReaderScreen()
        }
    }
}
