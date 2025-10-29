package com.daiatech.karya.ui

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform