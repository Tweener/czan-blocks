import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.compose.compiler)
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
}

android {
    namespace = ProjectConfiguration.CzanBlocks.namespace
    compileSdk = ProjectConfiguration.CzanBlocks.compileSDK

    defaultConfig {
        minSdk = ProjectConfiguration.CzanBlocks.minSDK

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
        }
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = ProjectConfiguration.Compiler.javaCompatibility
        targetCompatibility = ProjectConfiguration.Compiler.javaCompatibility
    }
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget {
        publishLibraryVariants("release")

        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(ProjectConfiguration.Compiler.jvmTarget))
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "czan-blocks"
            isStatic = true
        }
    }

    jvm()

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            commonWebpackConfig {
                outputFileName = "czan-blocks.js"
            }
        }
        binaries.executable()
    }

    js(IR) {
        browser {
            commonWebpackConfig {
                outputFileName = "czan-blocks.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            // Compose
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.materialIconsExtended)
            implementation(compose.runtime)
            implementation(compose.components.resources)
            implementation(libs.compose.multiplatform.material3)

            implementation(libs.napier)
            implementation(libs.android.annotations)

            // Tweener
            implementation(libs.kmpkit)
            implementation(libs.czan)
            implementation(libs.chartopia)

            // Coroutines
            implementation(libs.kotlin.coroutines.core)
        }

        androidMain.dependencies {
            // Compose
            api(compose.preview)
            api(compose.uiTooling)
            implementation(libs.android.activity.compose)

            // Coroutines
            implementation(libs.kotlin.coroutines.android)

            // Android
            implementation(libs.android.core)
        }

        iosMain.dependencies {

        }
    }
}

// region Publishing

group = ProjectConfiguration.CzanBlocks.Maven.group
version = ProjectConfiguration.CzanBlocks.versionName

mavenPublishing {
    publishToMavenCentral(host = SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)
    signAllPublications()
    coordinates(groupId = group.toString(), artifactId = ProjectConfiguration.CzanBlocks.Maven.name.lowercase(), version = version.toString())
    configure(
        platform = KotlinMultiplatform(
            javadocJar = JavadocJar.Dokka("dokkaHtml"),
            sourcesJar = false,
        )
    )

    pom {
        name = ProjectConfiguration.CzanBlocks.Maven.name
        description = ProjectConfiguration.CzanBlocks.Maven.description
        url = ProjectConfiguration.CzanBlocks.Maven.packageUrl

        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }

        issueManagement {
            system = "GitHub Issues"
            url = "${ProjectConfiguration.CzanBlocks.Maven.packageUrl}/issues"
        }

        developers {
            developer {
                id = ProjectConfiguration.CzanBlocks.Maven.Developer.id
                name = ProjectConfiguration.CzanBlocks.Maven.Developer.name
                email = ProjectConfiguration.CzanBlocks.Maven.Developer.email
            }
        }

        scm {
            connection = "scm:git:git://${ProjectConfiguration.CzanBlocks.Maven.gitUrl}"
            developerConnection = "scm:git:ssh://${ProjectConfiguration.CzanBlocks.Maven.gitUrl}"
            url = ProjectConfiguration.CzanBlocks.Maven.packageUrl
        }
    }
}

// endregion Publishing
