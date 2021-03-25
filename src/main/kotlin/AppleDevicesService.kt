interface AppleDevicesService {
    fun findDeviceByImei(imeiCode: Int): IPhone?
    fun findAllActivatedDevices(): Collection<IPhone>
}