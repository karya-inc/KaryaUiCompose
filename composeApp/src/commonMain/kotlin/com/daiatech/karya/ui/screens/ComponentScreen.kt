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
import com.daiatech.karya.ui.cards.OutlinedCardWithHandlePreview
import com.daiatech.karya.ui.chips.KChipPreview
import com.daiatech.karya.ui.dialogs.KDialogPreview
import com.daiatech.karya.ui.loaders.KLoadingAnimationPreview
import com.daiatech.karya.ui.text.AnnotatedStringPreview
import com.daiatech.karya.ui.text.ResizableTextPreview
import com.daiatech.karya.ui.textfields.KInputTextFieldPreview
import androidx.compose.ui.tooling.preview.Preview

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
                Components.LOADER -> KLoadingAnimationPreview()
                Components.CARD_WITH_HANDLE -> OutlinedCardWithHandlePreview()
                Components.RESIZABLE_TEXT -> ResizableTextPreview()
                Components.CHIP -> KChipPreview()
                Components.HTML_TEXT -> AnnotatedStringPreview()
                Components.TEXT_INPUT_FIELD -> KInputTextFieldPreview()
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

@Preview
@Composable
fun KLoadingAnimationPreview() {
    ComponentScreen(Components.LOADER, {}) {}
}

@Preview
@Composable
fun KOutlinedCardWithHandlePreview() {
    ComponentScreen(Components.CARD_WITH_HANDLE, {}) {}
}

@Preview
@Composable
fun ResizableTextPreview() {
    ComponentScreen(Components.RESIZABLE_TEXT, {}) {}
}


@Preview
@Composable
fun KChipPreview() {
    ComponentScreen(Components.CHIP, {}) {}
}

@Preview
@Composable
fun AnnotatedStringPreview() {
    ComponentScreen(Components.HTML_TEXT, {}) {}
}

@Preview
@Composable
fun KInputTextFieldPreview() {
    ComponentScreen(Components.TEXT_INPUT_FIELD, {}) {}
}