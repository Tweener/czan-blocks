package com.tweener.czan.blocks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tweener.chartopia.type.donut.model.Segment
import com.tweener.czan.blocks.theme.CzanThemePreview
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.preview.UiModePreviews
import com.tweener.czan.theme.Size
import com.tweener.kmpkit.kotlinextensions.degrees

/**
 * @author Vivien Mahe
 * @since 05/02/2025
 */

@UiModePreviews
@Composable
private fun InfoPieChartBlockPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            InfoPieChartBlock(
                modifier = Modifier.fillMaxWidth(),
                title = "2 065",
                headline = "Calories burnt",
                segments = listOf(
                    Segment(id = "#1", angle = 90f.degrees, baseColor = MaterialTheme.colorScheme.onBackground, selected = true),
                    Segment(id = "#2", angle = 270f.degrees, baseColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f), selected = false),
                )
            ) {
                Icon(imageVector = Icons.Default.LocalFireDepartment, tint = Color(0xFFFF8000), contentDescription = "Fireplace")
            }
        }
    }
}
