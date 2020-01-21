package org.victor.sandbox

typealias EmployeeSet = Set<Employee>

fun main() {
    val number = 25
    val otherNumber: Int
    otherNumber = 20

    var number1 = 25
    var otherNumber1: Int
    otherNumber1 = 20
    otherNumber1 = 30

    val employees: EmployeeSet


    val employee1 = Employee("Victor Chaplin", 500)
    employee1.name = "Victor Rocha"


}

class Employee(var name: String, val id: Int) {}