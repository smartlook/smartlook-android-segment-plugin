// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        mavenCentral()
        google()
        maven {
            setUrl("https://sdk.smartlook.com/android/release")
        }
    }

    dependencies {
        classpath(Dependencies.gradle)
        classpath(Dependencies.kotlin)
    }
}

allprojects {
    apply("$rootDir/gradle/projectExtensions.gradle")

    repositories {
        mavenCentral()
        google()
        maven {
            setUrl("https://sdk.smartlook.com/android/release")
        }
    }
}
