plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.vanniktech.maven.publish")
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
}

dependencies {
    compileOnly("androidx.core:core-ktx:1.17.0")
    compileOnly("androidx.constraintlayout:constraintlayout:2.2.1")
    api(project(":insetswidget"))
}

mavenPublishing {
    coordinates("io.github.takwolf.android.insetswidget", "constraintlayout", "0.0.0")

    pom {
        name.set("Android-InsetsWidget")
        description.set("An Android widget for handling edge-to-edge display.")
        url.set("https://github.com/TakWolf/Android-InsetsWidget")
        inceptionYear.set("2025")
        licenses {
            license {
                name.set("Apache-2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("repo")
            }
        }
        developers {
            developer {
                id.set("TakWolf")
                name.set("TakWolf")
                url.set("https://github.com/TakWolf")
            }
        }
        scm {
            url.set("https://github.com/TakWolf/Android-InsetsWidget")
            connection.set("scm:git:git://github.com/TakWolf/Android-InsetsWidget.git")
            developerConnection.set("scm:git:ssh://git@github.com/TakWolf/Android-InsetsWidget.git")
        }
    }

    publishToMavenCentral()
    signAllPublications()
}
