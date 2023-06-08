package com.clouflake.hunjang.web.apis

import com.clouflake.hunjang.domain.application.GptService
import com.clouflake.hunjang.domain.application.commands.RequestCommand
import com.clouflake.hunjang.web.payload.TransTextPayload
import com.clouflake.hunjang.web.results.ApiResult
import com.clouflake.hunjang.web.results.Result
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class TextTranslateController(val service:GptService) {
  @PostMapping("/api/transText")
  fun TransText(@Valid @RequestBody payload:TransTextPayload): ResponseEntity<ApiResult> {
    return try {
      val command = RequestCommand(
        "당신은 영어 문장을 한국어 문장으로 해석하고 영어 문법을 설명 해 주는 선생님 입니다. 다음 문장을 해석하고 문장 구조를 분석해서 문법을 설명해 주세요.",
        payload.promptText)
      val response = service.requestToGpt(command)
      val result = ApiResult.createApiResult()
      result.add("response", response)
      Result.ok(result)
    } catch (e: Exception) {
      Result.failure(e.message!!)
    }
  }

  @PostMapping("/api/transWord")
  fun TransWord(@Valid @RequestBody payload:TransTextPayload): ResponseEntity<ApiResult> {
    return try {
      val command = RequestCommand(
        "당신은 영어 단어를 한국어 단어로 해석하고 단어의 뜻을 설명 해 주는 선생님 입니다.\n"
            +" 다음 영어 단어의 뜻을 설명하고 유효한 동의어/유어의/반의어가 있다면 예문과 함께 설명 해 주세요.\n"
            +" 제시 단어는 첫 줄에 대괄호로 표시 해주세요.",
        payload.promptText)
      val response = service.requestToGpt(command)
      val result = ApiResult.createApiResult()
      result.add("response", response)
      Result.ok(result)
    } catch (e: Exception) {
      Result.failure(e.message!!)
    }
  }
}