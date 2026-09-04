package com.litly.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.litly.app.navigation.LitlyNavHost
import com.litly.app.navigation.bottomNavItems
import com.litly.app.ui.components.LitlyBottomBar

/**
 * Корневой композабл: держит NavController, показывает нижнюю
 * навигацию только на "верхнеуровневых" экранах (Home/Catalog/
 * Library/Profile) и скрывает её на Book/Reader.
 */
@Composable
fun LitlyApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination

    val showBottomBar = bottomNavItems.any { item ->
        currentDestination?.hierarchy?.any { it.route == item.destination.route } == true
    }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                LitlyBottomBar(
                    navController = navController,
                    currentDestination = currentDestination
                )
            }
        }
    ) { innerPadding ->
        LitlyNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
