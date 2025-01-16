package com.example.cookbook

import RecipeViewModelFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.ViewModelProvider
import com.example.cookbook.ui.theme.CookBookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            CookBookTheme {
//                copyDatabaseIntoApp(this, "Indori.db")
//                HomePage()
//            }
//        }
        // Initialize the database
        val db = DatabaseProvider.getDatabase(applicationContext)
        val recipeDao = db.recipeDao()

        // Create ViewModel using ViewModelFactory
        val factory = RecipeViewModelFactory(recipeDao)
        val viewModel = ViewModelProvider(this, factory).get(RecipeViewModel::class.java)

        // Set the content of the activity to use the RecipeSearchScreen composable
        setContent {
            CookBookTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    RecipeSearchScreen(viewModel = viewModel)
                }
            }
        }
    }
}

