package com.tweener.czan.blocks

/**
 * @author Vivien Mahe
 * @since 01/02/2025
 */

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tweener.czan.blocks.preview.onBackgroundVariant
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.designsystem.organism.card.Card
import com.tweener.czan.designsystem.organism.card.CardDefaults
import com.tweener.czan.theme.Size

@Composable
fun Block(
    title: String,
    modifier: Modifier = Modifier,
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
            elevation = 0.dp,
            contentPadding = PaddingValues(Size.Padding.Small),
        ),
        showDividers = false,
        header = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(Size.Padding.Tiny),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(Size.Padding.ExtraSmall),
                    verticalAlignment = Alignment.Top,
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium,
                        lines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )

                    extraTitle?.invoke()
                }

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
        },
        footer = footer?.let { { it() } }
    ) {
        content()
    }
}
