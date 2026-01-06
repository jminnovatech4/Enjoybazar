package com.jminnovatech.enjoybazar.ui.customer

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jminnovatech.enjoybazar.ui.customer.vm.CustomerViewModel

@Composable
fun CustomerHomeScreen(vm: CustomerViewModel) {

    val products by vm.products.collectAsState()

    LaunchedEffect(Unit) {
        vm.loadProducts()
    }

    LazyColumn {
        items(products) {
            Text(it.title)
        }
    }
}
