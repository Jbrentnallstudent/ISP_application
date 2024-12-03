// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
}

dependencies {
    implementation 'androidx.navigation:navigation-fragment-ktx:2.7.2'
    implementation 'androidx.navigation:navigation-ui-ktx:2.7.2'
    implementation 'com.prolificinteractive:material-calendarview:1.4.3'
    implementation 'androidx.room:room-runtime:2.5.0'
    annotationProcessor 'androidx.room:room-compiler:2.5.0' // or use kapt if using Kotlin
}


