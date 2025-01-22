package com.example.cookbook

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "ingredients",
    foreignKeys = [
        ForeignKey(
            entity = RecipeData::class,
            parentColumns = ["id"],
            childColumns = ["recipe_id"],
            onDelete = ForeignKey.CASCADE // Deletes ingredients when the recipe is deleted
        )
    ]
)data class IngredientData(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "recipe_id") val recipe_id : Int,
    @ColumnInfo(name = "ingredient_name") val ingredient_name : String?,
    )
