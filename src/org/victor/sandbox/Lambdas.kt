package org.victor.sandbox

fun main() {
    println(countTo100())
    run { println("Hello I'm in a lambda!") }

    val employees = listOf(
        TestEmployee("John", "Smith", 2012),
        TestEmployee("Jane", "Wilson", 2015),
        TestEmployee("Mary", "Johnson", 2010),
        TestEmployee("Mike", "Jones", 2002)
    )

    println(employees.minBy { employee -> employee.startYear })
    println(employees.minBy { it.startYear })
    println(employees.minBy(TestEmployee::startYear))

    run(::topLevel)

    var num = 10 // variable has to be declared before the lambda to be used in the lambda
    run {
        num += 15
        println(num)
    }
}

// saving this for comparison. cleaner function below
//fun countTo100(): String {
//    val numbers = StringBuilder()
//    return with(numbers) {
//        for (i in 1..99) {
//            append(i)
//            append(", ")
//        }
//        append(100)
//        toString()
//    }
//}

fun countTo100() =
    with(StringBuilder()) {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
        toString()
    }

fun topLevel() = println("I'm a function!")

data class TestEmployee(val firstName: String, val lastName: String, val startYear: Int)