package com.daiatech.karya.ui.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.daiatech.karya.ui.buttons.ButtonVariants
import com.daiatech.karya.ui.buttons.KButton
import com.daiatech.karya.ui.theme.KaryaTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun KDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    icon: @Composable () -> Unit = {},
    title: @Composable RowScope.() -> Unit = {},
    content: @Composable () -> Unit = {},
    properties: DialogProperties = DialogProperties(usePlatformDefaultWidth = false),
    actions: (@Composable (Modifier, Boolean) -> Unit)? = null,
    actionsAlignment: DialogActionAlignment = DialogActionAlignment.HORIZONTAL
) {
    val colorScheme = KaryaTheme.colorScheme
    val shape = KaryaTheme.shapes
    val dimensions = KaryaTheme.dimens
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = properties
    ) {
        Column(
            modifier
                .fillMaxWidth(0.8f)
                .clip(shape.large)
                .background(colorScheme.warning100)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(dimensions.s),
                modifier = Modifier.padding(
                    top = dimensions.m,
                    start = dimensions.m,
                    end = dimensions.m
                )
            ) {
                icon()
                CompositionLocalProvider(LocalContentColor provides colorScheme.neutral20) {
                    title()
                }
            }
            CompositionLocalProvider(LocalContentColor provides colorScheme.neutral50) {
                content()
            }
            if (actions != null) {
                HorizontalDivider(
                    Modifier.padding(start = dimensions.m, end = dimensions.m, top = dimensions.m)
                        .fillMaxWidth().border(
                        1.dp,
                        colorScheme.neutral99
                    )
                )
                when (actionsAlignment) {
                    DialogActionAlignment.HORIZONTAL -> Row(
                        modifier = Modifier.padding(dimensions.m).fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(dimensions.xs)
                    ) {
                        actions(Modifier.weight(1f), true)
                    }
                    DialogActionAlignment.VERTICAL -> Column(
                        modifier = Modifier.padding(dimensions.m).fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(dimensions.xs)
                    ) {
                        actions(Modifier.fillMaxWidth(), false)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun KDialogPreview() {
    KaryaTheme {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
        ) {
            var showVertical by remember { mutableStateOf(false) }
            var showHorizontal by remember { mutableStateOf(false) }
            if (showVertical) {
                KDialog(
                    onDismissRequest = { showVertical = false },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "Info Icon"
                        )
                    },
                    title = {
                        Text("Information", style = KaryaTheme.typography.titleMedium)
                    },
                    content = {
                        Text(
                            "This dialog displays vertical actions.",
                            modifier = Modifier.padding(KaryaTheme.dimens.m)
                        )
                    },
                    actions = { modifier, isHorizontal ->
                        if (!isHorizontal) {
                            KButton(
                                onClick = {},
                                modifier = modifier,
                                content = "OK",
                                leftIcon = rememberVectorPainter(Icons.Default.Check),
                                variant = ButtonVariants.primaryRegular,
                                enabled = true
                            )
                            KButton(
                                onClick = { showVertical = false },
                                modifier = modifier,
                                content = "Cancel",
                                leftIcon = rememberVectorPainter(Icons.Default.Close),
                                variant = ButtonVariants.secondaryRegular,
                                enabled = true
                            )
                        }
                    },
                    actionsAlignment = DialogActionAlignment.VERTICAL
                )
            }

            if (showHorizontal) {
                KDialog(
                    onDismissRequest = { showHorizontal = false },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "Info Icon"
                        )
                    },
                    title = {
                        Text("Information", style = KaryaTheme.typography.titleMedium)
                    },
                    content = {
                        Text(
                            "This dialog displays horizontal actions.",
                            modifier = Modifier.padding(KaryaTheme.dimens.m)
                        )
                    },
                    actions = { modifier, isHorizontal ->
                        if (isHorizontal) {
                            KButton(
                                onClick = {},
                                modifier = modifier,
                                content = "OK",
                                leftIcon = rememberVectorPainter(Icons.Default.Check),
                                variant = ButtonVariants.primaryRegular,
                                enabled = true
                            )
                            KButton(
                                onClick = { showHorizontal = false },
                                modifier = modifier,
                                content = "Cancel",
                                leftIcon = rememberVectorPainter(Icons.Default.Close),
                                variant = ButtonVariants.secondaryRegular,
                                enabled = true
                            )
                        }
                    },
                    actionsAlignment = DialogActionAlignment.HORIZONTAL
                )
            }

            KButton(
                variant = ButtonVariants.primaryRegular,
                onClick = { showVertical = true },
                content = "Vertical Actions"
            )

            KButton(
                variant = ButtonVariants.primaryRegular,
                onClick = { showHorizontal = true },
                content = "Horizontal Actions"
            )
        }
    }
}

@Preview(showBackground = true, name = "Dialog with Icon and Actions - Horizontal")
@Composable
private fun KDialogPreviewHorizontalActions() {
    KaryaTheme {
        KDialog(
            onDismissRequest = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Info Icon"
                )
            },
            title = {
                Text("Information", style = KaryaTheme.typography.titleMedium)
            },
            content = {
                Text(
                    "This dialog displays horizontal actions.",
                    modifier = Modifier.padding(KaryaTheme.dimens.m)
                )
            },
            actions = { modifier, isHorizontal ->
                if (isHorizontal) {
                    KButton(
                        onClick = {},
                        modifier = modifier,
                        content = "OK",
                        leftIcon = rememberVectorPainter(Icons.Default.Check),
                        variant = ButtonVariants.primaryRegular,
                        enabled = true
                    )
                    KButton(
                        onClick = {},
                        modifier = modifier,
                        content = "Cancel",
                        leftIcon = rememberVectorPainter(Icons.Default.Close),
                        variant = ButtonVariants.secondaryRegular,
                        enabled = true
                    )
                }
            },
            actionsAlignment = DialogActionAlignment.HORIZONTAL
        )
    }
}
