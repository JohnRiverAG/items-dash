package com.example.cruditemsapp.model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.cruditemsapp.network.RetrofitInstance
import android.util.Log



class ItemViewModel : ViewModel() {
    var items by mutableStateOf<List<Item>>(emptyList())
        private set

    fun fetchItems() {
        viewModelScope.launch {
            try {
                items = RetrofitInstance.api.getItems()
            } catch (e: Exception) {
                Log.e("ItemViewModel", "Error: ${e.message}")
            }
        }
    }
}
