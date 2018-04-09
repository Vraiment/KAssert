package com.vraiment.kassert.iterable

import com.vraiment.kassert.common.fail

/**
 * Verifies that all the values in the [Iterable] object are null, fails otherwise.
 *
 * @return The [Iterable] itself.
 */
inline fun <reified T, C : Iterable<T>> C.assertAllNull(): C = assertAllNull("A value in the iterable is not null")

/**
 * Verifies that all the values in the [Iterable] object are null, fails with the given message otherwise.
 *
 * @param message The message that will be contained in the error.
 *
 * @return The [Iterable] itself.
 */
inline fun <reified T, C : Iterable<T?>> C.assertAllNull(message: String): C {
    forEach {
        if (it != null) {
            fail(message)
        }
    }

    return this
}

/**
 * Verifies that all the values in the [Iterable] object are not null, fails otherwise.
 *
 * @return The [Iterable] itself.
 */
inline fun <reified T, C : Iterable<T?>> C.assertAllNotNull(): Iterable<T> =
    assertAllNotNull("A value in the iterable is null")

/**
 * Verifies that all the values in the [Iterable] object are not null, fails with the given message otherwise.
 *
 * @param message The message that will be contained in the error.
 *
 * @return The [Iterable] itself.
 */
inline fun <reified T, C : Iterable<T?>> C.assertAllNotNull(message: String): Iterable<T> {
    forEach {
        if (it == null) {
            fail(message)
        }
    }

    @Suppress("unchecked_cast")
    return this as Iterable<T>
}

/**
 * Verifies that the given predicate is valid for all of the values in the [Iterable], fails otherwise.
 *
 * @param predicate The predicate that will be used to check the contents of the iterable.
 *
 * @return The [Iterable] itself.
 */
inline fun <reified T, C : Iterable<T>> C.assertAll(predicate: (T) -> Boolean): C =
    assertAll("The predicated returned false for a value in the iterable", predicate)

/**
 * Verifies that the given predicate is valid for all of the values in the [Iterable], fails with the given message otherwise.
 *
 * @param message The message that will be contained in the error.
 * @param predicate The predicate that will be used to check the contents of the iterable.
 *
 * @return The [Iterable] itself.
 */
inline fun <reified T, C : Iterable<T>> C.assertAll(message: String, predicate: (T) -> Boolean): C {
    forEach {
        if (!predicate(it)) {
            fail(message)
        }
    }

    return this
}

/**
 * Verifies that the given predicate is valid for any of the values in the [Iterable], fails otherwise.
 *
 * @param predicate The predicate that will be used to check the contents of the iterable.
 *
 * @return The [Iterable] itself.
 */
inline fun <reified T, C : Iterable<T>> C.assertAny(predicate: (T) -> Boolean): C =
    assertAny("The predicate returned false for all values in the iterable", predicate)

/**
 * Verifies that the given predicate is valid for any of the values in the [Iterable], fails with the given message otherwise.
 *
 * @param message The message that will be contained in the error.
 * @param predicate The predicate that will be used to check the contents of the iterable.
 *
 * @return The [Iterable] itself.
 */
inline fun <reified T, C : Iterable<T>> C.assertAny(message: String, predicate: (T) -> Boolean): C {
    forEach {
        if (predicate(it)) {
            return this
        }
    }

    if (!any()) {
        return this
    } else {
        fail(message)
    }
}

/**
 * Verifies that the given predicate is valid for none of the values in the [Iterable], fails otherwise.
 *
 * @param predicate The predicate that will be used to check the contents of the iterable.
 *
 * @return The [Iterable] itself.
 */
inline fun <reified T, C : Iterable<T>> C.assertNone(predicate: (T) -> Boolean): C =
    assertNone("The predicate returned true for a value in the iterable", predicate)

/**
 * Verifies that the given predicate is valid for none of the values in the [Iterable], fails with the given message otherwise.
 *
 * @param message The message that will be contained in the error.
 * @param predicate The predicate that will be used to check the contents of the iterable.
 *
 * @return The [Iterable] itself.
 */
inline fun <reified T, C : Iterable<T>> C.assertNone(message: String, predicate: (T) -> Boolean): C {
    forEach {
        if (predicate(it)) {
            fail(message)
        }
    }

    return this
}
