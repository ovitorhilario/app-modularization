package utils.extensions

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import utils.singletons.Config

internal fun Project.configureMinimalConfig(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {

        defaultConfig {
            compileSdk = Config.compileSdk
            minSdk = Config.minSdk
            vectorDrawables.useSupportLibrary = true

            testInstrumentationRunner = Config.testInstrumentationRunner
        }

        compileOptions {
            sourceCompatibility = Config.sourceCompatibility
            targetCompatibility = Config.targetCompatibility
        }

        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
    }

    configureKotlin()
}

private fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = Config.jvmTarget
        }
    }
}

internal fun Project.configureKotlinJvm() {
    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = Config.sourceCompatibility
        targetCompatibility = Config.targetCompatibility
    }

    configureKotlin()
}

internal fun LibraryExtension.configureProguard() {
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
            consumerProguardFiles("proguard-rules.pro")
        }

        debug {
            isMinifyEnabled = false
        }
    }
}

internal fun ApplicationExtension.configureProguard() {
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        debug {
            isMinifyEnabled = false
        }
    }
}
