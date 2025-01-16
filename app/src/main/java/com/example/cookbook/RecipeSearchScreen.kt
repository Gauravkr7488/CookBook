package com.example.cookbook

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch


@Composable
fun RecipeSearchScreen(viewModel: RecipeViewModel) {
    val recipes = viewModel.recipes.collectAsState().value
    val coroutineScope = rememberCoroutineScope()

    Column {
        BasicTextField(
            value = "",
            onValueChange = { query ->
                coroutineScope.launch { viewModel.searchRecipe(query) }
            },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                // Here you can customize the text input field with additional features
                Text("Search for a recipe...")
                innerTextField() // displays the input text
            }
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
