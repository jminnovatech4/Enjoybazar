package com.jminnovatech.enjoybazar.ui.customer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jminnovatech.enjoybazar.ui.customer.vm.CustomerViewModel

@Composable
fun CustomerHomeScreen(vm: CustomerViewModel) {

    val products by vm.products.collectAsState()
    val cart by vm.cart.collectAsState()

    LaunchedEffect(Unit) {
        vm.loadProducts()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp)
    ) {
        items(products) { product ->

            val qty = cart
                .find { it.product.id == product.id }
                ?.qty ?: 0.0

            ProductCard(
                product = product,
                qty = qty,
                onAdd = { vm.addToCart(product) },
                onRemove = { vm.removeFromCart(product) }
            )
        }
    }
}
