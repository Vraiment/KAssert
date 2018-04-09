package com.vraiment.kassert.iterable

import com.vraiment.kassert.tests.EMPTY_LIST
import com.vraiment.kassert.tests.LIST_WITH_MIXED_VALUES
import com.vraiment.kassert.tests.LIST_WITH_ONLY_NON_NULL_VALUES
import com.vraiment.kassert.tests.LIST_WITH_ONLY_NULL_VALUES
import com.vraiment.kassert.tests.failTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AssertAllNullTests {
    @Test
    fun `test assertAllNull with an empty list`() {
        if (EMPTY_LIST.assertAllNull() !== EMPTY_LIST) {
            failTest("Should return the same object")
        }
    }

    @Test
    fun `test assertAllNull with a non empty list with only null values`() {
        if (LIST_WITH_ONLY_NULL_VALUES.assertAllNull() !== LIST_WITH_ONLY_NULL_VALUES) {
            failTest("Should return the same object")
        }
    }

    @Test
    fun `test assertAllNull with a non empty list with mixed (null and non null) values`() {
        assertThrows<AssertionError> {
            LIST_WITH_MIXED_VALUES.assertAllNull()
        }
    }

    @Test
    fun `test assertAllNull with a non empty list with all non null values`() {
        assertThrows<AssertionError> {
            LIST_WITH_ONLY_NON_NULL_VALUES.assertAllNull()
        }
    }
}
