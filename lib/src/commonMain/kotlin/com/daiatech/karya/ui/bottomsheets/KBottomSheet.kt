package com.daiatech.karya.ui.bottomsheets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.daiatech.karya.ui.buttons.ButtonVariants
import com.daiatech.karya.ui.buttons.KButton
import com.daiatech.karya.ui.theme.KaryaTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KBottomSheet(
    modifier: Modifier = Modifier,
    message: String? = null,
    action: (@Composable (Modifier) -> Unit)? = null,
    title: String? = null,
    imgPainter: Painter? = null,
    onDismissRequest: () -> Unit = {}
) {
    val theme = KaryaTheme.colorScheme
    val dimensions = KaryaTheme.dimens
    ModalBottomSheet(
        modifier = Modifier.systemBarsPadding(),
        onDismissRequest = { onDismissRequest() },
        containerColor = theme.white,
        dragHandle = null,
        shape = RoundedCornerShape(topStart = dimensions.m, topEnd = dimensions.m),
        sheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true,
            confirmValueChange = { true }
        )
    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(topEnd = dimensions.s, topStart = dimensions.s))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensions.m),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(dimensions.m)
                ) {
                    if (imgPainter != null) {
                        Icon(
                            painter = imgPainter,
                            contentDescription = "icon",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(200.dp).clip(CircleShape)
                        )
                    }
                    if (title != null) {
                        Text(
                            text = title,
                            color = theme.neutral20,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight(500))
                        )
                    }
                    if (message != null) {
                        Text(
                            text = message,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleMedium,
                            color = theme.neutral50
                        )
                    }
                    if (action != null) {
                        HorizontalDivider(
                            Modifier.padding(start = dimensions.s, end = dimensions.s, top = dimensions.s).fillMaxWidth().border(
                                1.dp,
                                theme.neutral99
                            )
                        )
                        action(modifier)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, name = "KBottomSheet - With Actions")
@Composable
private fun KBottomSheetPreviewInternal() {
    KaryaTheme {
        KBottomSheet(
            title = "Action Required",
            message = "Please confirm your action before continuing. This cannot be undone.",
            imgPainter = rememberVectorPainter(Icons.Default.Info),
            action = { modifier ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = KaryaTheme.dimens.m),
                    horizontalArrangement = Arrangement.spacedBy(KaryaTheme.dimens.s)
                ) {
                    KButton(
                        onClick = {},
                        modifier = modifier.weight(1f),
                        content = "Confirm",
                        leftIcon = rememberVectorPainter(Icons.Default.Check),
                        variant = ButtonVariants.primaryRegular,
                        enabled = true
                    )
                    KButton(
                        onClick = {},
                        modifier = modifier.weight(1f),
                        content = "Cancel",
                        leftIcon = rememberVectorPainter(Icons.Default.Close),
                        variant = ButtonVariants.secondaryRegular,
                        enabled = true
                    )
                }
            },
            onDismissRequest = {}
        )
    }
}

@Composable
@Preview
fun KBottomSheetPreview() {
    KaryaTheme {
        var showBottomSheet by remember { mutableStateOf(false) }
        KButton(
            onClick = { showBottomSheet = true },
            variant = ButtonVariants.primaryRegular,
            content = "Show BottomSheet"
        )
        if (showBottomSheet) {
            KBottomSheet(
                title = "Action Required",
                message = "Please confirm your action before continuing. This cannot be undone.",
                imgPainter = rememberVectorPainter(Icons.Default.Info),
                action = { modifier ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = KaryaTheme.dimens.m),
                        horizontalArrangement = Arrangement.spacedBy(KaryaTheme.dimens.s)
                    ) {
                        KButton(
                            onClick = {},
                            modifier = modifier.weight(1f),
                            content = "Confirm",
                            leftIcon = rememberVectorPainter(Icons.Default.Check),
                            variant = ButtonVariants.primaryRegular,
                            enabled = true
                        )
                        KButton(
                            onClick = { showBottomSheet = false },
                            modifier = modifier.weight(1f),
                            content = "Cancel",
                            leftIcon = rememberVectorPainter(Icons.Default.Close),
                            variant = ButtonVariants.secondaryRegular,
                            enabled = true
                        )
                    }
                },
                onDismissRequest = { showBottomSheet = false }
            )
        }
    }
}