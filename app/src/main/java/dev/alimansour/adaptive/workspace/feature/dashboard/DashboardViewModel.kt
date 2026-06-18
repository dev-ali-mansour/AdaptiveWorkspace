package dev.alimansour.adaptive.workspace.feature.dashboard

import androidx.lifecycle.ViewModel
import dev.alimansour.adaptive.workspace.data.DashboardStat
import dev.alimansour.adaptive.workspace.data.SampleData

class DashboardViewModel : ViewModel() {
    val stats: List<DashboardStat> = SampleData.dashboardStats
    val chartData: List<Float> = SampleData.chartData
    val chartLabels: List<String> = SampleData.chartLabels
}
