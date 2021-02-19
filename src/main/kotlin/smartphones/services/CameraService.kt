package smartphones.services

class CameraService(private val resolution: Int) : DummyDataGenerator() {
    fun takePicture(): ByteArray {
        println("Taking a picture with resolution $resolution megapixels")
        return generateBytes()
    }
}