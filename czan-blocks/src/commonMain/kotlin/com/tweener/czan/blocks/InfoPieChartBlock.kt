package com.tweener.czan.blocks

/**
 * @author Vivien Mahe
 * @since 05/02/2025
 */

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.chartopia.type.donut.Active
import com.tweener.chartopia.type.donut.DonutChart
import com.tweener.chartopia.type.donut.DonutChartDefault
import com.tweener.chartopia.type.donut.model.Segment
import com.tweener.czan.blocks.theme.onBackgroundVariant
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size
import com.tweener.kmpkit.kotlinextensions.degrees

@Composable
fun InfoPieChartBlock(
    title: String,
    progressInfo: String,
    segments: List<Segment>,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,
    headline: String? = null,
    totalInfo: String? = null,
    progressHeadline: String? = null,
    chartSize: Dp = 96.dp,
    animationDurationMillis: Int = 500,
    onSegmentClicked: ((Segment, Active) -> Unit)? = null,
    extraTitle: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Block(
        modifier = modifier,
        title = title,
        headline = headline,
        elevation = elevation,
        extraTitle = extraTitle,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Size.Padding.Small),
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(Size.Padding.Tiny),
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(Size.Padding.ExtraSmall),
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Text(
                        modifier = Modifier.alignBy(LastBaseline),
                        text = progressInfo,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        lines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )

                    totalInfo?.let {
                        Text(
                            modifier = Modifier.alignBy(LastBaseline),
                            text = it,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackgroundVariant,
                            fontWeight = FontWeight.Normal,
                            lines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }

                progressHeadline?.let {
                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.onBackgroundVariant,
                        style = MaterialTheme.typography.bodyLarge,
                        lines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }

            Box(
                modifier = Modifier.size(chartSize),
                contentAlignment = Alignment.Center,
            ) {
                DonutChart(
                    modifier = Modifier.fillMaxWidth(),
                    segments = segments,
                    startAngleFromOrigin = 270f.degrees,
                    sizes = DonutChartDefault.sizes(strokeWidth = 8.dp, selectedStrokeWidth = 8.dp, angleBetweenSegments = 0f.degrees),
                    animated = true,
                    animationDurationMillis = animationDurationMillis,
                    strokeCap = StrokeCap.Butt,
                    onSegmentClicked = onSegmentClicked,
                )

                content()
            }
        }
    }
}
