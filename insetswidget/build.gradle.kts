plugins {
    id("com.android.library")
    id("com.vanniktech.maven.publish")
}

android {
    namespace = "com.takwolf.android.insetswidget"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        minSdk = 23

        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    compileOnly("androidx.core:core-ktx:1.17.0")
}

mavenPublishing {
    coordinates("io.github.takwolf.android.insetswidget", "insetswidget", "0.0.1")

    pom {
        name.set("Android-InsetsWidget")
        description.set("Android widgets for handling edge-to-edge display.")
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
