package smartphones.devices

import smartphones.devices.api.SmartphoneBase
import smartphones.services.CameraService
import smartphones.services.android.GooglePlayService

class Pixel: SmartphoneBase() {
    private val googlePlayService = GooglePlayService()
    override val cameraService = CameraService(10)

    override fun playGame(name: String) =
        googlePlayService.installAndRun(name)

    fun doSomeAndroidStuff() {
        println("Fatal error, reboot is required. Is it because I'm written in kotlin? :)")
    }
}