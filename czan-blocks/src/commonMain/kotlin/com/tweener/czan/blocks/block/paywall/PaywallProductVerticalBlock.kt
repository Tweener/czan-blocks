package com.tweener.czan.blocks.block.paywall

/**
 * @author Vivien Mahe
 * @since 25/02/2025
 */

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tweener.czan._internal.kotlinextensions.conditional
import com.tweener.czan.blocks.block.Block
import com.tweener.czan.blocks.block.BlockDefaults
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size

@Composable
fun PaywallProductVerticalBlock(
    productTitle: String,
    productAmount: String,
    modifier: Modifier = Modifier,
    productAmountHeadline: AnnotatedString? = null,
    promoTagText: String? = null,
    selected: Boolean = false,
    shape: Shape = PaywallProductBlockDefaults.shape,
    colors: PaywallProductBlockColors = PaywallProductBlockDefaults.colors(),
    sizes: PaywallProductBlockSizes = PaywallProductBlockDefaults.sizes(),
    onClick: (() -> Unit)? = null,
) {
    Block(
        modifier = modifier.width(120.dp),
        shape = shape,
        colors = BlockDefaults.colors(
            containerColor = colors.containerColor(),
            borderStrokeColor = colors.cardBorderStrokeColor(selected = selected),
        ),
        sizes = BlockDefaults.sizes(
            borderStrokeWidth = sizes.cardBorderStrokeWidth(selected = selected),
            contentPadding = PaddingValues(0.dp),
        ),
        onClick = onClick,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Promo tag
            Box(
                modifier = Modifier
                    .fillMaxWidth()
//                    .alpha(promoTagText?.let { 1f } ?: 0f)
                    .clip(shape = RoundedCornerShape(topStart = sizes.promoTagRoundedCornerSize(), topEnd = sizes.promoTagRoundedCornerSize()))
                    .conditional(
                        condition = colors.promoTagContainerBrush() != null,
                        ifTrue = { background(colors.promoTagContainerBrush()!!) },
                        ifFalse = { background(colors.promoTagContainerColor()) },
                    )
                    .padding(sizes.promoTagPadding()),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = promoTagText ?: "",
                    color = colors.promoTagContentColor(),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                )
            }

            Column(
                modifier = Modifier.padding(sizes.contentPadding()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = productTitle,
                    color = colors.productTitleColor(),
                    style = MaterialTheme.typography.titleMedium,
                )

                Spacer(modifier = Modifier.padding(vertical = Size.Padding.ExtraSmall))

                Text(
                    text = productAmount,
                    color = colors.productAmountColor(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.End,
                )

                Spacer(modifier = Modifier.padding(vertical = Size.Padding.Tiny))

                productAmountHeadline?.let {
                    Text(
                        text = it,
                        color = colors.productAmountHeadlineColor(),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.End,
                    )
                }
            }
        }
    }
}
