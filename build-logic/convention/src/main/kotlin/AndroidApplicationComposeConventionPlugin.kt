import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import utils.extensions.configureCompose

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.vitorhilarioapps.android.application")
            val extension = extensions.getByType<ApplicationExtension>()
            configureCompose(extension)
        }
    }
}