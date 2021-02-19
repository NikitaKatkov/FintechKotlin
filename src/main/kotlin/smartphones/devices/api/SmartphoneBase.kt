package smartphones.devices.api

import smartphones.services.CameraService
import smartphones.services.ShortMessageService

abstract class SmartphoneBase: Smartphone {
    protected open val smsService = ShortMessageService()
    protected open val cameraService = CameraService(2)

    override fun receiveMessage(): String =
        smsService.receiveMessage()

    override fun takePicture(): ByteArray =
        cameraService.takePicture()
}