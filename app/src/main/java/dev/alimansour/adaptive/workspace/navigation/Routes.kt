package dev.alimansour.adaptive.workspace.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.automirrored.filled.Label
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

// ── Nav3 routes (used with NavDisplay + ListDetailSceneStrategy) ─────────────

@Serializable
data object InboxListRoute : NavKey

@Serializable
data class EmailDetailRoute(val emailId: String) : NavKey

// ── Top-level destinations (used with NavigationSuiteScaffold) ───────────────

enum class TopLevelDestination(
    val label: String,
    val icon: ImageVector
) {
    INBOX("Inbox", Icons.Default.Inbox),
    DASHBOARD("Dashboard", Icons.Default.Dashboard),
    TAGS("Tags", Icons.AutoMirrored.Filled.Label)
}
