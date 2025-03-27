package com.tweener.czan.blocks.block.paywall

/**
 * @author Vivien Mahe
 * @since 25/02/2025
 */

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.tweener.czan._internal.kotlinextensions.conditional
import com.tweener.czan.blocks.block.Block
import com.tweener.czan.blocks.block.BlockDefaults
import com.tweener.czan.designsystem.atom.radiobutton.RadioButton
import com.tweener.czan.designsystem.atom.radiobutton.RadioButtonDefaults
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size

@Composable
fun PaywallProductHorizontalBlock(
    productTitle: String,
    productAmount: String,
    modifier: Modifier = Modifier,
    productHeadline: String? = null,
    productAmountHeadline: AnnotatedString? = null,
    promoTagText: String? = null,
    selected: Boolean = false,
    shape: Shape = PaywallProductBlockDefaults.shape,
    colors: PaywallProductBlockColors = PaywallProductBlockDefaults.colors(),
    sizes: PaywallProductBlockSizes = PaywallProductBlockDefaults.sizes(),
    onClick: (() -> Unit)? = null,
) {
    Block(
        modifier = modifier,
        shape = shape,
        colors = BlockDefaults.colors(
            containerColor = colors.containerColor(),
            borderStrokeColor = colors.cardBorderStrokeColor(selected = selected),
        ),
        sizes = BlockDefaults.sizes(
            borderStrokeWidth = sizes.cardBorderStrokeWidth(selected = selected),
            contentPadding = sizes.contentPadding(),
        ),
        onClick = onClick,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Size.Padding.Small),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            RadioButton(
                checked = selected,
                colors = RadioButtonDefaults.colors(
                    contentColor = colors.radioButtonColor(),
                    checkedContentColor = colors.checkedRadioButtonColor(),
                ),
                onCheckedChange = { onClick?.invoke() },
            )

            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(Size.Padding.Small),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(Size.Padding.Tiny),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(Size.Padding.Small),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = productTitle,
                            color = colors.productTitleColor(),
                            style = MaterialTheme.typography.titleMedium,
                        )

                        promoTagText?.let {
                            Box(
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(sizes.promoTagRoundedCornerSize()))
                                    .conditional(
                                        condition = colors.promoTagContainerBrush() != null,
                                        ifTrue = { background(colors.promoTagContainerBrush()!!) },
                                        ifFalse = { background(colors.promoTagContainerColor()) },
                                    )
                                    .padding(sizes.promoTagPadding()),
                                contentAlignment = Alignment.Center,
                            ) {
                                Text(
                                    text = it,
                                    color = colors.promoTagContentColor(),
                                    style = MaterialTheme.typography.titleSmall,
                                )
                            }
                        }
                    }

                    productHeadline?.let {
                        Text(
                            text = it,
                            color = colors.productHeadlineColor(),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                        )
                    }
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(Size.Padding.Tiny),
                    horizontalAlignment = Alignment.End,
                ) {
                    Text(
                        text = productAmount,
                        color = colors.productAmountColor(),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.End,
                    )

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
}
