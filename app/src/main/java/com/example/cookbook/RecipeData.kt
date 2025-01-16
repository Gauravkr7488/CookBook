package com.example.cookbook

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class RecipeData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val Meal: String,
    val RecipeName: String,
    val Links: String,
    val Type: String,
    val Cuisine: String,
    val TimeToPrepare: String, // Use proper formatting for time if needed
    val Ingredients: String,
    val Instructions: String,
    val NewIngredients: String,
    val ImageLink: String
)
