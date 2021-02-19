package smartphones.services.ios

import smartphones.services.ShortMessageService

class IMessageService: ShortMessageService() {
    override fun receiveMessage(): String {
        val receivedMessage = generateString()
        println("Received message via IMessage app, text: $receivedMessage")
        return receivedMessage
    }
}