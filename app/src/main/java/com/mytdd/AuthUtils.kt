package com.mytdd

fun userAuthentication(email: String, password: String): Boolean {
    if (email == "aaa@gmail.com" && password == "1234"){
        return true
    }
    return false
}

fun userAuthenticationTDD(email: String?, password: String?): Boolean {
    if (email == "aaa@gmail.com" && password == "1234"){
        return true
    }
    return false
}

fun isEmailValid(email: String): Boolean {
    val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return EMAIL_REGEX.toRegex().matches(email);
}