package com.example.cookbook

import androidx.room.Database
import androidx.room.RoomDatabase
import com.google.android.gms.analytics.ecommerce.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    // Define abstract methods to access your DAOs
    abstract fun productDao(): ProductDao
}