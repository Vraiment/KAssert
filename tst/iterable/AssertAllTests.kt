package com.vraiment.kassert.iterable

import com.vraiment.kassert.tests.EMPTY_LIST
import com.vraiment.kassert.tests.LIST_WITH_MIXED_VALUES
import com.vraiment.kassert.tests.failTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AssertAllTests {
    @Test
    fun `test assertAll with an empty list`() {
        if (EMPTY_LIST.assertAll { false } !== EMPTY_LIST) {
            failTest("Should return the same object")
        }
    }

    @Test
    fun `test assertAll with a predicate that returns true for of the all members of the iterable`() {
        if (LIST_WITH_MIXED_VALUES.assertAll { true } !== LIST_WITH_MIXED_VALUES) {
            failTest("Should return the same object")
        }
    }

    @Test
    fun `test assertAll with a predicate that returns false for all the members of the iterable`() {
        assertThrows<AssertionError> { LIST_WITH_MIXED_VALUES.assertAll { false } }
    }

    @Test
    fun `test assertAll with a predicate that returns true for some of the members of the iterable`() {
        assertThrows<AssertionError> { LIST_WITH_MIXED_VALUES.assertAll { it != null } }
    }
}
