package com.vraiment.kassert.common

/**
 * Fails (throws an AssertionError).
 *
 * @return Nothing.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun fail(): Nothing = throw AssertionError()

/**
 * Fails (throws an AssertionError) with the given message.
 *
 * @param message The message explaining what caused the failure.
 *
 * @return Nothing.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun fail(message: String): Nothing = throw AssertionError(message)

/**
 * Fails (throws an AssertionError) with the given message.
 *
 * @param cause The cause of the failure.
 *
 * @return Nothing.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun fail(cause: Throwable): Nothing = throw AssertionError(cause)

/**
 * Fails (throws an AssertionError) with the given message.
 *
 * @param message The message explaining what caused the failure.
 * @param cause The cause of the failure.
 *
 * @return Nothing.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun fail(message: String, cause: Throwable): Nothing = throw AssertionError(message, cause)

/**
 * Verifies if the given object is null, fails otherwise.
 */
inline fun <reified T> T?.assertNull(): Unit = assertNull("Expected to be null")

/**
 * Verifies if the given object is null, fails with the given message otherwise.
 *
 * @param message The message that will be contained in the error.
 */
inline fun <reified T> T?.assertNull(message: String): Unit {
    if (this != null) {
        throw AssertionError(message)
    }
}

/**
 * Verifies if the given object is not null, fails otherwise.
 *
 * @return The object itself as a not nullable value.
 */
inline fun <reified T> T?.assertNotNull(): T = assertNotNull("Expected to be not null")

/**
 * Verifies if the given object is not null, fails with the given message otherwise.
 *
 * @param message The message that will be contained in the error.
 *
 * @return The object itself as a not nullable value.
 */
inline fun <reified T> T?.assertNotNull(message: String): T =
        this ?: fail(message)

/**
 * Verifies if the given object is equals to the one provided by the given lambda, fails otherwise.
 *
 * The equality is checked using the *==* operator.
 *
 * @param provider The lambda that provides the object that will be compared.
 *
 * @return The object itself.
 */
inline fun <reified T> T.assertEqualsTo(provider: () -> T): T =
        assertEqualsTo("Expected objects to be equal", provider)

/**
 * Verifies if the given object is equals to the one provided by the given lambda,
 * fails with the given message otherwise.
 *
 * The equality is checked using the *==* operator.
 *
 * @param message The message that will be contained in the error.
 * @param provider The lambda that provides the object that will be compared.
 *
 * @return The object itself.
 */
inline fun <reified T> T.assertEqualsTo(message: String, provider: () -> T): T =
        if (this == provider()) { this } else { fail(message) }

/**
 * Verifies if the given object is not equals to the one provided by the given lambda, fails otherwise.
 *
 * The equality is checked using the *!=* operator.
 *
 * @param provider The lambda that provides the object that will be compared.
 *
 * @return The object itself.
 */
inline fun <reified T> T.assertNotEqualsTo(provider: () -> T) =
        assertNotEqualsTo("Expected objects to be not equal", provider)

/**
 * Verifies if the given object is not equals to the one provided by the given lambda,
 * fails with the given message otherwise.
 *
 * The equality is checked using the *!=* operator.
 *
 * @param message The message that will be contained in the error.
 * @param provider The lambda that provides the object that will be compared.
 *
 * @return The object itself.
 */
inline fun <reified T> T.assertNotEqualsTo(message: String, provider: () -> T): T =
        if (this != provider()) { this } else { fail(message) }

/**
 * Verifies if the given object is the same to the one provided by the given lambda, fails otherwise.
 *
 * The comparision is checked using the *===* operator.
 *
 * @param provider The lambda that provides the object that will be compared.
 *
 * @return The object itself.
 */
inline fun <reified T> T.assertSame(provider: () -> T): T =
        assertSame("Expected objects should be the same", provider)

/**
 * Verifies if the given object is the same to the one provided by the given lambda,
 * fails with the given message otherwise.
 *
 * The comparision is checked using the *===* operator.
 *
 * @param message The message that will be contained in the error.
 * @param provider The lambda that provides the object that will be compared.
 *
 * @return The object itself.
 */
inline fun <reified T> T.assertSame(message: String, provider: () -> T): T =
        if (this === provider()) { this } else { fail(message) }

/**
 * Verifies if the given object is not the same to the one provided by the given lambda, fails otherwise.
 *
 * The comparision is checked using the *!==* operator.
 *
 * @param provider The lambda that provides the object that will be compared.
 *
 * @return The object itself.
 */
inline fun <reified T> T.assertNotSame(provider: () -> T): T =
        assertNotSame("Expected objects should not be the same", provider)

/**
 * Verifies if the given object is not the same to the one provided by the given lambda,
 * fails with the given message otherwise.
 *
 * The comparision is checked using the *!==* operator.
 *
 * @param message The message that will be contained in the error.
 * @param provider The lambda that provides the object that will be compared.
 *
 * @return The object itself.
 */
inline fun <reified T> T.assertNotSame(message: String, provider: () -> T): T =
        if (this !== provider()) { this  } else { fail(message) }

/**
 * Verifies if the given predicate is true for the object, fails otherwise.
 *
 * @param predicate The predicate that will be checked.
 *
 * @return The object itself.
 */
inline fun <reified T> T.assertTrue(predicate: (T) -> Boolean): T =
        assertTrue("Expected predicate to be true for the object", predicate)

/**
 * Verifies if the given predicate is true for the object, fails with the given message otherwise.
 *
 * @param message The message that will be contained in the error.
 * @param predicate The predicate that will be checked.
 *
 * @return The object itself.
 */
inline fun <reified T> T.assertTrue(message: String, predicate: (T) -> Boolean): T =
        if (predicate(this)) { this } else { fail(message) }

/**
 * Verifies if the given predicate is false for the object, fails otherwise.
 *
 * @param predicate The predicate that will be checked.
 *
 * @return The object itself.
 */
inline fun <reified T> T.assertFalse(predicate: (T) -> Boolean): T =
        assertFalse("Expected predicate to be false for the object", predicate)

/**
 * Verifies if the given predicate is false for the object, fails with the given message otherwise.
 *
 * @param message The message that will be contained in the error.
 * @param predicate The predicate that will be checked.
 *
 * @return The object itself.
 */
inline fun<reified T> T.assertFalse(message: String, predicate: (T) -> Boolean): T =
        if (!predicate(this)) { this } else { fail(message) }
