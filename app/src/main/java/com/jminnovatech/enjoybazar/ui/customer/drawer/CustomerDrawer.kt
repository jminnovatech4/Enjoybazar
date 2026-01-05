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
    onLogout: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(280.dp)
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {

        Text(
            text = "👋 Hello Customer",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "EnjoyBazar",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(Modifier.height(24.dp))
        Divider()
        Spacer(Modifier.height(16.dp))

        DrawerItem("🛒", "Your Cart")
        DrawerItem("📦", "My Orders")
        DrawerItem("🏠", "Address")
        DrawerItem("📞", "Support")

        Spacer(Modifier.weight(1f))
        Divider()

        TextButton(
            onClick = onLogout,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Logout",
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
