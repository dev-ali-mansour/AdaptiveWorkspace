package dev.alimansour.adaptive.workspace.data

import androidx.compose.ui.graphics.vector.ImageVector

data class DashboardStat(
    val title: String,
    val value: String,
    val change: String,
    val isPositive: Boolean,
    val icon: ImageVector
)
