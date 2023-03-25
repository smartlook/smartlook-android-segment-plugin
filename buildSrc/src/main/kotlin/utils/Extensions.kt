import org.gradle.api.Project

fun Project.optProperty(name: String): Any? {
    return if (project.hasProperty(name)) {
        project.property(name)
    } else {
        null
    }
}

fun Any?.wrapAsBuildConfigField(): String = this?.run { "\""+this.toString()+"\"" } ?: "\"\""

fun String.firstLetterToLowercase(): String {
    val charArray = this.toCharArray()
    charArray[0] = Character.toLowerCase(charArray[0]);
    return String(charArray)
}

fun String.firstLetterToUppercase(): String {
    val charArray = this.toCharArray()
    charArray[0] = Character.toUpperCase(charArray[0]);
    return String(charArray)
}
