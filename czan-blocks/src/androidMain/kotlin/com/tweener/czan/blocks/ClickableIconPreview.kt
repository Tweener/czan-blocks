package com.tweener.czan.blocks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tweener.czan.blocks.theme.CzanThemePreview
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.theme.Size
import io.github.tweener.czan_blocks.generated.resources.Res
import io.github.tweener.czan_blocks.generated.resources.edit

/**
 * @author Vivien Mahe
 * @since 24/03/2025
 */

@UiModePreviews
@Composable
private fun EditableInfoBlockPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            ClickableIcon(
                icon = Res.drawable.edit,
                iconTint = MaterialTheme.colorScheme.onBackground,
                containerColor = Color.Transparent,
                contentPadding = PaddingValues(Size.Padding.Small),
            )
        }
    }
}
