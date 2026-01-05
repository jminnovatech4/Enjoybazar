package com.jminnovatech.enjoybazar.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import com.jminnovatech.enjoybazar.core.session.SessionManager
import com.jminnovatech.enjoybazar.domain.model.UserRole
import com.jminnovatech.enjoybazar.ui.customer.CustomerRoot
import kotlinx.coroutines.launch


@Composable
fun HomeRouter(
    role: UserRole,
    navController: NavController,
    sessionManager: SessionManager
) {
    val scope = rememberCoroutineScope()

    when (role) {

        UserRole.COMPANY -> CompanyHome()
        UserRole.SR_EXECUTIVE -> SrExecutiveHome()
        UserRole.EXECUTIVE -> ExecutiveHome()
        UserRole.DISTRIBUTOR -> DistributorHome()

        UserRole.CUSTOMER -> CustomerRoot(
            onLogout = {
                scope.launch {
                    sessionManager.clearSession()
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.HOME) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            }
        )

        UserRole.USER -> GuestUserHome()
    }
}
