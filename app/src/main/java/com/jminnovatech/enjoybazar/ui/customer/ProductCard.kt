package com.jminnovatech.enjoybazar.ui.customer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jminnovatech.enjoybazar.data.model.customer.CustomerProduct

@Composable
fun ProductCard(
    product: CustomerProduct,
    qty: Double,
    onAdd: () -> Unit,
    onRemove: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // 🖼️ PRODUCT IMAGE
            AsyncImage(
                model = "https://jminnovatech.xyz/${product.image}",
                contentDescription = product.title,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(Modifier.width(12.dp))

            // 📄 DETAILS
            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    product.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    "₹ ${product.sell_price} / ${product.unit}",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    "Stock: ${product.stock_qty} ${product.unit}",
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(Modifier.height(8.dp))

                // ➕➖ QTY CONTROLS
                Row(verticalAlignment = Alignment.CenterVertically) {

                    IconButton(
                        onClick = onRemove,
                        enabled = qty > 0
                    ) {
                        Icon(Icons.Default.Remove, contentDescription = "Remove")
                    }

                    Text(
                        qty.toInt().toString(),
                        modifier = Modifier.padding(horizontal = 8.dp),
                        fontWeight = FontWeight.Bold
                    )

                    IconButton(onClick = onAdd) {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    }
                }
            }
        }
    }
}
