package com.clouflake.hunjang.web.results

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.Assert

object Result {
  fun created(): ResponseEntity<ApiResult> {
    return ResponseEntity.status(201).build()
  }

  fun ok(payload:ApiResult): ResponseEntity<ApiResult> {
    Assert.notNull(payload, "Parameter `payload` must not be null")
    return ResponseEntity.ok(payload)
  }

  fun failure(message:String):ResponseEntity<ApiResult> {
    return ResponseEntity.badRequest().body(ApiResult.createApiResult(message))
  }

  fun serverError(message:String, errorReferenceCode:String):ResponseEntity<ApiResult> {
    return ResponseEntity
      .status(HttpStatus.INTERNAL_SERVER_ERROR)
      .body(ApiResult.createErrorApiResult(message, errorReferenceCode))
  }

  fun notFound():ResponseEntity<ApiResult> {
    return ResponseEntity.notFound().build()
  }

  fun unauthenticated():ResponseEntity<ApiResult> {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
  }

  fun forbidden(): ResponseEntity<ApiResult> {
    return ResponseEntity.status(HttpStatus.FORBIDDEN).build()
  }
}
