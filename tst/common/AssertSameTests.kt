package com.vraiment.kassert.common

import com.vraiment.kassert.tests.NON_NULL_VALUE
import com.vraiment.kassert.tests.NULL_VALUE
import com.vraiment.kassert.tests.OTHER_NON_NULL_VALUE
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AssertSameTests {
    @Test
    fun `test "assertSame" with a null value an null`() {
        NULL_VALUE.assertSame { null }
    }

    @Test
    fun `test "assertSame" with a null value and not null`() {
        assertThrows<AssertionError> {
            NULL_VALUE.assertSame { NON_NULL_VALUE }
        }
    }

    @Test
    fun `test "assertSame" with a non null value and null`() {
        assertThrows<AssertionError> {
            NON_NULL_VALUE.assertSame { null }
        }
    }

    @Test
    fun `test "assertSame" with a non null value and the same value`() {
        assertThrows<AssertionError> {
            NON_NULL_VALUE.assertSame { NON_NULL_VALUE.copy() }
        }
    }

    @Test
    fun `test "assertSame" with a non null value and the same object`() {
        NON_NULL_VALUE.assertSame { NON_NULL_VALUE }
    }

    @Test
    fun `test "assertSame" with a non null value and the other object`() {
        assertThrows<AssertionError> {
            NON_NULL_VALUE.assertSame { OTHER_NON_NULL_VALUE }
        }
    }
}
