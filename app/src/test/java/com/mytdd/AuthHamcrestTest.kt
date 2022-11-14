package com.mytdd

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

class AuthHamcrestTest {
    //given-when-then

    //Alt + 96 -> ` (backticks)

    @Test
    fun loginUser_correctData_returnsSuccessEvent() {
        val result = userAuthenticationTDD("aaa@gmail.com", "1234")
        assertThat(AuthEvent.USER_EXIST, `is`(result))
    }

    @Test
    fun loginUser_wrongData_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("zzz@gmail.com", "1234")
        Assert.assertEquals(AuthEvent.NOT_USER_EXIST, isAtuhenticated)
    }

    @Test
    fun loginUser_emptyEmail_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("", "1234")
        Assert.assertEquals(AuthEvent.EMPTY_EMAIL, isAtuhenticated)
    }

    @Test
    fun loginUser_emptyPassword_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("aaa@gmail.com", "")
        Assert.assertEquals(AuthEvent.EMPTY_PASSWORD, isAtuhenticated)
    }

    @Test
    fun loginUser_emptyForm_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("", "")
        Assert.assertEquals(AuthEvent.EMPTY_FORM, isAtuhenticated)
    }

    @Test
    fun loginUser_invalidEmail_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("aaa@gmailcom", "1234")
        Assert.assertEquals(AuthEvent.INVALID_EMAIL, isAtuhenticated)
    }

    @Test
    fun loginUser_invalidPassword_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("aaa@gmail.com", "123x")
        Assert.assertEquals(AuthEvent.INVALID_PASSWORD, isAtuhenticated)
    }

    @Test
    fun loginUser_invalidUser_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("aaa@gmailcom", "123x")
        Assert.assertEquals(AuthEvent.INVALID_USER, isAtuhenticated)
    }

    @Test(expected = AuthException::class)
    fun loginUser_nullEmail_returnsException() {
        val isAtuhenticated = userAuthenticationTDD(null, "1234")
        Assert.assertEquals(AuthEvent.NULL_EMAIL, isAtuhenticated)
    }

    @Test
    fun loginUser_nullPassword_returnsException() {
        Assert.assertThrows(AuthException::class.java) {
            print(userAuthenticationTDD("aaa@gmail.com", null))  //code causing the exception
        }
    }

    @Test
    fun loginUser_nullForm_returnsException() {
        try {
            val result = userAuthenticationTDD(null, null)
            Assert.assertEquals(AuthEvent.NULL_FORM, result)
        } catch (e: Exception) {
            (e as? AuthException)?.let {
                Assert.assertEquals(AuthEvent.NULL_FORM, it.authEvent)
            }
        }
    }

    @Ignore("Falta definir un requisito del cliente...")  //is a temporary tag
    @Test
    fun loginUser_errorLengthPassword_returnsFailEvent() {
        val isAtuhenticated = userAuthenticationTDD("aaa@gmailcom", "12")
        Assert.assertEquals(AuthEvent.LENGTH_PASSWORD, isAtuhenticated)
    }
}