package com.jminnovatech.enjoybazar.ui.customer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.jminnovatech.enjoybazar.ui.customer.vm.CustomerViewModel

@Composable
fun CustomerOrdersScreen(vm: CustomerViewModel) {

    val orders by vm.orders.collectAsState()

    LaunchedEffect(Unit) {
        vm.loadOrders()
    }

    if (orders.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("No orders found")
        }
        return
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
                shape = RoundedCornerShape(14.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {

                    // 🔹 Header
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Order ${order.order_no}",
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = order.status.uppercase(),
                            color = when (order.status) {
                                "pending" -> Color(0xFFFF9800)
                                "accepted" -> Color(0xFF4CAF50)
                                else -> Color.Gray
                            },
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(Modifier.height(6.dp))

                    Text(
                        text = order.created_at.replace("T", " ").replace(".000000Z", ""),
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Spacer(Modifier.height(10.dp))
                    Divider()
                    Spacer(Modifier.height(8.dp))

                    // 🔹 ALL ITEMS
                    order.items.forEach { item ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("${item.product_name} × ${item.qty.toDouble().toInt()} ${item.unit}")
                            Text("₹${item.total}")
                        }
                        Spacer(Modifier.height(4.dp))
                    }

                    Spacer(Modifier.height(8.dp))
                    Divider()
                    Spacer(Modifier.height(8.dp))

                    // 🔹 TOTAL
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Total",
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "₹${order.total_amount}",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
