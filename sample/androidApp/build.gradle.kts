plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.compose.compiler)
}

android {
    namespace = ProjectConfiguration.CzanBlocks.packageName + ".sample"
    compileSdk = ProjectConfiguration.CzanBlocks.compileSDK

    defaultConfig {
        applicationId = ProjectConfiguration.CzanBlocks.packageName + ".sample"
        minSdk = ProjectConfiguration.CzanBlocks.minSDK
        targetSdk = ProjectConfiguration.CzanBlocks.compileSDK
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = ProjectConfiguration.Compiler.javaCompatibility
        targetCompatibility = ProjectConfiguration.Compiler.javaCompatibility
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":sample:composeApp"))

    implementation(libs.android.activity)
    implementation(libs.android.activity.compose)
}
