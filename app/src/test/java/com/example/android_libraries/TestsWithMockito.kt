package com.example.android_libraries

import com.example.android_libraries.ui.SignInScreen.SignInActivity
import com.example.android_libraries.ui.SignInScreen.SignInPresenter
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito.*


class TestsWithMockito {
    val mockActivity = mock(SignInActivity::class.java)
    val mockPresenter = mock(SignInPresenter::class.java)

    @Test
    fun checkPresenter_isAttachedOneTime() {
        mockPresenter.onAttach(mockActivity)
        verify(mockPresenter, times(1)).onAttach(mockActivity)
    }

    @Test
    fun checkPresenter_isConfirmed() {
        mockPresenter.onConfirm(anyString(), anyString())
        verify(mockPresenter).onConfirm(Matchers.anyString(), Matchers.anyString())
    }

    @Test
    fun checkPresenter_isRestored() {
        `when`(mockPresenter.isRestored).thenReturn(true)
        assertEquals(true, mockPresenter.isRestored)
    }

    @Test
    fun checkPresenter_isConfirmedArgumentsNotNull() {
        `when`(mockPresenter.checkMethod("login", "password")).thenReturn(true)
        assertNotEquals(null,mockPresenter.checkMethod("login", "password"))
    }

}