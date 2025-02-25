package com.tweener.czan.blocks.block

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tweener.czan.blocks.theme.CzanThemePreview
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 01/02/2025
 */

@UiModePreviews
@Composable
private fun BlockNoTitlePreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            Block(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = "This is a Block's content")
            }
        }
    }
}

@UiModePreviews
@Composable
private fun BlockPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            Block(
                modifier = Modifier.fillMaxWidth(),
                title = "This is a Block's title",
                headline = "And this is an optional Block's headline",
            ) {
                Text(text = "This is a Block's content")
            }
        }
    }
}

@UiModePreviews
@Composable
private fun BlockWithExtraTitlePreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            Block(
                modifier = Modifier.fillMaxWidth(),
                title = "This is a Block's title",
                headline = "And this is an optional Block's headline azezar aze",
                extraTitle = { Text(text = "+6.8%") },
            ) {
                Text(text = "This is a Block's content")
            }
        }
    }
}

@UiModePreviews
@Composable
private fun BlockWithFooterPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            Block(
                modifier = Modifier.fillMaxWidth(),
                title = "This is a Block's title",
                headline = "And this is an optional Block's headline",
                footer = {
                    Text(text = "This is an optional Block's footer")
                },
            ) {
                Text(text = "This is a Block's content")
            }
        }
    }
}

@UiModePreviews
@Composable
private fun BlockWithElevationPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            Block(
                modifier = Modifier.fillMaxWidth(),
                title = "This is a Block's title",
                headline = "And this is an optional Block's headline",
                sizes = BlockDefaults.sizes(
                    elevation = 8.dp,
                ),
            ) {
                Text(text = "This is a Block's content")
            }
        }
    }
}
