package com.example.cookbook

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "recipes_database"
            )
                .createFromAsset("Indori2.db")
                .addMigrations(MIGRATION_1_2)
                .build()
        }
        return INSTANCE!!
    }
}