package com.jminnovatech.enjoybazar.ui.customer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jminnovatech.enjoybazar.ui.customer.vm.CustomerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomerHomeScreen(vm: CustomerViewModel) {

    val products by vm.products.collectAsState()
    val cart by vm.cart.collectAsState()

    var search by remember { mutableStateOf("") }

    // ✅ MUST load products
    LaunchedEffect(Unit) {
        vm.loadProducts()
    }

    // ✅ SEARCH FILTER (SAFE)
    val filteredProducts = remember(products, search) {
        if (search.isBlank()) {
            products
        } else {
            products.filter {
                it.title.contains(search, ignoreCase = true)
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        // 🔝 TOP BAR


        // 🔍 SEARCH
        OutlinedTextField(
            value = search,
            onValueChange = { search = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            placeholder = { Text("Search products") },
            singleLine = true
        )

        Spacer(Modifier.height(8.dp))

        // ❗ VERY IMPORTANT
        if (filteredProducts.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("No products found")
            }
            return
        }

        // ✅ PRODUCT LIST
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(12.dp)
        ) {
            items(filteredProducts) { product ->

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
}
