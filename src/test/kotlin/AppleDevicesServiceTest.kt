import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AppleDevicesServiceTest {

    @Test
    fun testMockedService() {
        val service = mockk<AppleDevicesService> {
            every { findDeviceByImei(less(5, false)) }.returns(IPhone())
            every { findDeviceByImei(more(5, true)) }.returns(null)
            every { findAllActivatedDevices() }.returns(listOf(IPhone()))
        }

        for (index in 0..4)
            assertNotNull(service.findDeviceByImei(index))

        assertNull(service.findDeviceByImei(5))
        assertEquals(1, service.findAllActivatedDevices().size)
    }
}