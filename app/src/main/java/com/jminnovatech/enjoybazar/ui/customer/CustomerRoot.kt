package com.jminnovatech.enjoybazar.ui.customer

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.jminnovatech.enjoybazar.core.session.SessionManager
import com.jminnovatech.enjoybazar.ui.customer.drawer.CustomerDrawer
import com.jminnovatech.enjoybazar.ui.customer.vm.CustomerViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomerRoot() {

    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val context = LocalContext.current
    val session = remember { SessionManager(context) }
    val userName = session.getUserName() ?: "Customer"

    // 🔹 Shared ViewModel
    val vm: CustomerViewModel = viewModel()
    val cart by vm.cart.collectAsState()
    // 🔙 Back closes drawer
    BackHandler(drawerState.isOpen) {
        scope.launch { drawerState.close() }
    }

    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            CustomerDrawer(
                currentRoute = currentRoute,
                userName = userName,
                onNavigate = { route ->
                    navController.navigate(route) {
                        launchSingleTop = true
                    }
                    scope.launch { drawerState.close() }
                },
                onLogout = {
                    session.clear()
                    navController.navigate("login") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            )
        }
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("EnjoyBazar") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = null)
                        }
                    }
                )
            },
            bottomBar = {
                CustomerBottomBar(
                    nav = navController,
                    cartCount = cart.size
                )
            }
        ) { padding ->

            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier.padding(padding)
            ) {
                composable("home") { CustomerHomeScreen(vm) }
                composable("orders") { CustomerOrdersScreen(vm) }
                composable("cart") { CustomerCart(vm) }
                composable("address") { AddressScreen(vm) }
            }
        }
    }
}
