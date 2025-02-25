package com.tweener.czan.blocks.block.paywall

/**
 * @author Vivien Mahe
 * @since 10/02/2025
 */

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan.theme.Size

object PaywallProductBlockDefaults {

    val shape: Shape @Composable get() = MaterialTheme.shapes.large
    private val borderStrokeWidth: Dp = 1.dp
    private val selectedBorderStrokeWidth: Dp = 2.dp

    @Composable
    fun colors(
        containerColor: Color = MaterialTheme.colorScheme.background,
        borderStrokeColor: Color = MaterialTheme.colorScheme.outline,
        selectedBorderStrokeColor: Color = MaterialTheme.colorScheme.primary,
        productTitleColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
        productHeadlineColor: Color = MaterialTheme.colorScheme.onBackground,
        productAmountColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
        productAmountHeadlineColor: Color = MaterialTheme.colorScheme.onBackground,
        radioButtonColor: Color = MaterialTheme.colorScheme.onBackground,
        checkedRadioButtonColor: Color = selectedBorderStrokeColor,
        promoTagContainerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
        promoTagContainerBrush: Brush? = null,
        promoTagContentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    ): PaywallProductBlockColors = PaywallProductBlockColors(
        containerColor = containerColor,
        borderStrokeColor = borderStrokeColor,
        selectedBorderStrokeColor = selectedBorderStrokeColor,
        productTitleColor = productTitleColor,
        productHeadlineColor = productHeadlineColor,
        productAmountColor = productAmountColor,
        productAmountHeadlineColor = productAmountHeadlineColor,
        radioButtonColor = radioButtonColor,
        checkedRadioButtonColor = checkedRadioButtonColor,
        promoTagContainerColor = promoTagContainerColor,
        promoTagContainerBrush = promoTagContainerBrush,
        promoTagContentColor = promoTagContentColor,
    )


    @Composable
    fun sizes(
        contentPadding: PaddingValues = PaddingValues(top = Size.Padding.Default, end = Size.Padding.Large, bottom = Size.Padding.Default, start = Size.Padding.Small),
        borderStrokeWidth: Dp = PaywallProductBlockDefaults.borderStrokeWidth,
        selectedBorderStrokeWidth: Dp = PaywallProductBlockDefaults.selectedBorderStrokeWidth,
        promoTagRoundedCornerSize: Dp = Size.Padding.Small,
        promoTagPadding: PaddingValues = PaddingValues(horizontal = Size.Padding.ExtraSmall, vertical = Size.Padding.Tiny),
    ): PaywallProductBlockSizes = PaywallProductBlockSizes(
        contentPadding = contentPadding,
        borderStrokeWidth = borderStrokeWidth,
        selectedBorderStrokeWidth = selectedBorderStrokeWidth,
        promoTagRoundedCornerSize = promoTagRoundedCornerSize,
        promoTagPadding = promoTagPadding,
    )
}

@Immutable
class PaywallProductBlockColors internal constructor(
    private val containerColor: Color,
    private val borderStrokeColor: Color,
    private val selectedBorderStrokeColor: Color,
    private val productTitleColor: Color,
    private val productHeadlineColor: Color,
    private val productAmountColor: Color,
    private val productAmountHeadlineColor: Color,
    private val radioButtonColor: Color,
    private val checkedRadioButtonColor: Color,
    private val promoTagContainerColor: Color,
    private val promoTagContainerBrush: Brush?,
    private val promoTagContentColor: Color,
) {
    @Composable
    internal fun containerColor(): Color = containerColor

    @Composable
    internal fun productTitleColor(): Color = productTitleColor

    @Composable
    internal fun productHeadlineColor(): Color = productHeadlineColor

    @Composable
    internal fun productAmountColor(): Color = productAmountColor

    @Composable
    internal fun productAmountHeadlineColor(): Color = productAmountHeadlineColor

    @Composable
    internal fun radioButtonColor(): Color = radioButtonColor

    @Composable
    internal fun checkedRadioButtonColor(): Color = checkedRadioButtonColor

    @Composable
    internal fun promoTagContainerColor(): Color = promoTagContainerColor

    @Composable
    internal fun promoTagContainerBrush(): Brush? = promoTagContainerBrush

    @Composable
    internal fun promoTagContentColor(): Color = promoTagContentColor

    @Composable
    internal fun cardBorderStrokeColor(selected: Boolean): Color = if (selected) selectedBorderStrokeColor else borderStrokeColor
}

@Immutable
class PaywallProductBlockSizes internal constructor(
    private val contentPadding: PaddingValues,
    private val borderStrokeWidth: Dp,
    private val selectedBorderStrokeWidth: Dp,
    private val promoTagRoundedCornerSize: Dp,
    private val promoTagPadding: PaddingValues,
) {
    internal fun contentPadding(): PaddingValues = contentPadding

    internal fun promoTagRoundedCornerSize(): Dp = promoTagRoundedCornerSize

    internal fun promoTagPadding(): PaddingValues = promoTagPadding

    internal fun cardBorderStrokeWidth(selected: Boolean): Dp = if (selected) selectedBorderStrokeWidth else borderStrokeWidth
}
