package com.example.cookbook

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun RecipeSearchScreen(
    viewModel: RecipeViewModel,
    onRecipeClick: (Int) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var searchMode by remember { mutableStateOf(SearchMode.BY_NAME) } // Track search mode
    val recipes = viewModel.recipes.collectAsState().value
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        Column {
            // Search mode selection
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButtonWithText(
                    selected = searchMode == SearchMode.BY_NAME,
                    text = "By Name",
                    onClick = { searchMode = SearchMode.BY_NAME }
                )
                RadioButtonWithText(
                    selected = searchMode == SearchMode.BY_INGREDIENT,
                    text = "By Ingredient",
                    onClick = { searchMode = SearchMode.BY_INGREDIENT }
                )
            }

            OutlinedTextField(
                value = searchQuery,
                onValueChange = { query: String ->
                    searchQuery = query
                    coroutineScope.launch {
                        when (searchMode) {
                            SearchMode.BY_NAME -> viewModel.searchRecipe(query)
                            SearchMode.BY_INGREDIENT -> viewModel.searchByIngredient(query)
                        }
                    }
                },
                label = { Text("Search for a recipe...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
            )

            LazyColumn {
                items(recipes) { recipe ->
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .background(Color.LightGray)
                            .fillMaxWidth()
                            .clickable { onRecipeClick(recipe.id) } // Use onRecipeClick when clicked
                    ) {
                        Text(text = "Name: ${recipe.recipeName}")
                        Divider()
                    }
                }
            }
        }
    }
}

// Helper Composable for Radio Button with Text
@Composable
fun RadioButtonWithText(selected: Boolean, text: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(end = 16.dp)
            .clickable { onClick() }
    ) {
        androidx.compose.material3.RadioButton(
            selected = selected,
            onClick = onClick
        )
        Text(text = text)
    }
}

// Enum for Search Modes
enum class SearchMode {
    BY_NAME,
    BY_INGREDIENT
}
