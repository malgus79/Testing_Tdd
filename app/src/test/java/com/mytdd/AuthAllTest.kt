package com.mytdd

import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class AuthAllTest {
    private var email: String? = null
    private var password: String? = null

    @Before
    fun setup(){
        email = "aaa@gmail.com"
        password = "1234"
    }

    @Test
    fun login_completeFrom_existUser_returnsSuccessEvent(){
        val isAtuhenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.USER_EXIST, isAtuhenticated)
    }
    @Test
    fun login_completeForm_notExistUser_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.NOT_USER_EXIST, isAtuhenticated)
    }
    @Test
    fun login_emptyEmail_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.EMPTY_EMAIL, isAtuhenticated)
    }
    @Test
    fun login_emptyPassword_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.EMPTY_PASSWORD, isAtuhenticated)
    }
    @Test
    fun login_emptyForm_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.EMPTY_FORM, isAtuhenticated)
    }
    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.INVALID_EMAIL, isAtuhenticated)
    }
    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.INVALID_PASSWORD, isAtuhenticated)
    }
    @Test
    fun login_completeForm_invalidUser_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.INVALID_USER, isAtuhenticated)
    }
    /*@Test(expected = NullPointerException::class)
    fun login_nullEmail_returnsException() {
        val isAtuhenticated = userAuthenticationTDD(null, "1234")
        assertEquals(AuthEvent.NULL_EMAIL, isAtuhenticated)
    }*/
    @Test(expected = AuthException::class)
    fun login_nullEmail_returnsException2() {
        try {
            val result = userAuthenticationTDD(email, password)
            Assert.assertEquals(AuthEvent.NULL_EMAIL, result)
        } catch (e: Exception) {
            (e as? AuthException)?.let {
                Assert.assertEquals(AuthEvent.NULL_EMAIL, it.authEvent)
            }
        }
    }
    @Test
    fun login_nullPassword_returnsException() {
        try {
            val result = userAuthenticationTDD(email, password)
            Assert.assertEquals(AuthEvent.NULL_PASSWORD, result)
        } catch (e: Exception) {
            (e as? AuthException)?.let {
                Assert.assertEquals(AuthEvent.NULL_PASSWORD, it.authEvent)
            }
        }
    }
    @Test
    fun login_nullForm_returnsException() {
        try {
            val result = userAuthenticationTDD(email, password)
            Assert.assertEquals(AuthEvent.NULL_FORM, result)
        } catch (e: Exception) {
            (e as? AuthException)?.let {
                Assert.assertEquals(AuthEvent.NULL_FORM, it.authEvent)
            }
        }
    }
    //@Ignore("Falta definir un requisito del cliente...")  //is a temporary tag
    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.LENGTH_PASSWORD, isAtuhenticated)
    }
}