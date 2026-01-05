package com.jminnovatech.enjoybazar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jminnovatech.enjoybazar.core.ui.theme.EnjoyBazarTheme
import com.jminnovatech.enjoybazar.ui.navigation.AppNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnjoyBazarTheme {
                AppNavGraph()
            }
        }
    }
}
