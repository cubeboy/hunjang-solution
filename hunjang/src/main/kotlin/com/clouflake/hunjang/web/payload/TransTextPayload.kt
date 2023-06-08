package com.clouflake.hunjang.web.payload

import jakarta.validation.constraints.Size

class TransTextPayload(
    @field:Size(min = 2, message = "Prompt Text Must be more then 10 character")
    val promptText:String
)