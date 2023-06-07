package com.clouflake.hunjang

import io.github.cdimascio.dotenv.dotenv
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class DotEnvTests {
    @Test
    fun ReadEnvApiKey_shouldSuccess() {
        val env = dotenv()
        val apiKey = env["api-key"]
        assertNotNull(apiKey)
    }
}