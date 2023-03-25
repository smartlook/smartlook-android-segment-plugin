import org.gradle.api.JavaVersion

object Configurations {

    object Android {
        const val compileVersion = 33
        const val minVersion = 16
        const val targetVersion = 33
    }

    object Compilation {
        const val jvmTarget = "1.8"
        val sourceCompatibility = JavaVersion.VERSION_1_8
        val targetCompatibility = JavaVersion.VERSION_1_8
    }

    object Artifactory {
        const val repositoryURL = "https://artifactory.ci.smartlook.cloud/artifactory/libs-release-local"
    }

    const val sdkVersionCode = 1
    const val sdkVersionName = "1.0.0"
}