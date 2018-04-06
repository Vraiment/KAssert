package com.vraiment.kassert.common

import com.vraiment.kassert.tests.NON_NULL_VALUE
import com.vraiment.kassert.tests.NULL_VALUE
import com.vraiment.kassert.tests.OTHER_NON_NULL_VALUE
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AssertNotEqualsTests {
    @Test
    fun `test "assertNotEqualsTo" with a null value an null`() {
        assertThrows<AssertionError> {
            NULL_VALUE.assertNotEqualsTo { null }
        }
    }

    @Test
    fun `test "assertNotEqualsTo" with a null value and not null`() {
        NULL_VALUE.assertNotEqualsTo { NON_NULL_VALUE }
    }

    @Test
    fun `test "assertNotEqualsTo" with a non null value and null`() {
        NON_NULL_VALUE.assertNotEqualsTo { null }
    }

    @Test
    fun `test "assertNotEqualsTo" with a non null value and the same value`() {
        assertThrows<AssertionError> {
            NON_NULL_VALUE.assertNotEqualsTo { NON_NULL_VALUE.copy() }
        }
    }

    @Test
    fun `test "assertNotEqualsTo" with a non null value and the same object`() {
        assertThrows<AssertionError> {
            NON_NULL_VALUE.assertNotEqualsTo { NON_NULL_VALUE }
        }
    }

    @Test
    fun `test "assertNotEqualsTo" with a non null value and the other object`() {
        NON_NULL_VALUE.assertNotEqualsTo { OTHER_NON_NULL_VALUE }
    }
}
