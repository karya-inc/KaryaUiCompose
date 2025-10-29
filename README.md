# KaryaUi Compose 🎨

A modern Compose Multiplatform UI library providing Karya-specific components for building beautiful, consistent user interfaces across Android, iOS, Desktop, and Web platforms.

## Features

- **Karya-specific UI components** - Tailored components for Karya applications
- **Multiplatform support** - Works on Android, iOS, Desktop, and Web
- **Modern design system** - Consistent styling and theming
- **Compose-based** - Built with Jetpack Compose and Compose Multiplatform
- **Easy integration** - Simple setup with Maven Central distribution

## Installation

### Gradle (Kotlin DSL)

Add the dependency to your `libs.versions.toml`:

```toml
[versions]
karyaUi = "0.0.1"

[libraries]
karya-ui-cmp = { module = "io.github.karya-inc:karya-ui", version.ref = "karyaUi" }
```

Then in your module's `build.gradle.kts`:

```kotlin
dependencies {
    implementation(libs.karya.ui.cmp)
}
```

### Gradle (Groovy)

```gradle
dependencies {
    implementation 'io.github.karya-inc:karya-ui:0.0.1'
}
```

### Maven

```xml
<dependency>
    <groupId>io.github.karya-inc</groupId>
    <artifactId>karya-ui</artifactId>
    <version>0.0.1</version>
</dependency>
```

## Platform Support

| Platform | Status |
|----------|--------|
| Android  | ✅ Supported |
| iOS      | ✅ Supported |
| Desktop  | ✅ Supported |
| Web      | ✅ Supported |

## Contributing

We welcome contributions! Please see our [Contributing Guide](CONTRIBUTING.md) for details.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details.

## Links
- [Maven Central](https://central.sonatype.com/artifact/io.github.karya-inc/karya-ui)
- [Issues](https://github.com/karya-inc/KaryaUi-CMP/issues)
- [Releases](https://github.com/karya-inc/KaryaUi-CMP/releases)

---

**Made with ❤️ by the Karya team**
