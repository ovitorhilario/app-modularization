import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import utils.extensions.configureCompose

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.vitorhilarioapps.android.library")
            val extension = extensions.getByType<LibraryExtension>()
            configureCompose(extension)
        }
    }
}