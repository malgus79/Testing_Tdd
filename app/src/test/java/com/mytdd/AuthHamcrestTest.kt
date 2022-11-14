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
        val result = userAuthenticationTDD("zzz@gmail.com", "1234")
        assertThat(AuthEvent.NOT_USER_EXIST, `is`(result))
    }

    @Test
    fun loginUser_emptyEmail_returnsFailEvent() {
        val result = userAuthenticationTDD("", "1234")
        assertThat(AuthEvent.EMPTY_EMAIL, `is`(result))
    }

    @Test
    fun loginUser_emptyPassword_returnsFailEvent() {
        val result = userAuthenticationTDD("aaa@gmail.com", "")
        assertThat(AuthEvent.EMPTY_PASSWORD, `is`(result))
    }

    @Test
    fun loginUser_emptyForm_returnsFailEvent() {
        val result = userAuthenticationTDD("", "")
        assertThat(AuthEvent.EMPTY_FORM, `is`(result))
    }

    @Test
    fun loginUser_invalidEmail_returnsFailEvent() {
        val result = userAuthenticationTDD("aaa@gmailcom", "1234")
        assertThat(AuthEvent.INVALID_EMAIL, `is`(result))
    }

    @Test
    fun loginUser_invalidPassword_returnsFailEvent() {
        val result = userAuthenticationTDD("aaa@gmail.com", "123x")
        assertThat(AuthEvent.INVALID_PASSWORD, `is`(result))
    }

    @Test
    fun loginUser_invalidUser_returnsFailEvent() {
        val result = userAuthenticationTDD("aaa@gmailcom", "123x")
        assertThat(AuthEvent.INVALID_USER, `is`(result))
    }

    @Test(expected = AuthException::class)
    fun loginUser_nullEmail_returnsException() {
        val result = userAuthenticationTDD(null, "1234")
        assertThat(AuthEvent.NULL_EMAIL, `is`(result))
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
            assertThat(AuthEvent.NULL_FORM, `is`(result))
        } catch (e: Exception) {
            (e as? AuthException)?.let {
                assertThat(AuthEvent.NULL_FORM, `is`(it.authEvent))
            }
        }
    }

    //@Ignore("Falta definir un requisito del cliente...")  //is a temporary tag
    @Test
    fun loginUser_errorLengthPassword_returnsFailEvent() {
        val result = userAuthenticationTDD("aaa@gmailcom", "12")
        assertThat(AuthEvent.LENGTH_PASSWORD, `is`(result))
    }

    @Test
    fun checkNames_differentUsers_match(){
        assertThat("Maria",containsString("a"))
    }

    @Test
    fun checkNames_differentUsers_match2(){
        assertThat("Maria", both(containsString("a")).and(containsString("i")))
    }

    @Test
    fun checkData_emailPassword_noMatch(){
        val email = "aaa@gmail.com"
        val password = "1234"
        assertThat(email, not(`is`(password)))
    }

    @Test
    fun checkExist_newEmail_returnsString(){
        val oldEmail = "aaa@gmail.com"
        val newEmail = "aaa@hotmail.com"
        val emails = arrayOf(oldEmail, newEmail)
        assertThat(emails, hasItemInArray(newEmail))
    }

    @Test
    fun checkDomain_arrayEmails_returnsString(){
        val nextEmail = "mati@hotmail.com"
        val oldEmail = "aaa@gmail.com"
        val newEmail = "aaa@hotmail.com"
        val emails = arrayListOf(oldEmail, newEmail, nextEmail)
        val newEmails = arrayListOf(newEmail, nextEmail)
        //assertThat(emails, everyItem(endsWith("hotmail.com")))  //verificar el dominio de todos los emails, oldEmail no coincide
        assertThat(newEmails, everyItem(endsWith("hotmail.com")))  //verificar el dominio de todos los emails, newEmails contiene 2 emails con mismo dominio
    }
}