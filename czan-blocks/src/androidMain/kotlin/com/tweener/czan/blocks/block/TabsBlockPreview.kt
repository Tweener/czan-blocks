package com.tweener.czan.blocks.block

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tweener.czan.blocks.theme.CzanThemePreview
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 10/03/2025
 */

@UiModePreviews
@Composable
private fun TabsBlockPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            TabsBlock(
                modifier = Modifier.fillMaxWidth(),
                tabs = linkedMapOf(
                    "Tab 1" to { Text(text = "Content tab 1") },
                    "Tab 2" to { Text(text = "Content tab 2") },
                    "Tab 3" to { Text(text = "Content tab 3") },
                ),
                colors = TabsBlockDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    activeTabContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    activeTabContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    activeTabBorderColor = MaterialTheme.colorScheme.outline,
                    inactiveTabContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    inactiveTabContentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                ),
                sizes = TabsBlockDefaults.sizes(elevation = 8.dp),
            )
        }
    }
}
