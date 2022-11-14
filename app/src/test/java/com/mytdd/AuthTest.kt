package com.mytdd

import org.junit.Assert.*
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

    /**----------------------------------- TDD -----------------------------------**/

    /*@Test
    fun login_nullEmail_returnsFalse(){
        val isAtuhenticated = userAuthenticationTDD(null, "1234")
        assertFalse(isAtuhenticated)
    }
    @Test
    fun login_nullPassword_returnsFalse(){
        val isAtuhenticated = userAuthenticationTDD("aaa@gmail.com", null)
        assertFalse(isAtuhenticated)
    }*/

    // given - when - then

    @Test
    fun loginUser_correctData_returnsSuccessEvent(){
        val isAtuhenticated = userAuthenticationTDD("aaa@gmail.com", "1234")
        assertEquals(AuthEvent.USER_EXIST, isAtuhenticated)
    }
}