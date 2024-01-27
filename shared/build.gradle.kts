plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
}

version = "1.0-SNAPSHOT"

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }


    iosX64()
    iosArm64()
    iosSimulatorArm64()
    cocoapods {
        ios.deploymentTarget = "15.0" //  this min ios version
        pod("SmileID") {
            //https://kotlinlang.org/docs/native-cocoapods-libraries.html#support-for-objective-c-headers-with-import-directives
            extraOpts += listOf("-compiler-option", "-fmodules")
            source = git("https://github.com/smileidentity/ios.git") {
                commit = "c9f6cdd5fcde7af20125b92904b3b92a69342445"
            }
        }
    }

    sourceSets {
        all {
            languageSettings {
                optIn("kotlinx.cinterop.ExperimentalForeignApi")
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
            implementation("com.smileidentity:android-sdk:10.0.3")
        }
    }
}

android {
    namespace = "com.sample"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
