package dev.alimansour.adaptive.workspace.feature.tags

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalFlexBoxApi
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.FlexBox
import androidx.compose.foundation.layout.FlexWrap
import androidx.compose.foundation.layout.FlexJustifyContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.alimansour.adaptive.workspace.ui.component.FormFactorPreviews
import dev.alimansour.adaptive.workspace.ui.theme.AdaptiveWorkspaceTheme

/**
 * Tags screen using the **FlexBox API** — the third code snippet
 * from the presentation.
 *
 * Demonstrates:
 * - `FlexBox` with `FlexWrap.Wrap` for automatic wrapping
 * - `JustifyContent.Start` for left-aligned chips
 * - `Modifier.flex { grow(1f) }` for items sharing space
 * - Selectable `FilterChip` with toggle state
 */
@OptIn(ExperimentalFlexBoxApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TagsScreen(viewModel: TagsViewModel = viewModel { TagsViewModel() }) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tags") },
                scrollBehavior = scrollBehavior
            )
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Filter by Tags",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(12.dp))

            FlexBox(
                config = {
                    wrap(FlexWrap.Wrap)
                    justifyContent(FlexJustifyContent.Start)
                    gap(8.dp)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                viewModel.tags.forEach { tag ->
                    val isSelected = tag.id in viewModel.selectedTagIds
                    FilterChip(
                        selected = isSelected,
                        onClick = { viewModel.toggleTag(tag.id) },
                        label = { Text(tag.label) },
                        modifier = Modifier.flex { grow(1f) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Selected tags summary
            val selectedCount = viewModel.selectedTagIds.size
            Text(
                text = if (selectedCount > 0) {
                    "$selectedCount tag${if (selectedCount > 1) "s" else ""} selected"
                } else {
                    "No tags selected"
                },
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            if (selectedCount > 0) {
                Spacer(modifier = Modifier.height(8.dp))
                val selectedLabels = viewModel.tags
                    .filter { it.id in viewModel.selectedTagIds }
                    .joinToString(", ") { it.label }
                Text(
                    text = selectedLabels,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

// ── Previews ────────────────────────────────────────────────────────────────

@FormFactorPreviews
@PreviewLightDark
@Composable
private fun TagsScreenPreview() {
    AdaptiveWorkspaceTheme {
        TagsScreen()
    }
}
