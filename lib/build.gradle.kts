import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.androidLint)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
    id("maven-publish")
    id("com.vanniktech.maven.publish") version "0.34.0"
}

kotlin {

    androidLibrary {
        namespace = "com.daiatech.karya.ui"
        compileSdk = 36
        minSdk = 21

        withHostTestBuilder {
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    jvm()

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "KaryaUiKit"
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(libs.androidx.lifecycle.runtimeCompose.cmp)
            }
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "com.daiatech.karya.ui"
    generateResClass = auto
}

group = "io.github.karya-inc"
version = "0.0.4"

mavenPublishing {
    val artifactId = "karya-ui"
    publishToMavenCentral(true)
    signAllPublications()

    coordinates(
        groupId = group.toString(),
        artifactId = artifactId,
        version = version.toString()
    )

    pom {
        name.set(artifactId)
        description.set("Compose multiplatform Karya-UI library")
        url.set("https://github.com/karya-inc/KaryaUi-CMP.git")

        licenses {
            license {
                name.set("GNU license")
                url.set("https://opensource.org/license/gpl-3-0")
            }
        }

        developers {
            developer {
                id.set("divyansh@karya.in")
                name.set("Divyansh Kushwaha")
                email.set("divyansh@karya.in")
            }
        }

        scm {
            connection.set("scm:git:ssh://git@github.com/karya-inc/KaryaUi-CMP.git")
            developerConnection.set("scm:git:ssh://git@github.com/karya-inc/KaryaUi-CMP.git")
            url.set("https://github.com/karya-inc/KaryaUi-CMP.git")
        }
    }
}
