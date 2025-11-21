plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.takwolf.android.insetswidget.constraintlayout"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 23

        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

dependencies {
    compileOnly("androidx.core:core-ktx:1.17.0")
    compileOnly("androidx.constraintlayout:constraintlayout:2.2.1")
    api(project(":insetswidget"))
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.takwolf.android.insetswidget"
            artifactId = "constraintlayout"
            version = "0.0.2"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
