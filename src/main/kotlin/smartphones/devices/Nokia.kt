package smartphones.devices

import smartphones.devices.api.SmartphoneBase

class Nokia : SmartphoneBase() {
    override fun playGame(name: String) {
        println("Ooof, too old phone to run games on..")
    }

    fun playMusic() {
        println("Playing music for 20 hours - nowadays smartphone batteries do not last that log, do they? :)")
    }
}