package dev.alimansour.adaptive.workspace.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import dev.alimansour.adaptive.workspace.feature.dashboard.DashboardScreen
import dev.alimansour.adaptive.workspace.feature.inbox.InboxNavigation
import dev.alimansour.adaptive.workspace.feature.tags.TagsScreen

/**
 * App-level navigation shell using **NavigationSuiteScaffold** —
 * the second code snippet from the presentation.
 *
 * Automatically adapts: **Bottom bar** for phones, **Nav Rail** for tablets!
 */
@Composable
fun AppNavigation() {
    var selectedDestination by rememberSaveable { mutableIntStateOf(0) }
    val destinations = TopLevelDestination.entries

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            destinations.forEachIndexed { index, destination ->
                item(
                    icon = {
                        Icon(
                            imageVector = destination.icon,
                            contentDescription = destination.label
                        )
                    },
                    label = { Text(destination.label) },
                    selected = selectedDestination == index,
                    onClick = { selectedDestination = index }
                )
            }
        }
    ) {
        // Each destination showcases a different adaptive API
        when (destinations[selectedDestination]) {
            TopLevelDestination.INBOX -> InboxNavigation()        // Nav3 ListDetailSceneStrategy
            TopLevelDestination.DASHBOARD -> DashboardScreen()    // Grid API
            TopLevelDestination.TAGS -> TagsScreen()              // FlexBox API
        }
    }
}
