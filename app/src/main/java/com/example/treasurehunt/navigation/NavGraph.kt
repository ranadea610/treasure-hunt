package com.example.treasurehunt.navigation

// Compose
import androidx.compose.runtime.Composable

// Navigation
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// Screens
import com.example.treasurehunt.ui.PermissionsScreen
import com.example.treasurehunt.ui.StartScreen
import com.example.treasurehunt.ui.ClueScreen
import com.example.treasurehunt.ui.ClueSolvedScreen
import com.example.treasurehunt.ui.CompletedScreen

// ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.treasurehunt.viewmodel.TreasureViewModel

@Composable
fun NavGraph(navController: NavHostController) {

    val treasureViewModel: TreasureViewModel = viewModel()

    NavHost(navController = navController, startDestination = "permissions") {

        composable("permissions") {
            PermissionsScreen(
                navController = navController,
            )
        }

        composable("start") {
            StartScreen(
                navController = navController,
                viewModel = treasureViewModel
            )
        }

        composable("clue") {
            ClueScreen(
                navController = navController,
                viewModel = treasureViewModel
            )
        }

        composable("solved") {
            ClueSolvedScreen(
                navController = navController,
                viewModel = treasureViewModel
            )
        }

        composable("completed") {
            CompletedScreen(
                navController = navController,
                viewModel = treasureViewModel
            )
        }
    }
}