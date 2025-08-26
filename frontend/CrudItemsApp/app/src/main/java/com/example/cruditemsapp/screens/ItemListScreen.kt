package com.example.cruditemsapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import com.example.cruditemsapp.model.ItemViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text


@Composable
fun ItemListScreen(viewModel: ItemViewModel = viewModel()) {
    val items = viewModel.items

    LaunchedEffect(Unit) {
        viewModel.fetchItems()
    }

    LazyColumn {
        items(items) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = item.name, style = MaterialTheme.typography.titleMedium)
                    Text(text = item.description, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}
