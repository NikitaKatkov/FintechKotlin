package smartphones.services.android

import smartphones.services.DummyDataGenerator

class GooglePlayService: DummyDataGenerator() {
    fun installAndRun(name: String) {
        println("Installing and running game $name from google play")
    }
}