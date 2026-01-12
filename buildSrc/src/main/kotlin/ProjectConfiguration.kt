import org.gradle.api.JavaVersion

/**
 * @author Vivien Mahe
 * @since 23/07/2022
 */

object ProjectConfiguration {

    object CzanBlocks {
        const val packageName = "com.tweener.czan.blocks"
        const val versionName = "1.0.6"
        const val namespace = "$packageName.android"
        const val compileSDK = 36
        const val minSDK = 24

        object Maven {
            const val name = "CzanBlocks"
            const val description = "Clean, customizable blocks for Kotlin/Compose Multiplatform apps based on CZAN design system."
            const val group = "io.github.tweener"
            const val artifactId = "czan-blocks"
            const val packageUrl = "https://github.com/Tweener/czan-blocks"
            const val gitUrl = "github.com:Tweener/czan-blocks.git"

            object Developer {
                const val id = "Tweener"
                const val name = "Vivien Mahé"
                const val email = "vivien@tweener-labs.com"
            }
        }
    }

    object Compiler {
        val javaCompatibility = JavaVersion.VERSION_21
        val jvmTarget = javaCompatibility.toString()
    }
}
