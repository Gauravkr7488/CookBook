package com.example.cookbook

import RecipeViewModelFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cookbook.ui.theme.CookBookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = DatabaseProvider.getDatabase(applicationContext)
        val recipeDao = db.recipeDao()

        // Create ViewModel using ViewModelFactory
        val factory = RecipeViewModelFactory(recipeDao)
        val viewModel = ViewModelProvider(this, factory).get(RecipeViewModel::class.java)

        // Set the content of the activity to use the RecipeSearchScreen composable
        setContent {
            CookBookTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "recipeSearch" // Start with the RecipeSearchScreen
                    ) {
                        composable("recipeSearch") {

                            RecipeSearchScreen(
                                viewModel = viewModel,
                                onRecipeClick = { recipeId ->
                                    // Handle recipe click and navigate to the recipe details screen
                                    navController.navigate("recipeDetail/$recipeId")
                                }
                            )
                        }
                        composable("recipeDetail/{recipeId}") { backStackEntry ->
                            // Retrieve the recipeId argument and pass it to the RecipeDetailScreen
                            val recipeId = backStackEntry.arguments?.getString("recipeId")?.toIntOrNull() ?: -1
                            RecipeDetailScreen(recipeId = recipeId)
                        }
                    }
                }
            }
        }
    }
}

