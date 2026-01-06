package com.jminnovatech.enjoybazar.ui.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.jminnovatech.enjoybazar.core.session.SessionManager
import com.jminnovatech.enjoybazar.data.model.auth.UserRole
import com.jminnovatech.enjoybazar.ui.customer.CustomerRoot

@Composable
fun HomeRouter(
    role: UserRole,
    navController: NavController,
    sessionManager: SessionManager
) {
    when (role) {

        UserRole.CUSTOMER -> {
            CustomerRoot() // ✅ OK (session দরকার নেই)
        }

        UserRole.COMPANY -> {
            CompanyHome()
        }

        UserRole.DISTRIBUTOR -> {
            DistributorHome()
        }

        UserRole.EXECUTIVE -> {
            ExecutiveHome()
        }

        else -> {
            GuestUserHome()
        }
    }
}
