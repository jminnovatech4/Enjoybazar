package com.jminnovatech.enjoybazar.ui.customer

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.jminnovatech.enjoybazar.data.local.AppDatabase
import com.jminnovatech.enjoybazar.data.repository.ProductRepository

@Composable
fun CustomerHomeScreen() {

    val context = LocalContext.current

    val db = remember {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "enjoybazar.db"
        ).build()
    }

    val repo = remember { ProductRepository(db.productDao()) }
    val products by repo.getProducts().collectAsState(initial = emptyList())

    LazyColumn {
        items(products) { item ->
            Card(
                modifier = androidx.compose.ui.Modifier.padding(8.dp)
            ) {
                ListItem(
                    headlineContent = { Text(item.name) },
                    supportingContent = { Text("₹${item.price}") }
                )
            }
        }
    }
}
