package smartphones.devices

import smartphones.devices.api.SmartphoneBase
import smartphones.services.CameraService
import smartphones.services.ios.AppStoreService
import smartphones.services.ios.IMessageService

class IPhone : SmartphoneBase() {
    private val iMessageService = IMessageService()
    private val appStoreService = AppStoreService()
    override val cameraService = CameraService(12)

    override fun receiveMessage(): String =
        iMessageService.receiveMessage()

    override fun playGame(name: String) =
        appStoreService.installAndRunGame(name)

    fun unlockScreen() {
        println("Using faceId technology to unlock the screen")
    }
}