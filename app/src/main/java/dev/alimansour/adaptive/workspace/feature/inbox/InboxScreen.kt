package dev.alimansour.adaptive.workspace.feature.inbox

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.ui.tooling.preview.PreviewLightDark
import dev.alimansour.adaptive.workspace.data.Email
import dev.alimansour.adaptive.workspace.data.avatarColor
import dev.alimansour.adaptive.workspace.data.avatarInitial
import dev.alimansour.adaptive.workspace.navigation.EmailDetailRoute
import dev.alimansour.adaptive.workspace.navigation.InboxListRoute
import dev.alimansour.adaptive.workspace.ui.component.FormFactorPreviews
import dev.alimansour.adaptive.workspace.ui.theme.AdaptiveWorkspaceTheme

// ──────────────────────────────────────────────────────────────────────────────
// InboxNavigation — Nav3 ListDetailSceneStrategy
// Demonstrates the list-detail pattern from the presentation, upgraded to Nav3.
// ──────────────────────────────────────────────────────────────────────────────

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun InboxNavigation(viewModel: InboxViewModel = viewModel { InboxViewModel() }) {
    val backStack = rememberNavBackStack(InboxListRoute)
    val listDetailStrategy = rememberListDetailSceneStrategy<NavKey>()

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        sceneStrategies = listOf(listDetailStrategy),
        entryProvider = entryProvider {
            entry<InboxListRoute>(
                metadata = ListDetailSceneStrategy.listPane(
                    detailPlaceholder = { EmptyDetailPlaceholder() }
                )
            ) {
                InboxScreen(
                    emails = viewModel.emails,
                    onEmailClick = { email ->
                        backStack.add(EmailDetailRoute(email.id))
                    }
                )
            }

            entry<EmailDetailRoute>(
                metadata = ListDetailSceneStrategy.detailPane()
            ) { key ->
                val email = viewModel.emails.first { it.id == key.emailId }
                EmailDetailScreen(email = email)
            }
        }
    )
}

// ──────────────────────────────────────────────────────────────────────────────
// InboxScreen — Email List (list pane)
// ──────────────────────────────────────────────────────────────────────────────

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InboxScreen(
    emails: List<Email>,
    onEmailClick: (Email) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Inbox") },
                scrollBehavior = scrollBehavior
            )
        },
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(emails, key = { it.id }) { email ->
                EmailListItem(
                    email = email,
                    onClick = { onEmailClick(email) }
                )
                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            }
        }
    }
}

// ──────────────────────────────────────────────────────────────────────────────
// EmailListItem
// ──────────────────────────────────────────────────────────────────────────────

@Composable
private fun EmailListItem(
    email: Email,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.Top
    ) {
        // Avatar
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(email.avatarColor()),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = email.avatarInitial().toString(),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        // Content
        Column(modifier = Modifier.weight(1f)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = email.sender,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = if (!email.isRead) FontWeight.Bold else FontWeight.Normal,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = email.timestamp,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Text(
                text = email.subject,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = if (!email.isRead) FontWeight.SemiBold else FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = email.preview,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        // Star
        if (email.isStarred) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Starred",
                tint = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(20.dp)
            )
        }
    }
}

// ── Previews ─────────────────────────────────────────────────────────────────

@FormFactorPreviews
@PreviewLightDark
@Composable
private fun InboxScreenPreview() {
    AdaptiveWorkspaceTheme {
        InboxScreen(
            emails = dev.alimansour.adaptive.workspace.data.SampleData.emails,
            onEmailClick = {}
        )
    }
}
