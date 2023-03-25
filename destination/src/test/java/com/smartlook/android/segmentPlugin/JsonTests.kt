package com.smartlook.android.segmentPlugin

import kotlinx.serialization.json.Json
import org.junit.Assert
import org.junit.Test

class JsonTests {

    @Test
    fun `test simple json element`() {
        val input = Json.parseToJsonElement(
            """
            {
            	"integrations": {
            		"FooDestination": {
            			"configA": true,
            			"configB": 10,
            			"configC": "value3"
            		}
            	}
            }
        """.trimIndent()
        )

        val expectedOutput = mapOf(
            "integrations_FooDestination_configA" to "true",
            "integrations_FooDestination_configB" to "10",
            "integrations_FooDestination_configC" to "value3"
        )

        Assert.assertEquals(expectedOutput, input.flatten())
    }

    @Test
    fun `test json element with array`() {
        val input = Json.parseToJsonElement(
            """
           {
            	"integrations": [0, 1, 2]
            }
        """.trimIndent()
        )

        val expectedOutput = mapOf(
            "integrations_0" to "0",
            "integrations_1" to "1",
            "integrations_2" to "2"
        )

        Assert.assertEquals(expectedOutput, input.flatten())
    }

    @Test
    fun `test json element with array of objects`() {
        val input = Json.parseToJsonElement(
            """
            {
            	"integrations": [{
            		"value": "0"
            	}, {
            		"value": "1"
            	}, {
            		"value": "2"
            	}]
            }
        """.trimIndent()
        )

        val expectedOutput = mapOf(
            "integrations_0_value" to "0",
            "integrations_1_value" to "1",
            "integrations_2_value" to "2"
        )

        Assert.assertEquals(expectedOutput, input.flatten())
    }

    @Test
    fun `test array of objects`() {
        val input = Json.parseToJsonElement(
            """
            [{
                "value": "0"
            }, {
                "value": "1"
            }, {
                "value": "2"
            }]
        """.trimIndent()
        )

        val expectedOutput = mapOf(
            "0_value" to "0",
            "1_value" to "1",
            "2_value" to "2"
        )

        Assert.assertEquals(expectedOutput, input.flatten())
    }
}