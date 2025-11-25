package com.daiatech.karya.ui.text

val allowedHtmlTags by lazy {
    setOf(
        "a", "b", "i", "u", "strong", "em", "font", "br", "p", "span",
        "div", "ol", "ul", "li", "h1", "h2", "h3", "h4", "h5"
    )
}


val htmlTagMatchRegex by lazy { Regex("<(/?)(\\w+)([^>]*)>") }

