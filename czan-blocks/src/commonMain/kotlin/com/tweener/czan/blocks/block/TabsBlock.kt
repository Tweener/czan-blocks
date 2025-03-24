package com.tweener.czan.blocks.block

/**
 * @author Vivien Mahe
 * @since 10/03/2025
 */

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.tweener.czan.designsystem.atom.button.SegmentedButtonDefaults
import com.tweener.czan.designsystem.atom.button.SingleChoiceSegmentedButton
import com.tweener.czan.theme.Size

@Composable
fun TabsBlock(
    tabs: LinkedHashMap<String, @Composable () -> Unit>,
    modifier: Modifier = Modifier,
    shape: Shape = BlockDefaults.shape,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
    colors: TabsBlockColors = TabsBlockDefaults.colors(),
    sizes: TabsBlockSizes = TabsBlockDefaults.sizes(),
) {
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }

    Block(
        modifier = modifier,
        shape = shape,
        colors = BlockDefaults.colors(
            containerColor = colors.containerColor(),
            contentColor = colors.contentColor(),
            shadowColor = colors.shadowColor(),
        ),
        sizes = BlockDefaults.sizes(
            elevation = sizes.elevation(),
        ),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(Size.Padding.Default),
        ) {
            SingleChoiceSegmentedButton(
                modifier = Modifier.fillMaxWidth(),
                options = tabs.map { it.key },
                onOptionSelected = { selectedTab = it },
                textStyle = textStyle,
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = colors.activeTabContainerColor(),
                    activeContentColor = colors.activeTabContentColor(),
                    activeBorderColor = colors.activeTabBorderColor(),
                    inactiveContainerColor = colors.inactiveTabContainerColor(),
                    inactiveContentColor = colors.inactiveTabContentColor(),
                    inactiveBorderColor = colors.inactiveTabBorderColor(),
                )
            )

            tabs.map { it.value }.forEachIndexed { index, tabContent ->
                if (index == selectedTab) tabContent()
            }
        }
    }
}

object TabsBlockDefaults {

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
    ): TabsBlockColors = TabsBlockColors(
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
    ): TabsBlockSizes = TabsBlockSizes(
        contentPadding = contentPadding,
        headerPadding = headerPadding,
        footerPadding = footerPadding,
        elevation = elevation,
        borderStrokeWidth = borderStrokeWidth,
    )
}

@Immutable
class TabsBlockColors internal constructor(
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
open class TabsBlockSizes internal constructor(
    contentPadding: PaddingValues,
    headerPadding: PaddingValues = contentPadding,
    footerPadding: PaddingValues = contentPadding,
    elevation: Dp,
    borderStrokeWidth: Dp,
) : BlockSizes(contentPadding, headerPadding, footerPadding, elevation, borderStrokeWidth)

