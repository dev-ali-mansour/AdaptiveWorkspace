package dev.alimansour.adaptive.workspace.feature.dashboard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.alimansour.adaptive.workspace.ui.theme.ChartBlue
import dev.alimansour.adaptive.workspace.ui.theme.Indigo40

/**
 * Canvas-drawn bar chart showing weekly data.
 * Gradient-filled bars with rounded top corners and day-of-week labels.
 */
@Composable
fun ChartWidget(
    data: List<Float>,
    labels: List<String>,
    modifier: Modifier = Modifier
) {
    val barGradient = Brush.verticalGradient(colors = listOf(ChartBlue, Indigo40))
    val labelColor = MaterialTheme.colorScheme.onSurfaceVariant
    val gridLineColor = MaterialTheme.colorScheme.outlineVariant
    val textMeasurer = rememberTextMeasurer()
    val labelStyle = TextStyle(fontSize = 11.sp, color = labelColor)

    ElevatedCard(modifier = modifier) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            val maxValue = data.max()
            val bottomPadding = 24.dp.toPx()     // space for labels
            val topPadding = 8.dp.toPx()
            val chartHeight = size.height - bottomPadding - topPadding
            val barCount = data.size
            val totalGapWidth = size.width * 0.3f
            val gapWidth = totalGapWidth / (barCount + 1)
            val barWidth = (size.width - totalGapWidth) / barCount

            // Grid lines
            for (i in 0..3) {
                val y = topPadding + chartHeight * (1f - i / 3f)
                drawLine(
                    color = gridLineColor,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = 1.dp.toPx()
                )
            }

            // Bars + labels
            data.forEachIndexed { index, value ->
                val barHeight = (value / maxValue) * chartHeight
                val x = gapWidth + index * (barWidth + gapWidth)
                val y = topPadding + chartHeight - barHeight

                drawRoundRect(
                    brush = barGradient,
                    topLeft = Offset(x, y),
                    size = Size(barWidth, barHeight),
                    cornerRadius = CornerRadius(6.dp.toPx(), 6.dp.toPx())
                )

                // Day label
                if (index < labels.size) {
                    val textResult = textMeasurer.measure(labels[index], labelStyle)
                    drawText(
                        textLayoutResult = textResult,
                        topLeft = Offset(
                            x + (barWidth - textResult.size.width) / 2f,
                            size.height - bottomPadding + 6.dp.toPx()
                        )
                    )
                }
            }
        }
    }
}
