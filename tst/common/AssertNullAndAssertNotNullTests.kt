package com.vraiment.kassert.common

import com.vraiment.kassert.tests.NON_NULL_VALUE
import com.vraiment.kassert.tests.NULL_VALUE
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AssertNullAndAssertNotNullTests {
    @Test
    fun `test "assertNull" with null value`() {
        NULL_VALUE.assertNull()
    }

    @Test
    fun `test "assertNull" with non null value`() {
        assertThrows<AssertionError> {
            NON_NULL_VALUE.assertNull()
        }
    }

    @Test
    fun `test "assertNotNull" with null value`() {
        assertThrows<AssertionError> {
            NULL_VALUE.assertNotNull()
        }
    }

    @Test
    fun `test "assertNotNull" with non null value`() {
        NON_NULL_VALUE.assertNotNull()
    }
}
