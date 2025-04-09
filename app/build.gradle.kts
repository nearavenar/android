plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-parcelize")
    //id("kotlin-kapt")
    id("com.google.devtools.ksp")
}

android {
    namespace = "cl.naravenar.cocktailapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "cl.naravenar.cocktailapp"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

val roomVersion = "2.6.1"

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.fragment.ktx)

    implementation ("com.github.bumptech.glide:glide:4.16.0")
    ksp ("com.github.bumptech.glide:ksp:4.16.0")

    implementation("androidx.room:room-runtime:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("com.google.code.gson:gson:2.8.7")

    //var room_version = "2.6.1"
    //var room_coroutines_version = "1.3.9"
    //implementation("androidx.room:room-runtime:$room_version")//dependencya de room
    //annotationProcessor("androidx.room:room-compiler:$room_version")//compilador de room
    //kapt("androidx.room:room-compiler:$room_version")
    //implementation("androidx.room:room-coroutines:1.3.9")//le dice lo que va a implementar como las corutinas, (puede ser de cualquier libreria)
    //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    //implementation("androidx.room:room-ktx:$room_coroutines_version")//Le dice

}