
package com.example.cookbook

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.io.File

@Preview
@Composable
fun HomePage  () {
    var name by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)
        ){
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(modifier = Modifier.weight(1f),
                value = name,
                onValueChange = {
                    text -> name = text
                }
            )
            Button(
                onClick = { saveTextToFile(context, name) },
                enabled = name.isNotEmpty()
            ) {
                Text(text  = "Search")
            }
        }
    }
    }

fun saveTextToFile(context: Context, text: String) {
    val fileName = "saved string.txt" // Specify the file name
    val file = File(context.filesDir, fileName) // File path in internal storage

    file.writeText(text) // Write the text to the file
    println("Saved to ${file.absolutePath}") // For debugging purposes
}