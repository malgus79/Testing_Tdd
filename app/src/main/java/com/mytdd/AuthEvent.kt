package com.mytdd

enum class AuthEvent {
    //success
    USER_EXIST,
    //fail
    NOT_USER_EXIST,
    EMPTY_EMAIL,
    EMPTY_PASSWORD,
    EMPTY_FORM,
    INVALID_EMAIL,
    INVALID_PASSWORD,
    INVALID_USER,
    LENGTH_PASSWORD,
    //exceptions
    NULL_EMAIL,
    NULL_PASSWORD,
    NULL_FORM

}