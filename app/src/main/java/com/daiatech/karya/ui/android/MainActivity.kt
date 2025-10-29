package com.daiatech.karya.ui.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.daiatech.karya.ui.buttons.KButtonPreview
import com.daiatech.karya.ui.theme.KaryaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            KaryaTheme {
//                KButtonPreview()
//            }
        }
    }
}
