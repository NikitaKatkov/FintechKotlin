import smartphones.devices.IPhone
import smartphones.devices.Nokia
import smartphones.devices.Pixel
import smartphones.devices.api.Smartphone

fun main() {
    val iPhone = IPhone()
    val pixel = Pixel()
    val nokia = Nokia()

    // work with methods from interface
    testMethodsDeclaredInInterface(iPhone)
    testMethodsDeclaredInInterface(pixel)
    testMethodsDeclaredInInterface(nokia)

    // work with unique functionality of each phone
    iPhone.unlockScreen()
    pixel.doSomeAndroidStuff()
    nokia.playMusic()
}

private fun testMethodsDeclaredInInterface(smartphone: Smartphone) {
    println("Working with smartphone '${smartphone::class.java}'")
    smartphone.receiveMessage()
    smartphone.playGame("flappy bird")
    smartphone.takePicture()
    println()
}