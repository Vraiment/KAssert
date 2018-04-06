package com.vraiment.kassert.tests

data class TestData(val value: String)

val NULL_VALUE: TestData? = null

val NON_NULL_VALUE = TestData("NON_NULL_VALUE")

val OTHER_NON_NULL_VALUE = TestData("OTHER_NON_NULL_VALUE")
