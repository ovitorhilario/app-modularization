package utils.singletons

import org.gradle.api.JavaVersion

object Config {
    // Project and Default Config
    const val applicationId = "com.vitorhilarioapps.appmodularization"
    const val minSdk = 24
    const val compileSdk = 34
    const val targetSdk = 34
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    // Compile Options
    val sourceCompatibility = JavaVersion.VERSION_17
    val targetCompatibility = JavaVersion.VERSION_17


    // Kotlin Options
    val jvmTarget = JavaVersion.VERSION_17.toString()
}