package smartphones.services

import kotlin.random.Random

/**
 * Dummy class that is intended to be used as any service backend/implementation
 */
open class DummyDataGenerator {
    private fun generateInteger(): Int = Random.nextInt(0, 100)
    protected fun generateString(): String = buildString {
        (1..Random.nextInt(2, 20)).forEach(this::append)
    }
    protected fun generateBytes(): ByteArray = Random.Default.nextBytes(generateInteger())
}