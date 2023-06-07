package com.clouflake.hunjang.domain.application.impl

import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.logging.LogLevel
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.LoggingConfig
import com.aallam.openai.client.OpenAI
import com.clouflake.hunjang.domain.application.GptService
import io.github.cdimascio.dotenv.dotenv
import kotlinx.coroutines.runBlocking

class GptServiceImpl: GptService {
  @OptIn(BetaOpenAI::class)
  override fun requestToGpt(command: RequestCommand): String {
    var responseString = ""

    runBlocking {
      val env = dotenv()
      val apiKey = env["api-key"]
      val token = requireNotNull(apiKey) { "OPENAI_API_KEY environment variable must be set." }
      val openAI = OpenAI(token = token, logging = LoggingConfig(LogLevel.All))
      val chatCompletionRequest = ChatCompletionRequest(
        model = ModelId("gpt-3.5-turbo"),
        messages = listOf(
          ChatMessage(
            role = ChatRole.System,
            content = command.role
          ),
          ChatMessage(
            role = ChatRole.User,
            content = command.prompt
          )
        )
      )
      openAI.chatCompletion(chatCompletionRequest).choices.forEach {
        choice -> responseString += choice.message!!.content
      }
    }
    return responseString
  }
}