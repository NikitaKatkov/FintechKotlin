class AirPods {
    fun isPairedWithPhone(phoneId: Int): Boolean {
        return phoneId > 10
    }

    fun getActionIdForUserInput(inputType: AirpodsInputType): String =
        when(inputType) {
            AirpodsInputType.TAP -> "pause"
            AirpodsInputType.DOUBLE_TAP -> "next track"
            AirpodsInputType.PRESS_AND_HOLD -> "siri"
        }
}

enum class AirpodsInputType {
    TAP, DOUBLE_TAP, PRESS_AND_HOLD
}