package com.clouflake.hunjang.web.payload

import jakarta.validation.Validation
import jakarta.validation.Validator
import jakarta.validation.ValidatorFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TransTextPayloadTest {
  private var validator: Validator? = null

  @BeforeEach
  fun setup() {
    val factory: ValidatorFactory = Validation.buildDefaultValidatorFactory()
    validator = factory.validator
  }

  @Test
  fun validate_payloadWithInvalidText_shouldFail() {
    val payload = TransTextPayload("ShortText")
    val violations = validator!!.validate(payload)
    assertEquals(1, violations.size)
  }


  @Test
  fun validate_payload_shouldSuccess() {
    val payload = TransTextPayload("This is Success Message.")
    val violations = validator!!.validate(payload)
    assertEquals(0, violations.size)
  }
}