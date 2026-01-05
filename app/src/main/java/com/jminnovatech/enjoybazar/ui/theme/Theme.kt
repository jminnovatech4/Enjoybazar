package com.jminnovatech.enjoybazar.core.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.jminnovatech.enjoybazar.ui.theme.Background
import com.jminnovatech.enjoybazar.ui.theme.Primary

@Composable
fun EnjoyBazarTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Primary,
            background = Background
        ),
        content = content
    )
}
