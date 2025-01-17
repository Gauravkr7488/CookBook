package com.example.cookbook

import androidx.room.Dao
import androidx.room.Query

@Dao
interface RecipeDao {
    // Search recipes by name
    @Query("SELECT * FROM data WHERE `Recipe Name` LIKE '%' || :search || '%'")
    suspend fun searchRecipeByName(search: String): List<RecipeData>
}