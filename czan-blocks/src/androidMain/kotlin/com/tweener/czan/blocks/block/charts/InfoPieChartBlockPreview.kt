package com.tweener.czan.blocks.block.charts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tweener.chartopia.type.donut.model.Segment
import com.tweener.czan.blocks.theme.CzanThemePreview
import com.tweener.czan.designsystem.atom.button.Button
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
                title = "Daily goal",
                headline = "Track your daily progress",
                progressInfo = "2 065",
                totalInfo = "of 3 000",
                progressHeadline = "Calories burnt",
                segments = listOf(
                    Segment(id = "#1", angle = 90f.degrees, baseColor = MaterialTheme.colorScheme.onBackground, selected = true),
                    Segment(id = "#2", angle = 270f.degrees, baseColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f), selected = false),
                ),
                extraTitle = {
                    Button(text = "Details", outlined = true)
                }
            ) {
                Icon(imageVector = Icons.Default.LocalFireDepartment, tint = Color(0xFFFF8000), contentDescription = "Fireplace")
            }
        }
    }
}

@UiModePreviews
@Composable
private fun InfoPieChartBlockElevatedPreview() {
    CzanThemePreview {
        Box(modifier = Modifier.padding(Size.Padding.Default)) {
            InfoPieChartBlock(
                modifier = Modifier.fillMaxWidth(),
                title = "Daily goal",
                headline = "Track your daily progress",
                progressInfo = "2 065",
                totalInfo = "of 3 000",
                progressHeadline = "Calories burnt",
                segments = listOf(
                    Segment(id = "#1", angle = 90f.degrees, baseColor = MaterialTheme.colorScheme.onBackground, selected = true),
                    Segment(id = "#2", angle = 270f.degrees, baseColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f), selected = false),
                ),
                extraTitle = {
                    Button(text = "Details", outlined = true)
                },
                sizes = InfoPieChartBlockDefaults.sizes(
                    elevation = 8.dp,
                ),
            ) {
                Icon(imageVector = Icons.Default.LocalFireDepartment, tint = Color(0xFFFF8000), contentDescription = "Fireplace")
            }
        }
    }
}
