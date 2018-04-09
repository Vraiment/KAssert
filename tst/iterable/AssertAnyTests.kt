package com.vraiment.kassert.iterable

import com.vraiment.kassert.tests.EMPTY_LIST
import com.vraiment.kassert.tests.LIST_WITH_MIXED_VALUES
import com.vraiment.kassert.tests.failTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AssertAnyTests {
    @Test
    fun `test assertAny with an empty list`() {
        if (EMPTY_LIST.assertAny { false } !== EMPTY_LIST) {
            failTest("Should return the same object")
        }
    }

    @Test
    fun `test assertAny with a predicate that returns true for all members of the iterable`() {
        if (LIST_WITH_MIXED_VALUES.assertAny { true } !== LIST_WITH_MIXED_VALUES) {
            failTest("Should return the same object")
        }
    }

    @Test
    fun `test assertAny with a predicate that returns false for all the members of the iterable`() {
        assertThrows<AssertionError> { LIST_WITH_MIXED_VALUES.assertAny { false } }
    }

    @Test
    fun `test assertAny with a predicate that returns true for some of the members of the iterable`() {
        if (LIST_WITH_MIXED_VALUES.assertAny { it != null } !== LIST_WITH_MIXED_VALUES) {
            failTest("Should return the same object")
        }
    }
}
