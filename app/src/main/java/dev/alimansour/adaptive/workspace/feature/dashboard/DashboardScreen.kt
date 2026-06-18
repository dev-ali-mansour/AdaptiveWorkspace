package dev.alimansour.adaptive.workspace.feature.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.ExperimentalGridApi
import androidx.compose.foundation.layout.Grid
import androidx.compose.foundation.layout.GridTrackSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
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
import dev.alimansour.adaptive.workspace.data.SampleData
import dev.alimansour.adaptive.workspace.ui.component.FormFactorPreviews
import dev.alimansour.adaptive.workspace.ui.theme.AdaptiveWorkspaceTheme

/**
 * Dashboard screen using the **Grid API** — the fourth code snippet
 * from the presentation.
 *
 * Demonstrates adaptive grid layout:
 * - 2 columns on phones (< 600dp)
 * - 4 columns on tablets (≥ 600dp)
 *
 * Uses `constraints.maxWidth.toDp()` inside the Grid `config` block
 * for truly responsive column counts.
 */
@OptIn(ExperimentalGridApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(viewModel: DashboardViewModel = viewModel { DashboardViewModel() }) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dashboard") },
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
            // ── Stat Cards Grid ──────────────────────────────────────────
            Grid(
                config = {
                    // Adaptive columns based on available width
                    val maxWidthDp = constraints.maxWidth.toDp()
                    val cols = if (maxWidthDp < 600.dp) 2 else 4

                    repeat(cols) { column(1.fr) }
                    repeat(if (cols == 2) 2 else 1) { row(GridTrackSize.Auto) }
                    gap(16.dp)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                viewModel.stats.forEach { stat ->
                    DashboardCard(stat = stat)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ── Chart ────────────────────────────────────────────────────
            Text(
                text = "Weekly Revenue",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))

            ChartWidget(
                data = viewModel.chartData,
                labels = viewModel.chartLabels,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )
        }
    }
}

// ── Previews ────────────────────────────────────────────────────────────────

@FormFactorPreviews
@PreviewLightDark
@Composable
private fun DashboardScreenPreview() {
    AdaptiveWorkspaceTheme {
        DashboardScreen()
    }
}
