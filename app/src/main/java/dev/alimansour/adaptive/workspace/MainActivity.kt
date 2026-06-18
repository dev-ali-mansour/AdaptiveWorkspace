package dev.alimansour.adaptive.workspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.alimansour.adaptive.workspace.ui.theme.AdaptiveWorkspaceTheme
import dev.alimansour.adaptive.workspace.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdaptiveWorkspaceTheme {
                AppNavigation()
            }
        }
    }
}