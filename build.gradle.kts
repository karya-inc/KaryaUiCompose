// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.ktlint)
    alias(libs.plugins.android.library) apply false
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    // Optionally configure plugin
    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(true)
        disabledRules.set(listOf("no-wildcard-imports", "filename", "enum-entry-name-case"))
    }
}
