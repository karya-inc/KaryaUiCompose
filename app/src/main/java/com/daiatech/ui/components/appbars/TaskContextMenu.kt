package com.daiatech.ui.components.appbars

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daiatech.ui.R
import com.daiatech.ui.theme.UITheme

@Composable
fun TaskContextMenu(
    enabled: Boolean = true,
    onClick: (String) -> Unit = {}
) {
    val expanded = remember { mutableStateOf(false) }
    Box(modifier = Modifier.wrapContentSize(Alignment.TopEnd)) {
        IconButton(onClick = { expanded.value = true }) {
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(id = R.drawable.help_avatar),
                contentDescription = stringResource(id = R.string.help)
            )
        }
        // todo icons are subject to change
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            if (enabled) {
                DropdownMenuItem(
                    text = { Text("Help") },
                    onClick = {
                        onClick("help")
                        expanded.value = false
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_whatsapp),
                            contentDescription = null
                        )
                    }
                )
                HorizontalDivider()
            }
            DropdownMenuItem(
                text = { Text("See tutorial") },
                onClick = {
                    onClick("tutorial")
                    expanded.value = false
                },
                leadingIcon = { Icon(Icons.Filled.PlayArrow, contentDescription = null) }
            )
        }
    }
}

@Preview
@Composable
fun TaskContextMenuPrev() {
    UITheme {
        Column {
            TaskContextMenu(enabled = true)
        }
    }
}
