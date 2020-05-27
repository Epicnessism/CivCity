class Event(val eventTitle: String, var turnsToComplete: Int) {

    override fun toString(): String {
        return eventTitle
    }

    fun decrement(): Int {
        return --turnsToComplete
    }

}