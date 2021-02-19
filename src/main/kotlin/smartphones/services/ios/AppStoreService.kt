package smartphones.services.ios

import smartphones.services.DummyDataGenerator

class AppStoreService: DummyDataGenerator() {
    fun installAndRunGame(gameName: String) {
        println("Installing and running game $gameName from app store")
    }
}