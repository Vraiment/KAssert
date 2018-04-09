package com.vraiment.kassert.iterable

import com.vraiment.kassert.tests.EMPTY_LIST
import com.vraiment.kassert.tests.LIST_WITH_MIXED_VALUES
import com.vraiment.kassert.tests.failTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AssertNoneTests {
    @Test
    fun `test assertNone with an empty list`() {
        if (EMPTY_LIST.assertNone { false } !== EMPTY_LIST) {
            failTest("Should return the same object")
        }
    }

    @Test
    fun `test assertNone with a predicate that returns true for all members of the iterable`() {
        assertThrows<AssertionError> { LIST_WITH_MIXED_VALUES.assertNone { true } }
    }

    @Test
    fun `test assertNone with a predicate that returns false for all the members of the iterable`() {
        if (LIST_WITH_MIXED_VALUES.assertNone { false } !== LIST_WITH_MIXED_VALUES) {
            failTest("Should return the same object")
        }
    }

    @Test
    fun `test assertNone with a predicate that returns true for some of the members of the iterable`() {
        assertThrows<AssertionError> { LIST_WITH_MIXED_VALUES.assertNone { it != null } }
    }
}
