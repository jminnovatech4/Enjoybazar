package com.jminnovatech.enjoybazar.ui.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.*
import com.jminnovatech.enjoybazar.core.session.SessionManager
import com.jminnovatech.enjoybazar.domain.model.UserRole
import com.jminnovatech.enjoybazar.ui.auth.LoginScreen
import com.jminnovatech.enjoybazar.ui.home.HomeRouter
import com.jminnovatech.enjoybazar.ui.splash.SplashScreen
import com.jminnovatech.enjoybazar.util.mapRole

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()
    val context = LocalContext.current
    val sessionManager = remember { SessionManager(context) }

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {

        composable(Routes.SPLASH) {
            SplashScreen(navController)
        }

        composable(Routes.LOGIN) {
            LoginScreen(navController)
        }

        composable(Routes.HOME) {

            var role by remember { mutableStateOf<UserRole?>(null) }

            LaunchedEffect(Unit) {
                val roleString = sessionManager.getRole()
                role = roleString?.let { UserRole.valueOf(it.uppercase()) }
            }

            role?.let { safeRole ->
                HomeRouter(
                    role = safeRole,
                    navController = navController,
                    sessionManager = sessionManager
                )
            }
        }
    }
}

