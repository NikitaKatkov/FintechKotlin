import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AirPodsTest {

    @Test
    fun isPairedWithPhone() {
        assertTrue(AirPods().isPairedWithPhone(12))
        assertFalse(AirPods().isPairedWithPhone(9))
    }

    @Test
    fun getActionIdForUserInput() {
        assertEquals("pause", AirPods().getActionIdForUserInput(AirpodsInputType.TAP))
        assertEquals("next track", AirPods().getActionIdForUserInput(AirpodsInputType.DOUBLE_TAP))
        assertEquals("siri", AirPods().getActionIdForUserInput(AirpodsInputType.PRESS_AND_HOLD))
    }
}