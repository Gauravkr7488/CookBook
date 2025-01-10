package com.example.cookbook

import android.content.Context
import java.io.FileOutputStream

fun copyDatabaseIntoApp(context: Context, dbName: String) { //to copy the data from the asset to the internal storage of the app
    val dbPath = context.getDatabasePath(dbName)

    // Check if the database already exists
    if (dbPath.exists()) return

    // Ensure the database directory exists
    dbPath.parentFile?.mkdirs()

    // Copy the database from assets to the database path
    context.assets.open(dbName).use { inputStream ->
        FileOutputStream(dbPath).use { outputStream ->
            inputStream.copyTo(outputStream)
        }
    }
}
