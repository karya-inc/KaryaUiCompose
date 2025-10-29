package com.daiatech.karya.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.daiatech.karya.ui.buttons.IconButtonPreview
import com.daiatech.karya.ui.buttons.KButtonPreview
import com.daiatech.karya.ui.components.NavigateUpTopBar
import org.jetbrains.compose.ui.tooling.preview.Preview


enum class Component(val value: String, val route: String) {
    BUTTONS("KButtons", "buttons"),
    ICON_BUTTONS("KIconButtons", "icon_buttons"),
}

@Composable
fun ComponentScreen(
    component: Component,
    navigateUp: () -> Unit
) {
    Scaffold(
        topBar = {
            NavigateUpTopBar(
                "${component.value} Catalogue",
                navigateUp = navigateUp
            )
        }
    ) { paddingValues ->
        Box(Modifier.padding(paddingValues)) {
            when (component) {
                Component.BUTTONS -> KButtonPreview()
                Component.ICON_BUTTONS -> IconButtonPreview()
            }
        }
    }
}

@Preview
@Composable
fun ButtonsPreview() {
    ComponentScreen(Component.BUTTONS) {}
}

@Preview
@Composable
fun IconButtonsPreview() {
    ComponentScreen(Component.ICON_BUTTONS) {}
}