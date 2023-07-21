package utils.extensions

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import utils.singletons.CatalogHelper

internal fun Project.configureCompose(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion(CatalogHelper.composeCompiler).get().toString()
        }

        dependencies {
            val bom = libs.findLibrary(CatalogHelper.composeBom).get()
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))

            add("implementation", libs.findBundle("compose").get())
            add("debugImplementation", libs.findLibrary("androidx-compose-tooling").get())
        }
    }
}