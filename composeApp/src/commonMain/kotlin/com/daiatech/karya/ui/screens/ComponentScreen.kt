package com.daiatech.karya.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.daiatech.karya.ui.Components
import com.daiatech.karya.ui.bottomsheets.KBottomSheetPreview
import com.daiatech.karya.ui.buttons.KButtonPreview
import com.daiatech.karya.ui.buttons.KIconButtonPreview
import com.daiatech.karya.ui.dialogs.KDialogPreview
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
        Box(Modifier.padding(paddingValues).fillMaxSize(), contentAlignment = Alignment.Center) {
            when (component) {
                Components.BUTTON -> KButtonPreview()
                Components.ICON_BUTTON -> KIconButtonPreview()
                Components.DIALOG -> KDialogPreview()
                Components.BOTTOM_SHEET -> KBottomSheetPreview()
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

@Preview
@Composable
fun DialogPreview() {
    ComponentScreen(Components.DIALOG, {}) {}
}

@Preview
@Composable
fun BottomSheetPreview() {
    ComponentScreen(Components.BOTTOM_SHEET, {}) {}
}