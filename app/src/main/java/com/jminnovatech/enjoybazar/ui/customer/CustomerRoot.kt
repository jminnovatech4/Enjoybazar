package com.jminnovatech.enjoybazar.ui.customer

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jminnovatech.enjoybazar.ui.customer.vm.CustomerViewModel

@Composable
fun CustomerRoot() {

    val nav = rememberNavController()
    val vm: CustomerViewModel = viewModel()

    Scaffold(
        bottomBar = { CustomerBottomBar(nav) }
    ) { padding ->
        NavHost(
            navController = nav,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") { CustomerHomeScreen(vm) }
            composable("orders") { CustomerOrdersScreen(vm) }
            composable("cart") { CustomerCart(vm) }
        }
    }
}

