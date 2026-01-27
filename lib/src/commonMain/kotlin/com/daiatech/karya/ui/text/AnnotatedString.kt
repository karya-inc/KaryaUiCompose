package com.daiatech.karya.ui.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import be.digitalia.compose.htmlconverter.htmlToAnnotatedString
import com.daiatech.karya.ui.spacers.VerticalSpacer
import com.daiatech.karya.ui.theme.KaryaTheme
import androidx.compose.ui.tooling.preview.Preview
import kotlin.collections.get
import kotlin.text.replace

@Preview
@Composable
fun AnnotatedStringPreview() {
    KaryaTheme {
        Column {
            val htmlText = rememberAnnotatedString(
                "<b>This is <a href='https://google.com'>Google</a> bold <kk> text</b>"
            )
            Text("Raw HTML", style = KaryaTheme.typography.titleMedium)
            Text("<b>This is <a href='https://google.com'>Google</a> bold <kk> text</b>")
            VerticalSpacer()
            Text("Rendered HTML", style = KaryaTheme.typography.titleMedium)
            Text(text = htmlText)
        }
    }
}


@Composable
fun rememberAnnotatedString(html: String, escapeInvalid: Boolean = true): AnnotatedString {
    return remember(html, escapeInvalid) {
        val escapedHtml = htmlTagMatchRegex.replace(html) { matchResult ->
            val tag = matchResult.groups[2]?.value
            if (tag != null && tag.lowercase() in allowedHtmlTags) {
                matchResult.value
            } else {
                escapeHtml(matchResult.value)
            }
        }
        htmlToAnnotatedString(escapedHtml)
    }
}

fun escapeHtml(html: String): String {
    val escapedHtml = StringBuilder()
    html.forEach { c ->
        when (c) {
            '<' -> escapedHtml.append("&lt;");
            '>' -> escapedHtml.append("&gt;");
            '&' -> escapedHtml.append("&amp;");
            else -> escapedHtml.append(c)
        }
    }
    return escapedHtml.toString()
}