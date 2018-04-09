package com.vraiment.kassert.tests

data class TestData(val value: String)

val NULL_VALUE: TestData? = null

val NON_NULL_VALUE = TestData("NON_NULL_VALUE")

val OTHER_NON_NULL_VALUE = TestData("OTHER_NON_NULL_VALUE")

val EMPTY_LIST = listOf<TestData>()

val LIST_WITH_ONLY_NULL_VALUES = listOf(NULL_VALUE, NULL_VALUE, NULL_VALUE)

val LIST_WITH_MIXED_VALUES = listOf(NON_NULL_VALUE, NULL_VALUE, OTHER_NON_NULL_VALUE)

val LIST_WITH_ONLY_NON_NULL_VALUES = listOf(NON_NULL_VALUE, OTHER_NON_NULL_VALUE)
