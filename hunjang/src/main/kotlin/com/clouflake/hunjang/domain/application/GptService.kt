package com.clouflake.hunjang.domain.application

import com.clouflake.hunjang.domain.application.commands.RequestCommand

interface GptService {
  fun requestToGpt(command: RequestCommand): String
}