[![Maven Central Version](https://img.shields.io/maven-central/v/io.github.tweener/czan-blocks?color=orange)](https://central.sonatype.com/artifact/io.github.tweener/czan-blocks)
[![Kotlin](https://img.shields.io/badge/kotlin-2.4.21-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose](https://img.shields.io/badge/compose-1.12.2-blue.svg?logo=jetpackcompose)](https://www.jetbrains.com/lp/compose-multiplatform)
![gradle-version](https://img.shields.io/badge/gradle-9.5.1-blue?logo=gradle)
[![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)](LICENSE)

[![Website](https://img.shields.io/badge/Author-vivienmahe.com-purple)](https://vivienmahe.com/)
[![X/Twitter](https://img.shields.io/twitter/follow/VivienMahe)](https://twitter.com/VivienMahe)

---

# CzanBlocks

**CzanBlocks** is a set of clean, customizable blocks for Kotlin/Compose Multiplatform apps, built on the [CZAN](https://github.com/Tweener/czan) design system. It targets Android, iOS, JVM, JS and WasmJS.

<br>

Be sure to show your support by starring ⭐️ this repository!

---

## ✨ What's inside

Every block is a `@Composable` in the `com.tweener.czan.blocks` package. Each one takes a `modifier`, and most take a `shape` plus `colors` and `sizes` built from their `...Defaults` object, so you can restyle them without forking them. Default colors and text styles come from `MaterialTheme`.

### Blocks
- `Block`: the base card, with an optional title, headline, extra title content, footer and click action. The other blocks are built on it.
- `EditableInfoBlock`: a block with a title, an optional headline and leading icon, an edit button and an optional delete button.
- `TabsBlock`: a block with a segmented button on top that switches between tabs, given as a map of tab titles to content.
- `InfoPieChartBlock`: a block with an animated donut chart (from [Chartopia](https://github.com/Tweener/chartopia)), a progress label, an optional total and a callback when a segment is clicked.

### Paywall
- `PaywallProductHorizontalBlock` and `PaywallProductVerticalBlock`: selectable product cards for a paywall, with a title, an amount, an optional amount headline (an `AnnotatedString`, e.g. "per month") and an optional promo tag.

### Components
- `ClickableIcon`: an icon on a tinted background, with an optional click action. It accepts a `DrawableResource`, a `Painter` or an `ImageVector`.

### Theme
- `ColorScheme.onBackgroundVariant`: an extra color for secondary text, with light and dark values.

---

## 🛠️ Installation

In your `settings.gradle.kts` file, add Maven Central to your repositories:
```Groovy
repositories {
    mavenCentral()
}
```

Then add the CzanBlocks dependency to your module:

- With version catalog, open `libs.versions.toml`:
```Groovy
[versions]
czanBlocks = "1.*.*" // Check latest version

[libraries]
czan-blocks = { group = "io.github.tweener", name = "czan-blocks", version.ref = "czanBlocks" }
```

Then in your module `build.gradle.kts` add:
```Groovy
dependencies {
    implementation(libs.czan.blocks)
}
```

- Without version catalog, in your module `build.gradle.kts` add:
```Groovy
dependencies {
    val czanBlocksVersion = "1.*.*" // Check latest version

    implementation("io.github.tweener:czan-blocks:$czanBlocksVersion")
}
```

The latest version is: [![Maven Central Version](https://img.shields.io/maven-central/v/io.github.tweener/czan-blocks?color=orange)](https://central.sonatype.com/artifact/io.github.tweener/czan-blocks)

---

## 📜 Licence

CzanBlocks is licensed under the [Apache-2.0](LICENSE).
