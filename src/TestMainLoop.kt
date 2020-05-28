fun input(): String {
    return readLine().toString()
}

fun endTurn(city: City, events: EventsInAction) {
    events.eventsInAction.forEach {
        event -> event.decrement()
        if(event.turnsToComplete <= 0) { //that means action can now happen
//            if(eventActionHandler(event)) {
//                println("success")
//            } else {
//                println(event.endResult)
//            }
        }
        println(event.turnsToComplete)

    }
}
//will return either true for success or false for failure
fun eventActionHandler(event: Event): Boolean {
    return true
}

//will return either true for success or false for failure
fun eventResourceDeductionHandler(city: City, event: Event): Boolean {
    val (cFood, cWood, cStone) = city.resources
    val (eFood, eWood, eStone) = event.resourceCost
    if (cFood >= eFood && cWood >= eWood && cStone >= eStone) {
        city.resources = ResourceArray(food=(cFood-eFood), wood=(cWood-eWood), stone=(cStone-eStone) )
        return true
    }
    return false
}

fun cityStats(city: City) {
    println("City Name: ${city.name}")
    println("${city.stronghold}")
    println("${city.resources}")
}

fun interactWithEventsLoop(city: City, events: EventsInAction) {
    loop@ while(true) {
        println("Actions:")
        println("0: back")
        println("1: View All Events")
        println("2: ")
        println("3: ")
        println("4: ")
        val choice = input()
        when(choice) {
            "0" -> break@loop
            "1" -> println(events.eventsInAction.toString())
        }
    }
}

fun gameloop(city: City, events: EventsInAction) {
    val game = true

    loop@ while(game) {
        println("Actions:")
        println("0: End turn")
        println("1: View City Stats")
        println("2: Upgrade Stronghold")
        println("3: Train 100 Troops")
        println("4: View Queued Events")
        val choice = input()
        when(choice) {
            "0" -> break@loop
            "1" -> cityStats(city)
            "2" -> {
                city.stronghold.upgrade()
                println("${city.name}'s Stronghold is now Level ${city.stronghold.level}")
            }
            "3" -> { //Train troops
                val newEvent = Event("Train Troops", 2, ResourceArray(200.0,200.0,50.0) ,"Create 100 Troops")
                if(eventResourceDeductionHandler(city, newEvent)) {
                    events.eventsInAction.add(newEvent)
                    println("${newEvent.eventTitle} successfully started.")
                } else {
                    println("You are not eligible to do this action!")
                }
            }
            "4" -> {
                //take player to another loop for now I guess?
                interactWithEventsLoop(city, events)
//                val removedEvent = events.eventsInAction.remove()
//                println(events.eventsInAction.toString())
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
    val events = EventsInAction()

    //main game loop
    gameloop(myCity, events)
}