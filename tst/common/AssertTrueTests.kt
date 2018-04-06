package com.vraiment.kassert.common

import com.vraiment.kassert.tests.NON_NULL_VALUE
import com.vraiment.kassert.tests.NULL_VALUE
import com.vraiment.kassert.tests.failTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AssertTrueTests {
    @Test
    fun `test "assertTrue" with a null value and a predicate returning true`() {
        NULL_VALUE.assertTrue {
            if (it !== NULL_VALUE) {
                failTest("A different object was passed to the lambda")
            }

            true
        }
    }

    @Test
    fun `test "assertTrue" with a non null value and a predicate returning true`() {
        NON_NULL_VALUE.assertTrue {
            if (it !== NON_NULL_VALUE) {
                failTest("A different object was passed to the lambda")
            }

            true
        }
    }

    @Test
    fun `test "assertTrue" with a null value and a predicate returning false`() {
        assertThrows<AssertionError> {
            NULL_VALUE.assertTrue {
                if (it !== NULL_VALUE) {
                    failTest("A different object was passed to the lambda")
                }

                false
            }
        }
    }

    @Test
    fun `test "assertTrue" with a non null value and a predicate returning false`() {
        assertThrows<AssertionError> {
            NON_NULL_VALUE.assertTrue {
                if (it !== NON_NULL_VALUE) {
                    failTest("A different object was passed to the lambda")
                }

                false
            }
        }
    }
}
