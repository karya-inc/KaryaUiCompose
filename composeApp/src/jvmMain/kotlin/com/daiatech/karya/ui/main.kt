package com.daiatech.karya.ui

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Karya Ui",
    ) {
        App()
    }
}