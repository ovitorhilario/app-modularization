import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import utils.extensions.configureMinimalConfig
import utils.extensions.configureProguard
import utils.singletons.Config

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureMinimalConfig(this)
                configureProguard()

                defaultConfig.applicationId = Config.applicationId
                defaultConfig.targetSdk = Config.targetSdk
                defaultConfig.versionCode = Config.versionCode
                defaultConfig.versionName = Config.versionName
            }
        }
    }
}