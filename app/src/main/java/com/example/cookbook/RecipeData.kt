package com.example.cookbook

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class RecipeData(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "Meal") val meal: String?,
    @ColumnInfo(name = "Recipe Name") val recipeName: String?,
    @ColumnInfo(name = "Links") val links: String?,
    @ColumnInfo(name = "Type") val type: String?,
    @ColumnInfo(name = "Cuisine") val cuisine: String?,
    @ColumnInfo(name = "Time to Prepare(in min)") val timeToPrepare: String?,
    @ColumnInfo(name = "Ingredients") val ingredients: String?,
    @ColumnInfo(name = "Instructions") val instructions: String?,
    @ColumnInfo(name = "New Ingredients") val newIngredients: String?,
    @ColumnInfo(name = "Image Link") val imageLink: String?

)
