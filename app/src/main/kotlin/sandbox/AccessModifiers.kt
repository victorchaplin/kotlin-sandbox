package sandbox

const val MY_CONSTANT = 200

fun main() {
    println(MY_CONSTANT)

    val car = Vehicle("monza")
    println(car.modelName)
    println(car.isWorking)
    car.isWorking = false

    val car1 = Vehicle("monza")
    car1.isWorking = false
    println(car == car1)

    val car2 = Vehicle("Brasilia", false)
    println(car2.modelName)
    println(car2.isWorking)

    println(Dummy().dummy)

    val car3 = Car("white", "Corolla", 1984)
    println(car3)
    val car4 = Car("white", "Corolla", 1984)
    println(car3 == car4)
    println(car3 === car4)

    println(car == car1)

    val car5 = car4.copy()
    println(car5)

    val car6 = car5.copy(year = 2016)
    println(car6)
}

data class Car(val color: String, val model: String, val year: Int)

class Vehicle(val modelName: String, isWorking: Boolean = true) {
    var isWorking = isWorking
    get() {
        println("running custom getter")
        return field
    }
    set(value) {
        println("running custom setter")
        field = value
    }
}

class Dummy {
    val dummy: String

    constructor() {
        dummy = "Hello"
    }
}