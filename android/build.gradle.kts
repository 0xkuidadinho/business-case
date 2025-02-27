plugins {
    id("com.android.application")  // Ensure you have the correct version
    id("org.jetbrains.kotlin.android")  // Ensure Kotlin version matches the compatibility
    kotlin("kapt")
}


android {
    namespace = "com.android.support.exercise"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.android.support.exercise"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)  // From libs.versions.toml
    implementation(libs.androidx.appcompat)  // From libs.versions.toml
    implementation(libs.material)  // From libs.versions.toml
    implementation(libs.androidx.activity)  // From libs.versions.toml
    implementation(libs.androidx.constraintlayout)  // From libs.versions.toml
    testImplementation(libs.junit)  // From libs.versions.toml
    androidTestImplementation(libs.androidx.junit)  // From libs.versions.toml
    androidTestImplementation(libs.androidx.espresso.core)  // From libs.versions.toml
    implementation("androidx.room:room-ktx:2.6.1") {  // You can keep it manually if needed
        exclude("com.intellij", "annotations")
    }
    kapt("androidx.room:room-compiler:2.6.1") {  // Room dependency for kapt
        exclude("com.intellij", "annotations")
    }
    implementation(libs.retrofit)  // From libs.versions.toml
    implementation(libs.retrofit.converter.gson)  // From libs.versions.toml
    implementation(libs.glide)  // From libs.versions.toml
}


