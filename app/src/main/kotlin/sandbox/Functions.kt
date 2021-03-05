package sandbox

fun main() {
    println(labelMultiply(3, 4, "The result is:"))
    println(simplerLabelMultiply(3, 4, "The result is:"))

    println(AnotherEmployee("zezinho").upperCaseFirstName())

    val car1 = AnotherCar("blue", "Ford", 2015)
    val car2 = AnotherCar("green", "Honda", 2016)
    val car3 = AnotherCar("red", "Peugeot", 2017)

    printCarColors(car1, car2, car3)

    val manyCars = arrayOf(car1, car2, car3)
    printCarColors(*manyCars) // * is the spread operator

    println(Utils().upperFirstAndLast("this is all lowercase"))

}

fun printCarColors(vararg cars: AnotherCar) {
    for (car in cars) {
        println(car.color)
    }
}

fun labelMultiply(op1: Int, op2: Int, label: String): String {
    return "$label ${op1 * op2}"
}

fun simplerLabelMultiply(op1: Int, op2: Int, label: String) = "$label ${op1 * op2}"

class AnotherEmployee(val firstName: String) {
    fun upperCaseFirstName() = firstName.toUpperCase()
}

data class AnotherCar(val color: String, val model: String, val year: Int)