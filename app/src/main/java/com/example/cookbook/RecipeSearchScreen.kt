package com.example.cookbook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun RecipeSearchScreen(viewModel: RecipeViewModel) {
    var searchQuery by remember { mutableStateOf("") }
    val recipes = viewModel.recipes.collectAsState().value
    val coroutineScope = rememberCoroutineScope()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
    Column {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query : String ->
                searchQuery = query
                coroutineScope.launch { viewModel.searchRecipe(query) }
            },
            label = { Text("Search for a recipe...") },
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),

        )

        LazyColumn {
            items(recipes) { recipe ->
                Column {
                    Text(text = "Name: ${recipe.RecipeName}")
                    Text(text = "Ingredients: ${recipe.Ingredients}")
                    Text(text = "Instructions: ${recipe.Instructions}")
                    Divider()
                }
            }
        }
    }
}
    }
