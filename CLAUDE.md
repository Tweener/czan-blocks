# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

CzanBlocks is a Kotlin Multiplatform library providing clean, customizable blocks for Compose Multiplatform apps based on the CZAN design system. The project supports Android, iOS, JVM, JS, and WebAssembly targets.

## Common Commands

### Building and Testing
- `./gradlew build` - Assembles and tests the entire project
- `./gradlew :czan-blocks:build` - Build the main library module
- `./gradlew allTests` - Run tests for all targets with aggregated report
- `./gradlew jvmTest` - Run JVM-specific tests
- `./gradlew iosSimulatorArm64Test` - Run iOS simulator tests
- `./gradlew jsBrowserTest` - Run JS tests in browser
- `./gradlew test` - Run unit tests for all variants

### Publishing
- `./gradlew publish` - Publish to Maven Central (requires proper credentials)
- `./gradlew publishToMavenLocal` - Publish to local Maven repository

### Dependency Management
- `./gradlew dependencyUpdates` - Check for dependency updates

### Sample App
- `./gradlew :sample:composeApp:assembleDebug` - Build sample Android app
- `./gradlew :sample:composeApp:installDebugAndroidTest` - Install and run Android tests

## Architecture

### Module Structure
- **czan-blocks/** - Main library module containing all reusable blocks
- **sample/** - Sample application demonstrating library usage
  - **composeApp/** - Multiplatform Compose app
  - **iosApp/** - iOS-specific app wrapper
- **buildSrc/** - Build configuration and custom Gradle tasks

### Core Components

The library is built around customizable blocks that follow the CZAN design system:

1. **Block.kt** - Core block component that wraps content in a styled card
2. **Theme components** - Colors, shapes, and typography following Material Design 3
3. **Specialized blocks** - Chart blocks, paywall blocks, tabs, etc.

### Design System Integration
- Based on CZAN design system (external dependency: `libs.czan`)
- Uses Chartopia for chart components (`libs.chartopia`)
- Built on top of Compose Multiplatform Material 3

### Project Configuration
All project configuration is centralized in `buildSrc/src/main/kotlin/ProjectConfiguration.kt`:
- Version numbers, SDK versions, and compiler settings
- Maven publishing metadata
- Package names and namespaces

## Multiplatform Setup

### Supported Targets
- **androidTarget** - Android library and apps
- **iosArm64/iosSimulatorArm64** - iOS framework
- **jvm** - Desktop/server JVM applications
- **js(IR)** - JavaScript applications
- **wasmJs** - WebAssembly applications

### Platform-Specific Code
Source sets are organized by platform in `czan-blocks/src/`:
- `commonMain/` - Shared multiplatform code
- `androidMain/` - Android-specific implementations
- `iosMain/` - iOS-specific implementations
- `jvmMain/`, `jsMain/`, `wasmJsMain/` - Other platform specifics

## Development Notes

### Initial Setup
This project includes a `renameProject` task for template customization:
```bash
./gradlew renameProject -PprojectName=MyLibrary -PpackageName=com.example.mylibrary
```

### Dependencies
Key external dependencies:
- Kotlin 2.2.20 with Compose Multiplatform 1.9.0
- CZAN design system (Tweener)
- KMP Kit utilities
- Napier for logging
- Kotlinx Coroutines

### Version Management
- Library version: Defined in `ProjectConfiguration.CzanBlocks.versionName`
- Dependency versions: Managed in `gradle/libs.versions.toml`
- Automatic publishing via GitHub Actions on release creation

### GitHub Actions
The project includes automated workflows for:
- Build validation on PRs (`buildRelease.yml`)
- Maven Central publishing (`publish.yml`)
- Dependency update checks (`checkVersionDependencies.yml`)
- Slack notifications (`notify.yml`)