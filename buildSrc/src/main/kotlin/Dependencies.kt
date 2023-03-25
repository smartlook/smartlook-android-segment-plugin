object Dependencies {
    private const val gradleVersion = "7.3.0"
    private const val kotlinVersion = "1.7.20"
    private const val kotlinxMetadataJvmVersion = "0.4.2"

    const val gradle = "com.android.tools.build:gradle:$gradleVersion"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"

    object Test {
        private const val junitVersion = "4.12"
        const val junit = "junit:junit:$junitVersion"
    }
}
