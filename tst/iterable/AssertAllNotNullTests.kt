package com.vraiment.kassert.iterable

import com.vraiment.kassert.tests.EMPTY_LIST
import com.vraiment.kassert.tests.LIST_WITH_MIXED_VALUES
import com.vraiment.kassert.tests.LIST_WITH_ONLY_NON_NULL_VALUES
import com.vraiment.kassert.tests.LIST_WITH_ONLY_NULL_VALUES
import com.vraiment.kassert.tests.failTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AssertAllNotNullTests {
    @Test
    fun `test assertAllNotNull with an empty list`() {
        if (EMPTY_LIST.assertAllNotNull() !== EMPTY_LIST) {
            failTest("Should return the same object")
        }
    }

    @Test
    fun `test assertAllNotNull with a non empty list with only null values`() {
        assertThrows<AssertionError> {
            LIST_WITH_ONLY_NULL_VALUES.assertAllNotNull()
        }
    }

    @Test
    fun `test assertAllNotNull with a non empty list with mixed (null and non null) values`() {
        assertThrows<AssertionError> {
            LIST_WITH_MIXED_VALUES.assertAllNotNull()
        }
    }

    @Test
    fun `test assertAllNotNull with a non empty list with all non null values`() {
        if (LIST_WITH_ONLY_NON_NULL_VALUES.assertAllNotNull() !== LIST_WITH_ONLY_NON_NULL_VALUES) {
            failTest("Should return the same object")
        }
    }
}
