class Stronghold {
    var level: Int = 0

    fun upgrade() {
        level++
    }

    override fun toString(): String {
        return "Stronghold Level ${level}, something else here"
    }

}