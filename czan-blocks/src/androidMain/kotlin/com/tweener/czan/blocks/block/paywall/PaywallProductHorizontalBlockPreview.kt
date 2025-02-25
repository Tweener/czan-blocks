package com.tweener.czan.blocks.block.paywall

/**
 * @author Vivien Mahe
 * @since 10/02/2025
 */

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.tweener.czan.preview.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 16/01/2025
 */

@UiModePreviews
@Composable
private fun PaywallProductHorizontalBlockSelectedPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            PaywallProductHorizontalBlock(
                selected = true,
                productTitle = "Monthly",
                productHeadline = "7-day free trial",
                productAmount = "1.99 €",
                productAmountHeadline = "per month",
                colors = PaywallProductBlockDefaults.colors(),
                sizes = PaywallProductBlockDefaults.sizes(selectedBorderStrokeWidth = 2.dp),
            )
        }
    }
}

@UiModePreviews
@Composable
private fun PaywallProductHorizontalBlockNotSelectedPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            PaywallProductHorizontalBlock(
                selected = false,
                productTitle = "Monthly",
                productAmount = "1.99 €",
                productAmountHeadline = "per month",
                colors = PaywallProductBlockDefaults.colors(),
                sizes = PaywallProductBlockDefaults.sizes(borderStrokeWidth = 1.dp),
            )
        }
    }
}

@UiModePreviews
@Composable
private fun PaywallProductHorizontalBlockWithPromoChipPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            PaywallProductHorizontalBlock(
                selected = true,
                productTitle = "Monthly",
                productHeadline = "7-day free trial",
                productAmount = "1.99 €",
                productAmountHeadline = "per month",
                promoTagText = "50% OFF!",
                colors = PaywallProductBlockDefaults.colors(
                    promoTagContainerColor = MaterialTheme.colorScheme.errorContainer,
                    promoTagContentColor = MaterialTheme.colorScheme.onErrorContainer,
                ),
            )
        }
    }
}

@UiModePreviews
@Composable
private fun PaywallProductHorizontalBlockWithPromoChipBrushPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            PaywallProductHorizontalBlock(
                selected = true,
                productTitle = "Monthly",
                productHeadline = "A very long headline text to see how it behaves",
                productAmount = "1.99 €",
                promoTagText = "50% OFF!",
                colors = PaywallProductBlockDefaults.colors(
                    promoTagContainerBrush = Brush.linearGradient(
                        0.0f to MaterialTheme.colorScheme.errorContainer,
                        1.0f to MaterialTheme.colorScheme.primaryContainer,
                        start = Offset.Zero,
                        end = Offset.Infinite
                    ),
                    promoTagContentColor = MaterialTheme.colorScheme.onErrorContainer,
                ),
            )
        }
    }
}
