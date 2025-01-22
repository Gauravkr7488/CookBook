package com.example.cookbook

import androidx.room.Dao
import androidx.room.Query

@Dao
interface RecipeDao {
    // Search recipes by name
    @Query("SELECT * FROM data WHERE `Recipe Name` LIKE '%' || :search || '%'")
    suspend fun searchRecipeByName(search: String): List<RecipeData>

    @Query("""
    SELECT DISTINCT data.* 
    FROM data
    WHERE data.id IN (
        SELECT recipe_id 
        FROM ingredients 
        WHERE ingredient_name LIKE '%' || :search || '%'
    )
""")
    suspend fun searchRecipesByIngredient(search: String): List<RecipeData>

}