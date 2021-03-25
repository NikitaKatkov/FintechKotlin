import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MacBookTest {

    @Test
    fun testMacBookDsl() {
        val macBook = mockk<MacBook> {
            every { ssdSize }.returns(-1)
            every { ramSize }.returns(-1)
            every { screenSize }.returns(-1)
            every { hasTouchBar }.returns(true)
            every { hasArmProcessor }.returns(true)
            every { supportsIphoneApps(true) }.returns(false)
            every { supportsIphoneApps(false) }.returns(true)
        }

        assertEquals(-1, macBook.ssdSize)
        assertEquals(-1, macBook.ramSize)
        assertEquals(-1, macBook.screenSize)
        assertTrue(macBook.hasArmProcessor)
        assertTrue(macBook.hasTouchBar)
        assertFalse(macBook.supportsIphoneApps(true))
        assertTrue(macBook.supportsIphoneApps(false))
    }
}