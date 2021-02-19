package smartphones.devices.api

interface Smartphone {
    fun receiveMessage(): String
    fun takePicture(): ByteArray
    fun playGame(name: String)
}