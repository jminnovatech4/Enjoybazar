package com.jminnovatech.enjoybazar.ui.customer

import androidx.compose.foundation.clickable
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
import com.google.gson.Gson
import com.jminnovatech.enjoybazar.data.model.customer.DeliveryInfo
import com.jminnovatech.enjoybazar.ui.customer.vm.CustomerViewModel
import androidx.compose.foundation.layout.Arrangement
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

            var expanded by remember { mutableStateOf(false) }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { expanded = !expanded },
                shape = RoundedCornerShape(14.dp)
            ) {

                Column(Modifier.padding(12.dp)) {

                    Text("Order #${order.order_no}", fontWeight = FontWeight.Bold)

                    Text("₹ ${order.total_amount}  •  ${order.status}")

                    if (expanded) {

                        Spacer(Modifier.height(8.dp))
                        Divider()

                        order.items.forEach { item ->
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("${item.product_name} (${item.qty} ${item.unit})")
                                Text("₹${item.total}")
                            }
                        }


                        Spacer(Modifier.height(6.dp))
                        Text(order.created_at, fontSize = 12.sp, color = Color.Gray)
                    }
                }
            }
        }


    }
}
