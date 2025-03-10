package com.tweener.czan.blocks.block.charts

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
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
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
import com.tweener.czan.blocks.block.Block
import com.tweener.czan.blocks.block.BlockDefaults
import com.tweener.czan.blocks.theme.onBackgroundVariant
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size
import com.tweener.kmpkit.kotlinextensions.degrees
import com.tweener.kmpkit.utils.Degrees

@Composable
fun InfoPieChartBlock(
    title: String,
    progressInfo: String,
    segments: List<Segment>,
    modifier: Modifier = Modifier,
    headline: String? = null,
    totalInfo: String? = null,
    progressHeadline: String? = null,
    shape: Shape = BlockDefaults.shape,
    sizes: InfoPieChartBlockSizes = InfoPieChartBlockDefaults.sizes(),
    animationDurationMillis: Int = InfoPieChartBlockDefaults.ANIMATION_DURATION_MILLIS,
    onSegmentClicked: ((Segment, Active) -> Unit)? = null,
    extraTitle: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Block(
        modifier = modifier,
        title = title,
        headline = headline,
        extraTitle = extraTitle,
        shape = shape,
        sizes = BlockDefaults.sizes(
            elevation = sizes.elevation(),
        ),
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
                modifier = Modifier.size(sizes.chartSize()),
                contentAlignment = Alignment.Center,
            ) {
                DonutChart(
                    modifier = Modifier.fillMaxWidth(),
                    segments = segments,
                    startAngleFromOrigin = sizes.chartStartAngleFromOrigin(),
                    sizes = DonutChartDefault.sizes(
                        strokeWidth = sizes.chartStrokeWidth(),
                        selectedStrokeWidth = sizes.chartSelectedStrokeWidth(),
                        angleBetweenSegments = sizes.chartAngleBetweenSegments(),
                    ),
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

object InfoPieChartBlockDefaults {

    internal const val ANIMATION_DURATION_MILLIS: Int = 500
    private val chartSize: Dp = 96.dp
    private val chartStartAngleFromOrigin = 270f.degrees
    private val chartStrokeWidth: Dp = 8.dp
    private val chartSelectedStrokeWidth: Dp = 8.dp
    private val chartAngleBetweenSegments: Degrees = 0f.degrees

    fun sizes(
        elevation: Dp = BlockDefaults.elevationDefault,
        chartSize: Dp = InfoPieChartBlockDefaults.chartSize,
        chartStrokeWidth: Dp = InfoPieChartBlockDefaults.chartStrokeWidth,
        chartSelectedStrokeWidth: Dp = InfoPieChartBlockDefaults.chartSelectedStrokeWidth,
        chartStartAngleFromOrigin: Degrees = InfoPieChartBlockDefaults.chartStartAngleFromOrigin,
        chartAngleBetweenSegments: Degrees = InfoPieChartBlockDefaults.chartAngleBetweenSegments,
    ): InfoPieChartBlockSizes = InfoPieChartBlockSizes(
        elevation = elevation,
        chartSize = chartSize,
        chartStrokeWidth = chartStrokeWidth,
        chartSelectedStrokeWidth = chartSelectedStrokeWidth,
        chartStartAngleFromOrigin = chartStartAngleFromOrigin,
        chartAngleBetweenSegments = chartAngleBetweenSegments,
    )
}

@Immutable
open class InfoPieChartBlockSizes internal constructor(
    private val elevation: Dp,
    private val chartSize: Dp,
    private val chartStrokeWidth: Dp,
    private val chartSelectedStrokeWidth: Dp,
    private val chartStartAngleFromOrigin: Degrees,
    private val chartAngleBetweenSegments: Degrees,
) {
    internal fun elevation(): Dp = elevation

    internal fun chartSize(): Dp = chartSize

    internal fun chartStrokeWidth(): Dp = chartStrokeWidth

    internal fun chartSelectedStrokeWidth(): Dp = chartSelectedStrokeWidth

    internal fun chartStartAngleFromOrigin(): Degrees = chartStartAngleFromOrigin

    internal fun chartAngleBetweenSegments(): Degrees = chartAngleBetweenSegments
}
