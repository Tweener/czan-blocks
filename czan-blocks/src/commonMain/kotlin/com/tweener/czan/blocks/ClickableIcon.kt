package com.tweener.czan.blocks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tweener.czan._internal.kotlinextensions.clickableRipple
import com.tweener.czan.designsystem.atom.icon.Icon
import com.tweener.czan.theme.Size
import org.jetbrains.compose.resources.DrawableResource

/**
 * @author Vivien Mahe
 * @since 11/03/2025
 */

@Composable
fun ClickableIcon(
    icon: DrawableResource,
    iconTint: Color,
    modifier: Modifier = Modifier,
    iconSize: Dp = 16.dp,
    containerColor: Color = iconTint.copy(alpha = .1f),
    contentPadding: PaddingValues = PaddingValues(Size.Padding.Default),
    onClick: (() -> Unit)? = null,
) {
    ClickableIcon(
        modifier = modifier,
        icon = {
            Icon(
                modifier = Modifier.size(iconSize),
                resource = icon,
                tint = iconTint,
            )
        },
        iconTint = iconTint,
        containerColor = containerColor,
        contentPadding = contentPadding,
        onClick = onClick,
    )
}

@Composable
fun ClickableIcon(
    icon: Painter,
    iconTint: Color,
    modifier: Modifier = Modifier,
    iconSize: Dp = 16.dp,
    containerColor: Color = iconTint.copy(alpha = .1f),
    contentPadding: PaddingValues = PaddingValues(Size.Padding.Default),
    onClick: (() -> Unit)? = null,
) {
    ClickableIcon(
        modifier = modifier,
        icon = {
            Icon(
                modifier = Modifier.size(iconSize),
                painter = icon,
                tint = iconTint,
            )
        },
        iconTint = iconTint,
        containerColor = containerColor,
        contentPadding = contentPadding,
        onClick = onClick,
    )
}

@Composable
fun ClickableIcon(
    icon: ImageVector,
    iconTint: Color,
    modifier: Modifier = Modifier,
    iconSize: Dp = 16.dp,
    containerColor: Color = iconTint.copy(alpha = .1f),
    contentPadding: PaddingValues = PaddingValues(Size.Padding.Default),
    onClick: (() -> Unit)? = null,
) {
    ClickableIcon(
        modifier = modifier,
        icon = {
            Icon(
                modifier = Modifier.size(iconSize),
                imageVector = icon,
                tint = iconTint,
            )
        },
        iconTint = iconTint,
        containerColor = containerColor,
        contentPadding = contentPadding,
        onClick = onClick,
    )
}

@Composable
private fun ClickableIcon(
    icon: @Composable () -> Unit,
    iconTint: Color,
    modifier: Modifier = Modifier,
    containerColor: Color = iconTint.copy(alpha = .1f),
    contentPadding: PaddingValues = PaddingValues(Size.Padding.Default),
    onClick: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .clip(shape = CircleShape)
            .background(color = containerColor)
            .clickableRipple(enabled = onClick != null) { onClick?.invoke() }
            .padding(contentPadding),
        contentAlignment = Alignment.Center,
    ) {
        icon()
    }
}
