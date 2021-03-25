class MacBook {
    var ssdSize: Int = 128
    var ramSize: Int = 8
    var screenSize: Int = 13
    var hasTouchBar: Boolean = false
    var hasArmProcessor: Boolean = false

    fun supportsIphoneApps(hasLatestUpdates: Boolean): Boolean = hasLatestUpdates && hasArmProcessor
}

fun macBook(init: MacBook.() -> Unit): MacBook = MacBook().apply(init)