package sandbox

// creating a type alias
typealias EmployeeSet = Set<Employee>

fun main() {
    // using constructors
    val employeeOne = Employee("Mary", 1)
    val employeeTwo = Employee("John", 2)
    val employeeThree = Employee("John", 2)

    // checking for referential equality
    println(employeeOne === employeeTwo)
    println(employeeTwo === employeeThree)

    // checking for structural equality
    println(employeeOne == employeeTwo)
    println(employeeTwo == employeeThree)

    val employeeFour = employeeTwo
    println(employeeFour === employeeTwo)

    // val cant be changed
    val number = 25
    val otherNumber: Int
    otherNumber = 20

    // var can be changed
    var number1 = 25
    var otherNumber1: Int
    otherNumber1 = 20
    otherNumber1 = 30

    // using a type alias
    val employees: EmployeeSet


    val employee1 = Employee("Victor Chaplin", 500)
    employee1.name = "Victor Rocha"
    println(employee1)

    // using template strings
    val change = 4.22
    println("To show the value of change, we use $change")
    println("To show the value of change, we use $$change")

    val numerator = 10.99
    val denominator = 20
    println("The value of $numerator divided by $denominator is ${numerator/denominator}")

    println("The employee's id is ${employee1.id}")

    // using triple quoted strings - no escaping needed
    val filePath = """c:\somedir\somedir2"""

    val multilineText = """asdfasdfasdfasfasdf
        |asdfasfdafasdfsadf
        |asdfsdfasdfasdf
        |adsfasfasfdasdfaf
        |asdfsadfasdfsf
    """.trimMargin() // trimMargin automatically added by intellij

    println(multilineText)

}

class Employee(var name: String, val id: Int) {
    override fun equals(obj: Any?): Boolean {
        if (obj is Employee) {
            return name == obj.name && id == obj.id
        }

        return false
    }

    override fun toString(): String {
        return "Employee(name=$name, id=$id)"
    }
}