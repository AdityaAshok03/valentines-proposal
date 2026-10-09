plugins {
    id("com.android.application")
}

/*
 * The web page at the root of this repository (../../index.html) is the ONE
 * source of truth for what the app looks like. This task copies it into the
 * app's assets folder before every build, so editing that single file is
 * enough -- there is no second copy to keep in sync.
 */
val copyWebApp by tasks.registering(Copy::class) {
    description = "Copies the repository's index.html into the app's assets."
    from(rootProject.file("../index.html"))
    into(file("src/main/assets"))
}

tasks.named("preBuild") {
    dependsOn(copyWebApp)
}

android {
    namespace = "com.adityaashok.valentine"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.adityaashok.valentine"
        minSdk = 26          // Android 8.0, released 2017 -- covers virtually every phone in use
        targetSdk = 34       // 34 (not 35) keeps the normal status bar instead of forced edge-to-edge
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
