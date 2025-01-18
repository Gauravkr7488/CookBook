package com.example.cookbook

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost(dao: RecipeDao) {
    val navController = rememberNavController() // Think of this as the remote control for navigating between screens.

    NavHost(
        navController = navController, // Tell the roadmap which "remote control" to use.
        startDestination = "recipeSearch" // Set the starting screen when the app opens.
    ) {
        composable("recipeSearch") { // Define the route for the Recipe Search screen.
            RecipeSearchScreen(
                viewModel = RecipeViewModel(dao),
                onRecipeClick = { recipeId -> // Handle when a recipe is clicked.
                    navController.navigate("recipeDetail/$recipeId") // Navigate to the details screen, passing the recipe ID.
                }
            )
        }
        composable("recipeDetail/{recipeId}") { backStackEntry -> // Define the route for the Recipe Detail screen.
            val recipeId = backStackEntry.arguments?.getString("recipeId")?.toIntOrNull() // Get the recipe ID from the route.
            RecipeDetailScreen(recipeId = recipeId ?: -1) // Show the details screen for that recipe ID.
        }
    }
}

