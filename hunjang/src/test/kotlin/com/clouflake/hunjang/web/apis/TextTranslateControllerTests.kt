package com.clouflake.hunjang.web.apis

import com.clouflake.hunjang.domain.application.GptService
import com.clouflake.hunjang.domain.application.impl.GptServiceImpl
import com.clouflake.hunjang.web.payload.TransTextPayload
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@ExtendWith(SpringExtension::class)
@WebMvcTest(TextTranslateController::class)
class TextTranslateControllerTests {
  @Autowired
  lateinit var service:GptService

  @Autowired
  lateinit var mvc:MockMvc

  @TestConfiguration
  class MockConfiguration {
    @Bean
    fun gptService(): GptService {
      return GptServiceImpl()
    }
  }

  @Test
  fun initObject_shouldSuccess() {
    assertNotNull(service)
    assertNotNull(mvc)
  }

  @Test
  fun txtTranslate_shouldSuccess() {
    val payload = TransTextPayload("I would like to go. If I cannot fish with you. I would like to serve in some way.")
    val mapper = ObjectMapper()
    val reqBody = mapper.writeValueAsString(payload)
    mvc.perform(
      post("/api/transText")
        .contentType(MediaType.APPLICATION_JSON)
        .content(reqBody))
      .andExpect(status().`is`(200))
      .andExpect(jsonPath("\$.response").isNotEmpty)
  }

  @Test
  fun wordTranslate_shouldSuccess() {
    val payload = TransTextPayload("you")
    val mapper = ObjectMapper()
    val reqBody = mapper.writeValueAsString(payload)
    mvc.perform(
      post("/api/transWord")
        .contentType(MediaType.APPLICATION_JSON)
        .content(reqBody))
      .andExpect(status().`is`(200))
      .andExpect(jsonPath("\$.response").isNotEmpty)
  }
}