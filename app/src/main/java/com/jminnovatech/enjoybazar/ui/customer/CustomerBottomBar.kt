package com.jminnovatech.enjoybazar.ui.customer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.navigation.NavHostController

@Composable
fun CustomerBottomBar(nav: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = { nav.navigate("home") },
            label = { Text("Home") },
            icon = {}
        )
        NavigationBarItem(
            selected = false,
            onClick = { nav.navigate("orders") },
            label = { Text("Orders") },
            icon = {}
        )
        NavigationBarItem(
            selected = false,
            onClick = { nav.navigate("cart") },
            label = { Text("Cart") },
            icon = {}
        )
    }
}
