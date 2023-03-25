object Dependencies {

    // Project level dependencies

    private const val gradleVersion = "7.3.0"
    private const val kotlinVersion = "1.7.20"
    private const val kotlinxMetadataJvmVersion = "0.4.2"

    const val gradle = "com.android.tools.build:gradle:$gradleVersion"
    const val gradleApi = "com.android.tools.build:gradle-api:$gradleVersion"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val kotlinxMetadataJvm = "org.jetbrains.kotlinx:kotlinx-metadata-jvm:$kotlinxMetadataJvmVersion"

    // SDK module level dependencies

    private const val okhttpVersion = "4.2.1"

    const val kotlinStdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val okhttp = "com.squareup.okhttp3:okhttp:$okhttpVersion"

    object Test {
        private const val junitVersion = "4.12"
        private const val jsonassertVersion = "1.5.0"
        private const val mockkVersion = "1.12.4"
        private const val fragmentVersion = "1.4.1"
        private const val robolectricVersion = "4.8"
        private const val mockWebServerVersion = "4.10.0"

        const val junit = "junit:junit:$junitVersion"
        const val jsonassert = "org.skyscreamer:jsonassert:$jsonassertVersion"
        const val mockk = "io.mockk:mockk:$mockkVersion"
        const val fragmentTest = "androidx.fragment:fragment-testing:$fragmentVersion"
        const val robolectric = "org.robolectric:robolectric:$robolectricVersion"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$mockWebServerVersion"
    }

    object Android {
        private const val annotationVersion = "1.4.0"
        private const val coreKtxVersion = "1.7.0"
        private const val appcompatVersion = "1.3.1"
        private const val designVersion = "1.2.0"
        private const val playServicesMapVersion = "18.0.2"
        private const val multidexVersion = "2.0.1"
        private const val activityComposeVersion = "1.3.1"
        private const val recyclerVersion = "1.2.1"
        private const val cardVersion = "1.0.0"
        private const val materialVersion = "1.5.0"

        const val annotation = "androidx.annotation:annotation:$annotationVersion"
        const val appcompat = "androidx.appcompat:appcompat:$appcompatVersion"
        const val design = "com.google.android.material:material:$designVersion"
        const val playServicesMap = "com.google.android.gms:play-services-maps:$playServicesMapVersion"
        const val multidex = "androidx.multidex:multidex:$multidexVersion"
        const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"
        const val recycler = "androidx.recyclerview:recyclerview:$recyclerVersion"
        const val cardView = "androidx.cardview:cardview:$cardVersion"
        const val material = "com.google.android.material:material:$materialVersion"

        // Test application

        private const val constraintLayoutVersion = "2.1.4"
        private const val activityKtxVersion = "1.2.2"
        private const val fragmentKtxVersion = "1.3.3"
        private const val fragmentVersion = "1.3.3"

        const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
        const val activityKtx = "androidx.activity:activity-ktx:$activityKtxVersion"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:$fragmentKtxVersion"
        const val fragment = "androidx.fragment:fragment:$fragmentVersion"

        object Compose {
            private const val version = "1.2.1"

            const val compilerVersion = "1.3.2"

            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val ui = "androidx.compose.ui:ui:$version"
            const val uiUtil = "androidx.compose.ui:ui-util:$version"
            const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val foundationLayout = "androidx.compose.foundation:foundation-layout:$version"
            const val material = "androidx.compose.material:material:$version"
            const val materialIconsCore = "androidx.compose.material:material-icons-core:$version"
            const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
            const val animation = "androidx.compose.animation:animation:$version"
        }
    }

    object Network {
        private const val okHttpVersion = "4.10.0"

        const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
    }

    object AndroidTest {
        private const val junitVersion = "1.1.3"
        private const val testRulesVersion = "1.4.0"
        private const val mockkVersion = "1.12.4"

        const val junit = "androidx.test.ext:junit:$junitVersion"
        const val testRules = "androidx.test:rules:$testRulesVersion"
        const val mockk = "io.mockk:mockk-android:$mockkVersion"
    }

    object AndroidDebug {
        private const val leakCanaryVersion = "2.10"

        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:$leakCanaryVersion"
    }
}
