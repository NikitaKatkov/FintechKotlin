class IPhone {
    var iosVersion: Int = 10
    var imei: Int = 123456789
}

fun IPhone.updateOs(newVersion: Int) {
    if (newVersion >= this.iosVersion)
        this.iosVersion = newVersion
    else
        throw IllegalArgumentException("New OS version should be greater or equal to the installed one")
}