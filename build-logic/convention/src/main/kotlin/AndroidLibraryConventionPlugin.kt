import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import utils.extensions.configureMinimalConfig
import utils.extensions.configureProguard
import utils.singletons.Config

class AndroidLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureMinimalConfig(this)
                configureProguard()
                defaultConfig.targetSdk = Config.targetSdk
            }
        }
    }
}