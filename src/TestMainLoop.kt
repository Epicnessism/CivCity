fun input(): String {
    return readLine().toString()
}

fun endTurn(city: City, events: EventsInAction) {
    events.eventsInAction.forEach {
        event -> event.decrement()
        if(event.turnsToComplete <= 0) {

        }
        println(event.turnsToComplete)

    }
}

fun gameloop(city: City, events: EventsInAction) {
    var game: Boolean = true

    while(game) {
        val choice = input()
        when(choice) {
            "0" -> game = false
            "1" -> {
                val newLevel = city.stronghold.upgrade()
                println("${city.name}'s Stronghold is now Level ${city.stronghold.level}")
            }
            "2" -> { //Train troops
                events.eventsInAction.add(Event("Train Troops", 2))
                println(events.eventsInAction.toString())
            }
            "3" -> {
                val removedEvent = events.eventsInAction.remove()
                println(events.eventsInAction.toString())
            }
        }
        endTurn(city, events)
    }
}

fun main(args: Array<String>) {
    println("Name your new city: ")
    val cityName = input()
    val myCity = City(cityName)
    println("${myCity.name} has been founded!")
    //start the game and get the new name of the city

    //create EventsInAction
    val events: EventsInAction = EventsInAction()

    //main game loop
    gameloop(myCity, events)

}