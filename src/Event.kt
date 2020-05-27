class Event(val eventTitle: String, var turnsToComplete: Int, var resourceCost: ResourceArray, var action: Any) {
    var endResult: String = ""
    override fun toString(): String {
        return eventTitle
    }

    fun decrement(): Int {
        return --turnsToComplete
    }

}