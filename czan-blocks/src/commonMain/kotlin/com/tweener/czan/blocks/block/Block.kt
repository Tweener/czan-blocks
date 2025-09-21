package com.tweener.czan.blocks.block

/**
 * @author Vivien Mahe
 * @since 01/02/2025
 */

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan.blocks.theme.onBackgroundVariant
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.designsystem.organism.card.Card
import com.tweener.czan.designsystem.organism.card.CardDefaults
import com.tweener.czan.theme.Size

@Composable
fun Block(
    modifier: Modifier = Modifier,
    title: String? = null,
    headline: String? = null,
    shape: Shape = BlockDefaults.shape,
    colors: BlockColors = BlockDefaults.colors(),
    sizes: BlockSizes = BlockDefaults.sizes(),
    onClick: (() -> Unit)? = null,
    extraTitle: @Composable (() -> Unit)? = null,
    footer: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier,
        shape = shape,
        colors = CardDefaults.colors(
            containerColor = colors.containerColor(),
            containerBrush = colors.containerBrush(),
            contentColor = colors.contentColor(),
            borderStrokeColor = colors.borderStrokeColor(),
            shadowColor = colors.shadowColor(),
        ),
        sizes = CardDefaults.sizes(
            elevation = sizes.elevation(),
            contentPadding = sizes.contentPadding(),
            headerPadding = sizes.headerPadding(),
            footerPadding = sizes.footerPadding(),
            borderStrokeWidth = sizes.borderStrokeWidth(),
        ),
        showDividers = false,
        onClick = onClick,
        header = title?.let {
            {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(Size.Padding.ExtraSmall),
                    verticalAlignment = Alignment.Top,
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(Size.Padding.Tiny),
                    ) {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Medium,
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

                    extraTitle?.invoke()
                }
            }
        },
        footer = footer?.let { { it() } }
    ) {
        content()
    }
}

object BlockDefaults {

    internal val shape: Shape @Composable get() = MaterialTheme.shapes.large

    internal val contentPaddingDefault: PaddingValues = PaddingValues(all = Size.Padding.Default)
    internal val headerPaddingDefault: PaddingValues = PaddingValues(start = Size.Padding.Default, end = Size.Padding.Default, top = Size.Padding.Default, bottom = 0.dp)
    internal val footerPaddingDefault: PaddingValues = PaddingValues(start = Size.Padding.Default, end = Size.Padding.Default, top = 0.dp, bottom = Size.Padding.Default)
    internal val elevationDefault: Dp = 0.dp
    internal val borderStrokeWidthDefault: Dp = 1.dp

    internal val containerColorDefault: Color @Composable get() = MaterialTheme.colorScheme.background
    internal val contentColorDefault: Color @Composable get() = MaterialTheme.colorScheme.onBackground
    internal val borderStrokeColorDefault: Color @Composable get() = MaterialTheme.colorScheme.outline
    internal val shadowColorDefault: Color @Composable get() = Color.Black.copy(alpha = 0.08f)

    @Composable
    fun colors(
        containerColor: Color = containerColorDefault,
        containerBrush: Brush? = null,
        contentColor: Color = contentColorDefault,
        borderStrokeColor: Color = borderStrokeColorDefault,
        shadowColor: Color = shadowColorDefault,
    ): BlockColors = BlockColors(
        containerColor = containerColor,
        containerBrush = containerBrush,
        contentColor = contentColor,
        borderStrokeColor = borderStrokeColor,
        shadowColor = shadowColor,
    )

    @Composable
    fun sizes(
        contentPadding: PaddingValues = contentPaddingDefault,
        headerPadding: PaddingValues = headerPaddingDefault,
        footerPadding: PaddingValues = footerPaddingDefault,
        elevation: Dp = elevationDefault,
        borderStrokeWidth: Dp = borderStrokeWidthDefault,
    ): BlockSizes = BlockSizes(
        contentPadding = contentPadding,
        headerPadding = headerPadding,
        footerPadding = footerPadding,
        elevation = elevation,
        borderStrokeWidth = borderStrokeWidth,
    )
}

@Immutable
open class BlockColors internal constructor(
    private val containerColor: Color,
    private val containerBrush: Brush?,
    private val contentColor: Color,
    private val borderStrokeColor: Color,
    private val shadowColor: Color,
) {
    @Composable
    internal fun containerColor(): Color = containerColor

    @Composable
    internal fun containerBrush(): Brush? = containerBrush

    @Composable
    internal fun contentColor(): Color = contentColor

    @Composable
    internal fun borderStrokeColor(): Color = borderStrokeColor

    @Composable
    internal fun shadowColor(): Color = shadowColor
}

@Immutable
open class BlockSizes internal constructor(
    private val contentPadding: PaddingValues,
    private val headerPadding: PaddingValues = contentPadding,
    private val footerPadding: PaddingValues = contentPadding,
    private val elevation: Dp,
    private val borderStrokeWidth: Dp,
) {
    internal fun contentPadding(): PaddingValues = contentPadding

    internal fun headerPadding(): PaddingValues = headerPadding

    internal fun footerPadding(): PaddingValues = footerPadding

    internal fun elevation(): Dp = elevation

    internal fun borderStrokeWidth(): Dp = borderStrokeWidth
}
