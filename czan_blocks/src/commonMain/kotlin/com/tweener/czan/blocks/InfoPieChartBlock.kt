package com.tweener.czan.blocks

/**
 * @author Vivien Mahe
 * @since 05/02/2025
 */

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tweener.chartopia.type.donut.Active
import com.tweener.chartopia.type.donut.DonutChart
import com.tweener.chartopia.type.donut.DonutChartDefault
import com.tweener.chartopia.type.donut.model.Segment
import com.tweener.czan.blocks.theme.onBackgroundVariant
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.designsystem.organism.card.Card
import com.tweener.czan.designsystem.organism.card.CardDefaults
import com.tweener.czan.theme.Size
import com.tweener.kmpkit.kotlinextensions.degrees

@Composable
fun InfoPieChartBlock(
    title: String,
    segments: List<Segment>,
    modifier: Modifier = Modifier,
    headline: String? = null,
    animationDurationMillis: Int = 500,
    onSegmentClicked: ((Segment, Active) -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.colors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground,
            borderStrokeColor = MaterialTheme.colorScheme.outline,
        ),
        sizes = CardDefaults.sizes(
            elevation = 0.dp,
            contentPadding = PaddingValues(start = Size.Padding.Default, end = Size.Padding.ExtraSmall, top = Size.Padding.Tiny, bottom = Size.Padding.Tiny),
        ),
        showDividers = false,
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
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    lines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                headline?.let {
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
                modifier = Modifier.size(116.dp),
                contentAlignment = Alignment.Center,
            ) {
                DonutChart(
                    modifier = Modifier.fillMaxWidth(),
                    segments = segments,
                    startAngleFromOrigin = 270f.degrees,
                    sizes = DonutChartDefault.chartSizes(strokeWidth = 8.dp, selectedStrokeWidth = 8.dp, angleBetweenSegments = 0f.degrees),
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
