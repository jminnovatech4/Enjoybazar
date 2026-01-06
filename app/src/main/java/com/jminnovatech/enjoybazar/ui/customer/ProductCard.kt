package com.jminnovatech.enjoybazar.ui.customer

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jminnovatech.enjoybazar.data.model.customer.CustomerProduct

@Composable
fun ProductCard(product: CustomerProduct, onAdd: () -> Unit) {
    Card(Modifier.padding(8.dp)) {
        Column(Modifier.padding(12.dp)) {
            Text(product.title, style = MaterialTheme.typography.titleMedium)
            Text("₹${product.sell_price}/${product.unit}")
            Button(onClick = onAdd) {
                Text("Add")
            }
        }
    }
}

