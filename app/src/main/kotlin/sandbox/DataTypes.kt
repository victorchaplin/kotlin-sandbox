package sandbox

import java.math.BigDecimal

fun main() {
    val myInt = 10
    var myLong = 10L

//    myLong = myInt // doesnt work. unlike java, kotlin does not convert numbers

    val myByte: Byte = 111
    var myShort: Short
//    myShort = myByte // same here

    val myDouble = 65.984
    println(myDouble.javaClass.simpleName)
    println(myDouble::class.simpleName)

    val myFloat = 898.98765f
    println(myFloat.javaClass.simpleName)

    val char = 'b'
    println(char.javaClass.simpleName)

    val myChar = 65
    println(myChar.toChar())

    val myBoolean = true

    val anything: Any

    val names = arrayOf("John", "Jane", "Jill", "Joe")
    val longsArray = arrayOf(1L, 2L, 3L)
    val longsArray2 = arrayOf<Long>(1, 2, 3, 4)

    println(longsArray[2])

    val evenNumbers = Array(16) { it * 2 }
    for (number in evenNumbers) {
        println(number)
    }

    println(evenNumbers.contentToString())

    val lotsOfNumbers = Array(100000) { it + 2 }
    val allZeroes = Array(100) { 0 }

    println(allZeroes.contentToString())

    val mixedArray = arrayOf("hello", 22, BigDecimal(10.5), 'a')
    println(mixedArray.contentToString())
    println(mixedArray is Array<*>)

    val myIntArray = intArrayOf(9, 4, 2, 6, 7)
    val someOtherArray = IntArray(5)
}