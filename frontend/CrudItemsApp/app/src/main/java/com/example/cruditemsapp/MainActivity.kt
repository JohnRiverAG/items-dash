package com.example.cruditemsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.lifecycle.lifecycleScope
import com.example.cruditemsapp.screens.ItemListScreen
import com.example.cruditemsapp.model.ItemViewModel
import com.example.cruditemsapp.network.ItemApi
import com.example.cruditemsapp.network.RetrofitInstance
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            try {
                val items = RetrofitInstance.api.getItems()
                items.forEach {
                    Log.d("API", "Item: ${it.name}")
                }
            } catch (e: Exception) {
                Log.e("API", "Error: ${e.message}")
            }
        }

        setContent {
            Text("Conectando a la API...")
        }
    }
}


