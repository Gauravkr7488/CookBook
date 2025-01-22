package com.example.cookbook

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("""
            CREATE TABLE IF NOT EXISTS ingredients (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                recipe_id INTEGER NOT NULL,
                ingredient_name TEXT NOT NULL,
                FOREIGN KEY(recipe_id) REFERENCES data(id) ON DELETE CASCADE
            )
        """.trimIndent())
    }
}
