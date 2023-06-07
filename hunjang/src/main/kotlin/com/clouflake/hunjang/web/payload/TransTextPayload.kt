package com.clouflake.hunjang.web.payload

import jakarta.validation.constraints.Size

class TransTextPayload(
    @field:Size(min = 10, message = "Prompt Text Must be more then 10 cha")
    val promptText:String
)