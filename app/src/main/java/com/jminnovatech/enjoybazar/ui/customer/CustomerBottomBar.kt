package com.jminnovatech.enjoybazar.ui.customer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun CustomerBottomBar() {

    NavigationBar {

        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Cart"
                )
            },
            label = { Text("Cart") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Filled.List,
                    contentDescription = "Orders"
                )
            },
            label = { Text("Orders") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Filled.AccountBalanceWallet,
                    contentDescription = "Wallet"
                )
            },
            label = { Text("Wallet") }
        )
    }
}
