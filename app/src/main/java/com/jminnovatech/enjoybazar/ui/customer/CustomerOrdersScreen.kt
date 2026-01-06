package com.jminnovatech.enjoybazar.ui.customer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.jminnovatech.enjoybazar.ui.customer.vm.CustomerViewModel

// ✅ GLOBAL IMAGE BASE (CORRECT)
private const val IMAGE_BASE_URL = "https://jminnovatech.xyz/"

@Composable
fun CustomerOrdersScreen(
    vm: CustomerViewModel
) {
    val orders by vm.orders.collectAsState()

    LaunchedEffect(Unit) {
        vm.loadOrders()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp)
    ) {
        items(orders) { order ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier.padding(12.dp)
                ) {

                    // 🔢 ORDER NUMBER
                    Text(
                        text = "Order #${order.order_no}",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    // 🖼️ ORDER IMAGE
                    if (!order.image.isNullOrEmpty()) {
                        AsyncImage(
                            model = IMAGE_BASE_URL + order.image,
                            contentDescription = "Order Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(140.dp)
                                .clip(RoundedCornerShape(10.dp))
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    // 💰 AMOUNT
                    Text(
                        text = "Amount: ₹${order.total_amount}",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    // 📦 STATUS
                    Text(
                        text = "Status: ${order.status}",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    // 🕒 DATE
                    Text(
                        text = order.created_at,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}
