package com.vraiment.kassert.common

import com.vraiment.kassert.tests.NON_NULL_VALUE
import com.vraiment.kassert.tests.NULL_VALUE
import com.vraiment.kassert.tests.failTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AssertFalseTests {
    @Test
    fun `test "assertFalse" with a null value and a predicate returning true`() {
        assertThrows<AssertionError> {
            NULL_VALUE.assertFalse {
                if (it !== NULL_VALUE) {
                    failTest("A different object was passed to the lambda")
                }

                true
            }
        }
    }

    @Test
    fun `test "assertFalse" with a non null value and a predicate returning true`() {
        assertThrows<AssertionError> {
            NON_NULL_VALUE.assertFalse {
                if (it !== NON_NULL_VALUE) {
                    failTest("A different object was passed to the lambda")
                }

                true
            }
        }
    }

    @Test
    fun `test "assertFalse" with a null value and a predicate returning false`() {
        NULL_VALUE.assertFalse {
            if (it !== NULL_VALUE) {
                failTest("A different object was passed to the lambda")
            }

            false
        }
    }

    @Test
    fun `test "assertFalse" with a non null value and a predicate returning false`() {
        NON_NULL_VALUE.assertFalse {
            if (it !== NON_NULL_VALUE) {
                failTest("A different object was passed to the lambda")
            }

            false
        }
    }
}
