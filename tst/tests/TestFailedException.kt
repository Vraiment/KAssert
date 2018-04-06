package com.vraiment.kassert.tests

/**
 * Convenience method to throw a new [TestFailedException] with null message.
 */
fun failTest():Nothing = throw TestFailedException()

/**
 * Convenience method to throw a new [TestFailedException] with the given message.
 *
 * @param message The detail message on why the test failed.
 */
fun failTest(message: String):Nothing = throw TestFailedException(message)

/**
 * Convenience method to throw a new [TestFailedException] with the given message and cause.
 *
 * @param message The detail message on why the test failed.
 * @param cause The cause of why the test failed.
 */
fun failTest(message: String, cause: Throwable):Nothing = throw TestFailedException(message, cause)

/**
 * Convenience method to throw a new [TestFailedException] with the given cause.
 *
 * @param cause The cause of why the test failed.
 */
fun failTest(cause: Throwable):Nothing = throw TestFailedException(cause)

/**
 * Custom exception class to prevent clashes with the [kotlin.AssertionError] exception as the tests will be throwing these.
 */
class TestFailedException : Exception {
    /**
     * Constructs a new [TestFailedException] with null message.
     */
    constructor() : super()

    /**
     * Constructs a new [TestFailedException] with the given message.
     *
     * @param message The detail message on why the test failed.
     */
    constructor(message: String) : super(message)

    /**
     * Constructs a new [TestFailedException] with the given message and cause.
     *
     * @param message The detail message on why the test failed.
     * @param cause The cause of why the test failed.
     */
    constructor(message: String, cause: Throwable) : super(message, cause)

    /**
     * Constructs a new [TestFailedException] with the given cause.
     *
     * @param cause The cause of why the test failed.
     */
    constructor(cause: Throwable) : super(cause)
}
