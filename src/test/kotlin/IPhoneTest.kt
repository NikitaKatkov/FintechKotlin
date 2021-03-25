import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class IPhoneTest {

    @Test
    fun updateToCorrectIosVersion() {
        val iPhone = IPhone()
        iPhone.updateOs(11)
        assertEquals(11, iPhone.iosVersion)
    }

    @Test
    fun updateToIncorrectIosVersion() {
        val thrown = assertThrows(IllegalArgumentException::class.java) { IPhone().updateOs(9) }
        assertEquals("New OS version should be greater or equal to the installed one", thrown.message)
    }
}