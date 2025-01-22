package com.example.cookbook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipeViewModel(private val dao: RecipeDao) : ViewModel() {
    private val _recipes = MutableStateFlow<List<RecipeData>>(emptyList())
    val recipes: StateFlow<List<RecipeData>> = _recipes

    fun searchRecipe(query: String) {
        viewModelScope.launch {
            _recipes.value = dao.searchRecipeByName(query)
        }
    }

    fun searchByIngredient(ingredient: String) {
        viewModelScope.launch {
            _recipes.value = dao.searchRecipesByIngredient(ingredient)
        }
    }
}