plugins {
    id("com.vitorhilarioapps.library.compose")
}

android {
    namespace = "com.vitorhilarioapps.feature.books"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}