data class ResourceArray(val food: Double, val wood: Double, val stone: Double) {

    override fun toString(): String {
        return "Food: ${food}, Wood: ${wood}, Stone: ${stone}"
    }

}