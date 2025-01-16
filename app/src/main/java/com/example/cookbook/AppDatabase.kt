package com.example.cookbook

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RecipeData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao

}