// app/build.gradle.kts
Plugins {
    Id("com.android.application") version "8.9.1"
    Id("org.jetbrains.kotlin.android") version "1.9.23"
    Id("com.google.dagger.hilt.android") version "2.51"
    Id("org.jetbrains.kotlin.kapt") version "1.9.23"
}

Android {
    Namespace = "com.cavemind.karlscrypto"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cavemind.karlscrypto"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

Dependencies {
    Implementation("androidx.core:core-ktx:1.12.0")
    Implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    Implementation("androidx.activity:activity-compose:1.8.2")

    // Compose
    Implementation("androidx.compose.material3:material3:1.2.1")
    Implementation("androidx.navigation:navigation-compose:2.7.6")

    // Hilt
    Implementation("com.google.dagger:hilt-android:2.51")
    Kapt("com.google.dagger:hilt-android-compiler:2.51")

    // Retrofit
    Implementation("com.squareup.retrofit2:retrofit:2.9.0")
    Implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // DataStore
    Implementation("androidx.datastore:datastore-preferences:1.0.0")

    // Coil for image loading
    Implementation("io.coil-kt:coil-compose:2.4.0")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

