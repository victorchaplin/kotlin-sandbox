package challenges

fun main() {
    val hello1 = "Hello"
    val hello2 = "Hello"

    println(hello1 === hello2)
    println(hello1 == hello2)

    var number = 2988
    val text: Any = "The Any type is the root of the Kotlin class hierarchy"

    if (text is String) {
        println(text.toUpperCase())
    }

    println("""   1
        |  11
        | 111
        |1111
    """.trimMargin())
}