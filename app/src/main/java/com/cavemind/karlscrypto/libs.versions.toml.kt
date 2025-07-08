[versions]
Kotlin = "1.9.22"
Compose = "1.5.4"
Hilt = "2.48"
Material3 = "1.2.0"
Lifecycle = "2.6.2"
Activity = "1.8.2"

[libraries]
Core-ktx = { module = "androidx.core:core-ktx", version = "1.12.0" }
Appcompat = { module = "androidx.appcompat:appcompat", version = "1.6.1" }
Material3 = { module = "androidx.compose.material3:material3", version.ref = "material3" }
Compose-ui = { module = "androidx.compose.ui:ui", version.ref = "compose" }
Compose-tooling = { module = "androidx.compose.ui:ui-tooling", version.ref = "compose" }
Compose-preview = { module = "androidx.compose.ui:ui-tooling-preview", version.ref = "compose" }
Activity-compose = { module = "androidx.activity:activity-compose", version.ref = "activity" }
Hilt-android = { module = "com.google.dagger:hilt-android", version.ref = "hilt" }
Hilt-compiler = { module = "com.google.dagger:hilt-compiler", version.ref = "hilt" }
Lifecycle-runtime = { module = "androidx.lifecycle:lifecycle-runtime-ktx", version.ref = "lifecycle" }

