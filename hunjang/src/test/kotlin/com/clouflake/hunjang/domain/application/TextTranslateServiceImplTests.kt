package com.clouflake.hunjang.domain.application

import com.clouflake.hunjang.domain.application.impl.GptServiceImpl
import com.clouflake.hunjang.domain.application.commands.RequestCommand
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TextTranslateServiceImplTests {
  val service = GptServiceImpl()
  @Test
  fun textTranslate_shouldSuccess() {
    val command = RequestCommand(
        "당신은 영어 문장을 한국어 문장으로 해석하고 영어 문법을 설명 해 주는 선생님 입니다. 다음 문장을 해석하고 문장 구조를 분석해서 문법을 설명해 주세요.",
        "The sail was patched with flour sacks and, furled, it looked like the flag of permanent defeat.")

    val result = service.requestToGpt(command)
    assertNotNull(result)
    assertTrue(result.length > 0)
  }
}
