package com.jminnovatech.enjoybazar.ui.customer

import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import com.jminnovatech.enjoybazar.ui.customer.vm.CustomerViewModel

@Composable
fun CustomerOrdersScreen(vm: CustomerViewModel) {

    val orders by vm.orders.collectAsState()

    LaunchedEffect(Unit) {
        vm.loadOrders()
    }

    LazyColumn {
        items(orders) {
            Text("${it.order_no}  ₹${it.total_amount}")
        }
    }
}
