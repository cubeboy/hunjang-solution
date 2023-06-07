package com.clouflake.hunjang.domain.application

import com.clouflake.hunjang.domain.application.impl.RequestCommand

interface GptService {
  fun requestToGpt(command: RequestCommand): String
}