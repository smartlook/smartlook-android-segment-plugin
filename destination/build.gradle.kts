plugins {
    id("com.android.library")
    id("kotlin-android")
}

apply("$rootDir/gradle/mavenPublish.gradle")

ext {
    set("mavenArtifactId", "smartlook-analytics-segment")
    set("mavenVersion", Configurations.sdkVersionName)
}

android {
    namespace = "com.smartlook.sdk.segmentPlugin"
    compileSdk = Configurations.Android.compileVersion

    defaultConfig {
        minSdk = Configurations.Android.minVersion
        targetSdk = Configurations.Android.targetVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    testOptions {
        unitTests.apply {
            isIncludeAndroidResources = true
        }
    }

    compileOptions {
        sourceCompatibility = Configurations.Compilation.sourceCompatibility
        targetCompatibility = Configurations.Compilation.targetCompatibility
    }

    kotlinOptions {
        jvmTarget = Configurations.Compilation.jvmTarget

        /**
         * No warnings on kotlin experimental features that are used in the SDK.
         */
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-opt-in=com.smartlook.coroutines.ExperimentalCoroutinesApi",
            "-opt-in=com.smartlook.coroutines.FlowPreview"
        )
    }
}

dependencies {
    implementation("com.segment.analytics.kotlin:android:1.7.0")
    implementation("com.smartlook.android:smartlook-analytics:2.2.2")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.20")
    implementation("androidx.core:core-ktx:1.9.0")

    testImplementation("io.mockk:mockk:1.13.2")
    testImplementation(Dependencies.Test.junit)
}