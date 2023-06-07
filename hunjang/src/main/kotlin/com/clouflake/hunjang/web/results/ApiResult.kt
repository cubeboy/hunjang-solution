package com.clouflake.hunjang.web.results

import org.springframework.util.Assert

class ApiResult: HashMap<String, Any>() {

  companion object {
    private const val MESSAGE_KEY = "message"
    private const val ERROR_CODE_KEY = "errorReferenceCode"

    fun createApiResult(): ApiResult {
      return ApiResult()
    }

    fun createApiResult(message:String): ApiResult {
      Assert.hasText(message, "Parameter `message` must not be blank")
      val result = ApiResult()
      result[MESSAGE_KEY] = message
      return result
    }

    fun createErrorApiResult(message:String, errorReferenceCode:String): ApiResult {
      Assert.hasText(message, "Parameter `message` must not be blank");
      Assert.hasText(errorReferenceCode, "Parameter `errorReferenceCode` must not be blank");
      val result = ApiResult()
      result[MESSAGE_KEY] = message
      result[ERROR_CODE_KEY] = errorReferenceCode
      return result
    }
  }
  fun add(key:String, value:Any):ApiResult {
    Assert.hasText(key, "Parameter `key` must not be blank");
    Assert.notNull(value, "Parameter `value` must not be null");
    this[key] = value
    return this
  }
}
