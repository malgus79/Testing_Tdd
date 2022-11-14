package com.mytdd

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AuthTest {
    @Test
    fun login_complete_returnsTrue(){
        val isAtuhenticated = userAuthentication("aaa@gmail.com", "1234")
        assertTrue(isAtuhenticated)
    }
    @Test
    fun login_complete_returnsFalse(){
        val isAtuhenticated = userAuthentication("bb@gmail.com", "1234")
        assertFalse(isAtuhenticated)
    }
    @Test
    fun login_emptyEmail_returnsFalse(){
        val isAtuhenticated = userAuthentication("", "1234")
        assertFalse(isAtuhenticated)
    }
}