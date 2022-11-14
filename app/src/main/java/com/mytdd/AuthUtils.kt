package com.mytdd

fun userAuthentication(email: String, password: String): Boolean {
    if (email == "aaa@gmail.com" && password == "1234"){
        return true
    }
    return false
}

fun userAuthenticationTDD(email: String?, password: String?): AuthEvent {
    if (email == null && password == null) throw AuthException(AuthEvent.NULL_FORM)
    if (email == null) throw AuthException(AuthEvent.NULL_EMAIL)
    if (password == null) throw AuthException(AuthEvent.NULL_PASSWORD)

    if (email.isEmpty() && password.isEmpty()) return AuthEvent.EMPTY_FORM
    if (email.isEmpty()) return AuthEvent.EMPTY_EMAIL
    if (password.isEmpty()) return AuthEvent.EMPTY_PASSWORD

    if (password.length != 4) return AuthEvent.LENGTH_PASSWORD
    else {
        val passwordNumeric = password.toIntOrNull()

        return if (!isEmailValid(email) && (passwordNumeric == null)) AuthEvent.INVALID_USER
        else if (!isEmailValid(email)) AuthEvent.INVALID_EMAIL
        else if (passwordNumeric == null) AuthEvent.INVALID_PASSWORD
        else {
            return if (email == "aaa@gmail.com" && password == "1234") AuthEvent.USER_EXIST
            else AuthEvent.NOT_USER_EXIST
        }
    }
}

fun isEmailValid(email: String): Boolean {
    val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return EMAIL_REGEX.toRegex().matches(email);
}