package challenges

import java.Interop

fun main() {
    val float1: Float? = -3847.384f

    val arrayOfShorts = shortArrayOf(1, 2, 3, 4, 5)

    val nullableInts = Array<Int?>(40) { (it + 1) * 5 }
    println(nullableInts.contentToString())

    // for java interop to work, the array must be declared using the primitive type declaration
    val charArray = charArrayOf('a', 'b', 'c') // works!
    val charArray2: Array<Char> = arrayOf('a', 'b', 'c') // doesnt work!
    Interop().method1(charArray)

    val x: String? = "I AM IN UPPERCASE"
    val y = x?.toLowerCase() ?: "I give up!"
    println(y)

    x?.let {
        println(it.toLowerCase().replace("am", "am not"))
    }


    val myNonNullVariable: Int? = null
    myNonNullVariable?.toDouble()
//    myNonNullVariable!!.toDouble() // non-null assertion causes null pointer exception
}