package com.daiatech.karya.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.daiatech.karya.ui.Components
import com.daiatech.karya.ui.buttons.KButtonPreview
import com.daiatech.karya.ui.buttons.KIconButtonPreview
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentScreen(
    component: Components,
    navigateToSettings: () -> Unit,
    navigateUp: () -> Unit
) {
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text("${component.value} Catalogue") },
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = navigateToSettings) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Settings"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(Modifier.padding(paddingValues)) {
            when (component) {
                Components.BUTTON -> KButtonPreview()
                Components.ICON_BUTTON -> KIconButtonPreview()
            }
        }
    }
}

@Preview
@Composable
fun ButtonsPreview() {
    ComponentScreen(Components.BUTTON, {}) {}
}

@Preview
@Composable
fun IconButtonsPreview() {
    ComponentScreen(Components.ICON_BUTTON, {}) {}
}