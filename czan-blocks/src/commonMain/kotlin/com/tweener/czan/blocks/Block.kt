package com.tweener.czan.blocks

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    title: String,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,
    headline: String? = null,
    extraTitle: @Composable (() -> Unit)? = null,
    footer: @Composable (() -> Unit)? = null,
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
            elevation = elevation,
            contentPadding = PaddingValues(Size.Padding.Default),
        ),
        showDividers = false,
        header = {
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
        },
        footer = footer?.let { { it() } }
    ) {
        content()
    }
}
