package com.tweener.czan.blocks.block

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tweener.czan.blocks.theme.CzanThemePreview
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.theme.Size
import io.github.tweener.czan_blocks.generated.resources.Res
import io.github.tweener.czan_blocks.generated.resources.delete
import io.github.tweener.czan_blocks.generated.resources.edit

/**
 * @author Vivien Mahe
 * @since 11/03/2025
 */

@UiModePreviews
@Composable
private fun EditableInfoBlockPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            EditableInfoBlock(
                title = "$1800,00",
                editIcon = Res.drawable.edit,
                onEditClick = {},
            )
        }
    }
}

@UiModePreviews
@Composable
private fun EditableInfoBlockHeadlinePreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            EditableInfoBlock(
                title = "$1800,00",
                headline = "Salary",
                editIcon = Res.drawable.edit,
                onEditClick = {},
            )
        }
    }
}

@UiModePreviews
@Composable
private fun EditableInfoBlockLeadingIconPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            EditableInfoBlock(
                title = "$1800,00",
                headline = "Salary",
                leadingIcon = Res.drawable.edit,
                leadingIconTint = Color.Red,
                editIcon = Res.drawable.edit,
                onEditClick = {},
            )
        }
    }
}

@UiModePreviews
@Composable
private fun EditableInfoBlockDeleteIconPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            EditableInfoBlock(
                title = "$1800,00",
                headline = "Salary",
                leadingIcon = Res.drawable.edit,
                leadingIconTint = Color.Blue,
                editIcon = Res.drawable.edit,
                deleteIcon = Res.drawable.delete,
                onEditClick = {},
                onDeleteClick = {},
            )
        }
    }
}

@UiModePreviews
@Composable
private fun EditableInfoBlockExtraContentPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            EditableInfoBlock(
                title = "$1800,00",
                headline = "Salary",
                extraContent = {
                    Text(
                        text = "Extra content",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                },
                leadingIcon = Res.drawable.edit,
                leadingIconTint = Color.Blue,
                editIcon = Res.drawable.edit,
                deleteIcon = Res.drawable.delete,
                onEditClick = {},
                onDeleteClick = {},
            )
        }
    }
}
