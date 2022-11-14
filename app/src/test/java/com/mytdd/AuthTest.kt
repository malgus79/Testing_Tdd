package com.mytdd

import org.junit.Assert.*
import org.junit.Ignore
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
    fun login_completeFrom_existUser_returnsSuccessEvent(){
        val isAtuhenticated = userAuthenticationTDD("aaa@gmail.com", "1234")
        assertEquals(AuthEvent.USER_EXIST, isAtuhenticated)
    }
    @Test
    fun login_completeForm_notExistUser_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("zzz@gmail.com", "1234")
        assertEquals(AuthEvent.NOT_USER_EXIST, isAtuhenticated)
    }
    @Test
    fun login_emptyEmail_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("", "1234")
        assertEquals(AuthEvent.EMPTY_EMAIL, isAtuhenticated)
    }
    @Test
    fun login_emptyPassword_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("aaa@gmail.com", "")
        assertEquals(AuthEvent.EMPTY_PASSWORD, isAtuhenticated)
    }
    @Test
    fun login_emptyForm_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("", "")
        assertEquals(AuthEvent.EMPTY_FORM, isAtuhenticated)
    }
    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("aaa@gmailcom", "1234")
        assertEquals(AuthEvent.INVALID_EMAIL, isAtuhenticated)
    }
    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("aaa@gmail.com", "123x")
        assertEquals(AuthEvent.INVALID_PASSWORD, isAtuhenticated)
    }
    @Test
    fun login_completeForm_invalidUser_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("aaa@gmailcom", "123x")
        assertEquals(AuthEvent.INVALID_USER, isAtuhenticated)
    }
    /*@Test(expected = NullPointerException::class)
    fun login_nullEmail_returnsException() {
        val isAtuhenticated = userAuthenticationTDD(null, "1234")
        assertEquals(AuthEvent.NULL_EMAIL, isAtuhenticated)
    }*/
    @Test(expected = AuthException::class)
    fun login_nullEmail_returnsException2() {
        val isAtuhenticated = userAuthenticationTDD(null, "1234")
        assertEquals(AuthEvent.NULL_EMAIL, isAtuhenticated)
    }
    @Test
    fun login_nullPassword_returnsException() {
        assertThrows(AuthException::class.java) {
            print(userAuthenticationTDD("aaa@gmail.com", null))  //code causing the exception
        }
    }
    @Test
    fun login_nullForm_returnsException() {
        try {
            val result = userAuthenticationTDD(null, null)
            assertEquals(AuthEvent.NULL_FORM, result)
        } catch (e: Exception) {
            (e as? AuthException)?.let {
                assertEquals(AuthEvent.NULL_FORM, it.authEvent)
            }
        }
    }
    @Ignore("Falta definir un requisito del cliente...")  //is a temporary tag
    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("aaa@gmailcom", "12")
        assertEquals(AuthEvent.LENGTH_PASSWORD, isAtuhenticated)
    }
}