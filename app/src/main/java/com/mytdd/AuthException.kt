package com.mytdd

class AuthException(val authEvent: AuthEvent, msg: String? = null) : Exception(msg)