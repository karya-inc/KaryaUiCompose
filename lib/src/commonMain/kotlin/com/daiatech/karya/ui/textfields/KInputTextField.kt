package com.daiatech.karya.ui.textfields

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessAlarm
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.daiatech.karya.ui.spacers.HorizontalSpacer
import com.daiatech.karya.ui.spacers.VerticalSpacer
import com.daiatech.karya.ui.theme.KaryaTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun KInputTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    error: String? = null,
    enabled: Boolean = true,
    supportingText: String? = null,
    singleLine: Boolean = false,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource? = null,
    shape: Shape = RoundedCornerShape(KaryaTheme.dimens.s)
) {
    OutlinedTextField(
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        value = value,
        onValueChange = onValueChange,
        isError = error != null,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        label = label?.let { { BasicText(label) } },
        leadingIcon = leadingIcon?.let { { it() } },
        trailingIcon = trailingIcon?.let { { it() } },
        supportingText = {
            Column {
                error?.let {
                    Text(
                        text = it,
                        style = KaryaTheme.typography.bodySmall,
                        color = KaryaTheme.colorScheme.error50,
                    )
                }
                supportingText?.let {
                    Text(
                        text = it,
                        style = KaryaTheme.typography.bodySmall,
                        color = KaryaTheme.colorScheme.neutral50,
                    )
                }
            }
        },
        shape = shape,
        colors = OutlinedTextFieldDefaults.colors(
            // Border
            unfocusedBorderColor = KaryaTheme.colorScheme.neutral20,
            focusedBorderColor = KaryaTheme.colorScheme.primary50,
            errorBorderColor = KaryaTheme.colorScheme.error50,
            disabledBorderColor = KaryaTheme.colorScheme.neutral90,
            // text
            unfocusedTextColor = KaryaTheme.colorScheme.neutral50,
            focusedTextColor = KaryaTheme.colorScheme.neutral20,
            errorTextColor = KaryaTheme.colorScheme.neutral20,
            disabledTextColor = KaryaTheme.colorScheme.neutral50,
            // Cursor
            cursorColor = KaryaTheme.colorScheme.primary50,
            errorCursorColor = KaryaTheme.colorScheme.error50
        )
    )
}


@Preview
@Composable
fun KInputTextFieldPreview() {
    KaryaTheme {
        var text by remember { mutableStateOf("") }
        var error by remember { mutableStateOf<String?>(null) }
        var enabled by remember { mutableStateOf(true) }
        var leadingIcon by remember { mutableStateOf(false) }
        var trailingIcon by remember { mutableStateOf(false) }
        Column(Modifier.padding(16.dp)) {
            KInputTextField(
                value = text,
                onValueChange = { text = it },
                supportingText = "Supporting text",
                error = error,
                label = "Label",
                enabled = enabled,
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = if (leadingIcon) {
                    { Icon(imageVector = Icons.Default.AccessAlarm, contentDescription = null) }
                } else null,
                trailingIcon = if (trailingIcon) {
                    {
                        IconButton(onClick = { text = "" }) {
                            Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                        }
                    }
                } else null
            )
            VerticalSpacer()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Error")
                HorizontalSpacer()
                Switch(
                    checked = error != null,
                    onCheckedChange = {
                        error = if (it) "Error" else null
                    }
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Enabled")
                HorizontalSpacer()
                Switch(
                    checked = enabled,
                    onCheckedChange = { enabled = it }
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("LeadingIcon")
                HorizontalSpacer()
                Switch(
                    checked = leadingIcon,
                    onCheckedChange = { leadingIcon = it }
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("TrailingIcon")
                HorizontalSpacer()
                Switch(
                    checked = trailingIcon,
                    onCheckedChange = { trailingIcon = it }
                )
            }
        }
    }
}