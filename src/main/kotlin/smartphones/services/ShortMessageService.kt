package smartphones.services

open class ShortMessageService : DummyDataGenerator() {
    open fun receiveMessage(): String {
        val receivedMessage = generateString()
        println("Received SMS with text: $receivedMessage")
        return receivedMessage
    }
}