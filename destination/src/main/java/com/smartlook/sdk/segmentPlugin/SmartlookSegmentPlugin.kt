import com.segment.analytics.kotlin.core.BaseEvent
import com.segment.analytics.kotlin.core.GroupEvent
import com.segment.analytics.kotlin.core.IdentifyEvent
import com.segment.analytics.kotlin.core.ScreenEvent
import com.segment.analytics.kotlin.core.TrackEvent
import com.segment.analytics.kotlin.core.platform.DestinationPlugin
import com.smartlook.android.core.api.Smartlook
import com.smartlook.android.core.api.model.Properties
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

class SmartlookSegmentPlugin : DestinationPlugin() {

    override val key: String = KEY

    override fun group(payload: GroupEvent): BaseEvent = payload

    override fun identify(payload: IdentifyEvent): BaseEvent {
        val userId: String = payload.userId
        val traits: JsonObject = payload.traits
        Smartlook.instance.user.identifier = userId
        Smartlook.instance.user.properties.apply {
            traits.flatten().forEach {
                putString(it.key, it.value)
            }
        }
        return payload
    }

    override fun screen(payload: ScreenEvent): BaseEvent {
        val screenName = payload.name
        val properties = payload.properties
        Smartlook.instance.trackNavigationEnter(screenName, Properties().apply {
            properties.flatten().forEach {
                putString(it.key, it.value)
            }
        })
        return payload
    }

    override fun track(payload: TrackEvent): BaseEvent {
        val eventName = payload.event
        val properties = payload.properties
        Smartlook.instance.trackEvent(eventName, Properties().apply {
            properties.flatten().forEach {
                putString(it.key, it.value)
            }
        })
        return payload
    }

    override fun reset() {
        Smartlook.instance.user.openNew()
    }

    companion object {
        private const val KEY = "Smartlook"
    }
}

internal fun JsonElement.flatten(prefix: String? = null): Map<String, String> {
    return when (this) {
        is JsonPrimitive -> mapOf((prefix ?: "") to content).entries
        is JsonObject -> entries.flatMap { entry ->
            val finalKey = if (prefix == null) entry.key else "${prefix}_${entry.key}"
            entry.value.flatten(finalKey).entries
        }
        is JsonArray -> flatMapIndexed { index: Int, jsonElement: JsonElement ->
            val finalKey = if (prefix == null) index.toString() else "${prefix}_$index"
            jsonElement.flatten(finalKey).entries
        }
        else -> emptyMap<String, String>().entries
    }.associate { it.key to it.value }
}
