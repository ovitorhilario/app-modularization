plugins {
    id("com.vitorhilarioapps.application.compose")
}

android {
    namespace = "com.vitorhilarioapps.appmodularization"
}

dependencies {
    implementation(project(":feature:books"))

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}