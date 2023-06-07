package com.clouflake.hunjang.web.apis

import com.clouflake.hunjang.domain.application.GptService
import com.clouflake.hunjang.domain.application.commands.RequestCommand
import com.clouflake.hunjang.web.payload.TransTextPayload
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class TextTranslateController(val service:GptService) {
  @PostMapping("/api/transText")
  fun TransText(@Valid @RequestBody payload:TransTextPayload): String {
    return try {
      val command = RequestCommand(
        "당신은 영어 문장을 한국어 문장으로 해석하고 영어 문법을 설명 해 주는 선생님 입니다. 다음 문장을 해석하고 문장 구조를 분석해서 문법을 설명해 주세요.",
        payload.promptText)
      service.requestToGpt(command)
    } catch (e: Exception) {
      throw e
    }
  }
}