package com.tweener.czan.blocks.block

/**
 * @author Vivien Mahe
 * @since 11/03/2025
 */

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.tweener.czan.blocks.ClickableIcon
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun EditableInfoBlock(
    title: String,
    editIcon: DrawableResource,
    modifier: Modifier = Modifier,
    shape: Shape = BlockDefaults.shape,
    colors: EditableInfoBlockColors = EditableInfoBlockDefaults.colors(),
    sizes: EditableInfoBlockSizes = EditableInfoBlockDefaults.sizes(),
    leadingIcon: DrawableResource? = null,
    leadingIconTint: Color = MaterialTheme.colorScheme.onBackground,
    headline: String? = null,
    extraContent: @Composable (() -> Unit)? = null,
    onEditClick: () -> Unit,
    deleteIcon: DrawableResource? = null,
    onDeleteClick: (() -> Unit)? = null,
) {
    Block(
        modifier = modifier,
        shape = shape,
        colors = BlockDefaults.colors(
            containerColor = colors.containerColor(),
            containerBrush = colors.containerBrush(),
            contentColor = colors.contentColor(),
            shadowColor = colors.shadowColor(),
        ),
        sizes = BlockDefaults.sizes(
            elevation = sizes.elevation(),
            contentPadding = sizes.contentPadding(),
            headerPadding = sizes.headerPadding(),
            footerPadding = sizes.footerPadding(),
        ),
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(Size.Padding.Small),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            leadingIcon?.let {
                ClickableIcon(
                    icon = it,
                    iconTint = leadingIconTint,
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(Size.Padding.Tiny),
            ) {
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Medium,
                    lines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                headline?.let {
                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Normal,
                        lines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                extraContent?.invoke()
            }

            ClickableIcon(
                icon = editIcon,
                iconTint = MaterialTheme.colorScheme.onBackground,
                onClick = onEditClick,
            )

            deleteIcon?.let {
                ClickableIcon(
                    icon = it,
                    iconTint = MaterialTheme.colorScheme.error,
                    onClick = onDeleteClick,
                )
            }
        }
    }
}

object EditableInfoBlockDefaults {

    @Composable
    fun colors(
        containerColor: Color = BlockDefaults.containerColorDefault,
        containerBrush: Brush? = null,
        contentColor: Color = BlockDefaults.contentColorDefault,
        borderStrokeColor: Color = BlockDefaults.borderStrokeColorDefault,
        shadowColor: Color = BlockDefaults.shadowColorDefault,
        activeTabContainerColor: Color = MaterialTheme.colorScheme.primaryContainer,
        activeTabContentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
        activeTabBorderColor: Color = MaterialTheme.colorScheme.outline,
        inactiveTabContainerColor: Color = MaterialTheme.colorScheme.surface,
        inactiveTabContentColor: Color = MaterialTheme.colorScheme.onSurface,
        inactiveTabBorderColor: Color = activeTabBorderColor,
    ): EditableInfoBlockColors = EditableInfoBlockColors(
        containerColor = containerColor,
        containerBrush = containerBrush,
        contentColor = contentColor,
        borderStrokeColor = borderStrokeColor,
        shadowColor = shadowColor,
        activeTabContainerColor = activeTabContainerColor,
        activeTabContentColor = activeTabContentColor,
        activeTabBorderColor = activeTabBorderColor,
        inactiveTabContainerColor = inactiveTabContainerColor,
        inactiveTabContentColor = inactiveTabContentColor,
        inactiveTabBorderColor = inactiveTabBorderColor,
    )

    fun sizes(
        contentPadding: PaddingValues = BlockDefaults.contentPaddingDefault,
        headerPadding: PaddingValues = BlockDefaults.headerPaddingDefault,
        footerPadding: PaddingValues = BlockDefaults.footerPaddingDefault,
        elevation: Dp = BlockDefaults.elevationDefault,
        borderStrokeWidth: Dp = BlockDefaults.borderStrokeWidthDefault,
    ): EditableInfoBlockSizes = EditableInfoBlockSizes(
        contentPadding = contentPadding,
        headerPadding = headerPadding,
        footerPadding = footerPadding,
        elevation = elevation,
        borderStrokeWidth = borderStrokeWidth,
    )
}

@Immutable
class EditableInfoBlockColors internal constructor(
    containerColor: Color,
    containerBrush: Brush?,
    contentColor: Color,
    borderStrokeColor: Color,
    shadowColor: Color,
    private val activeTabContainerColor: Color,
    private val activeTabContentColor: Color,
    private val activeTabBorderColor: Color,
    private val inactiveTabContainerColor: Color,
    private val inactiveTabContentColor: Color,
    private val inactiveTabBorderColor: Color,
) : BlockColors(containerColor, containerBrush, contentColor, borderStrokeColor, shadowColor) {

    @Composable
    internal fun activeTabContainerColor(): Color = activeTabContainerColor

    @Composable
    internal fun activeTabContentColor(): Color = activeTabContentColor

    @Composable
    internal fun activeTabBorderColor(): Color = activeTabBorderColor

    @Composable
    internal fun inactiveTabContainerColor(): Color = inactiveTabContainerColor

    @Composable
    internal fun inactiveTabContentColor(): Color = inactiveTabContentColor

    @Composable
    internal fun inactiveTabBorderColor(): Color = inactiveTabBorderColor
}

@Immutable
open class EditableInfoBlockSizes internal constructor(
    contentPadding: PaddingValues,
    headerPadding: PaddingValues = contentPadding,
    footerPadding: PaddingValues = contentPadding,
    elevation: Dp,
    borderStrokeWidth: Dp,
) : BlockSizes(contentPadding, headerPadding, footerPadding, elevation, borderStrokeWidth)

