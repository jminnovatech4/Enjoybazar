package com.jminnovatech.enjoybazar.ui.customer.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CustomerDrawer(
    currentRoute: String?,
    userName: String,
    onNavigate: (String) -> Unit,
    onLogout: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(280.dp)
            .background(MaterialTheme.colorScheme.surface) // ✅ THIS LINE
            .padding(16.dp)
    ) {

        Text("👋 Hello $userName", fontWeight = FontWeight.Bold)
        Text("EnjoyBazar", color = Color.Gray)

        Spacer(Modifier.height(24.dp))
        Divider()

        DrawerItem(
            icon = "🏠",
            title = "Home",
            selected = currentRoute == "home",
            onClick = { onNavigate("home") }
        )

        DrawerItem(
            icon = "📦",
            title = "My Orders",
            selected = currentRoute == "orders",
            onClick = { onNavigate("orders") }
        )

        DrawerItem(
            icon = "🛒",
            title = "Cart",
            selected = currentRoute == "cart",
            onClick = { onNavigate("cart") }
        )

        DrawerItem(
            icon = "🏠",
            title = "Address",
            selected = currentRoute == "address",
            onClick = { onNavigate("address") }
        )

        Spacer(Modifier.weight(1f))
        Divider()

        TextButton(
            onClick = onLogout,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Logout", color = Color.Red)
        }
    }
}
