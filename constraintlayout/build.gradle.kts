plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 21
        targetSdk = 31
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
    compileOnly("androidx.core:core-ktx:1.7.0")
    compileOnly("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation(project(":insetswidget"))
}

tasks {
    register("sourcesJar", Jar::class) {
        from(android.sourceSets["main"].java.srcDirs)
        archiveClassifier.set("sources")
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.takwolf.android.insetswidget"
                artifactId = "constraintlayout"
                version = "0.0.1"

                from(components["release"])
                artifact(tasks.named("sourcesJar"))
            }
        }
    }
}