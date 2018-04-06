package com.vraiment.kassert.common

import com.vraiment.kassert.tests.NON_NULL_VALUE
import com.vraiment.kassert.tests.NULL_VALUE
import com.vraiment.kassert.tests.OTHER_NON_NULL_VALUE
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AssertEqualsTests {
    @Test
    fun `test "assertEqualsTo" with a null value and null`() {
        NULL_VALUE.assertEqualsTo { null }
    }

    @Test
    fun `test "assertEqualsTo" with a null value and not null`() {
        assertThrows<AssertionError> {
            NULL_VALUE.assertEqualsTo { NON_NULL_VALUE }
        }
    }

    @Test
    fun `test "assertEqualsTo" with a non null value and null`() {
        assertThrows<AssertionError> {
            NON_NULL_VALUE.assertEqualsTo { null }
        }
    }

    @Test
    fun `test "assertEqualsTo" with a non null value and the same value`() {
        NON_NULL_VALUE.assertEqualsTo { NON_NULL_VALUE.copy() }
    }

    @Test
    fun `test "assertEqualsTo" with a non null value and the same object`() {
        NON_NULL_VALUE.assertEqualsTo { NON_NULL_VALUE }
    }

    @Test
    fun `test "assertEqualsTo" with a non null value and the other object`() {
        assertThrows<AssertionError> {
            NON_NULL_VALUE.assertEqualsTo { OTHER_NON_NULL_VALUE }
        }
    }
}
