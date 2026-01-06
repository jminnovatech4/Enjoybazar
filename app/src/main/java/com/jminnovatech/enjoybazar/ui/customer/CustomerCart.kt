package com.jminnovatech.enjoybazar.ui.customer

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.jminnovatech.enjoybazar.ui.customer.vm.CustomerViewModel

@Composable
fun CustomerCart(vm: CustomerViewModel) {

    val cart by vm.cart.collectAsState()

    Column {
        cart.forEach {
            Text("${it.product.title} x ${it.qty}")
        }

        Button(onClick = {
            vm.placeOrder("Milton", "909391918", "Kolkata")
        }) {
            Text("Place Order")
        }
    }
}
