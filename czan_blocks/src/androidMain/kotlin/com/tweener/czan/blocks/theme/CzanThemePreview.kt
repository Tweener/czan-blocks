package com.tweener.czan.blocks.theme

import androidx.compose.runtime.Composable
import com.tweener.czan.theme.CzanTheme

/**
 * @author Vivien Mahe
 * @since 18/12/2023
 */

@Composable
fun CzanThemePreview(content: @Composable () -> Unit) {
    CzanTheme(
        lightColorScheme = CzanPreviewLightColorScheme,
        darkColorScheme = CzanPreviewDarkColorScheme,
        typography = CzanPreviewTypography,
        shapes = CzanPreviewShapes,
        content = content
    )
}
