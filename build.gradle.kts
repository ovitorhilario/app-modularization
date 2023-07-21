buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

// Lista de todos os plugins usados no projeto, sem aplicá-los.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
}