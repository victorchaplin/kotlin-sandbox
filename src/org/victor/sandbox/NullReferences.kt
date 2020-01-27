package org.victor.sandbox

fun main() {
    val nullStr: String? = null
    val str: String? = "This is not null"
//    str.toUpperCase() // does not work because str is nullable
    if (str != null) {
        str.toUpperCase() // works because null is checked
    }

    str?.toUpperCase() // pretty null check

    println("What happens when we do this: ${nullStr?.toUpperCase()}")
    println("What happens when we do this: ${str?.toUpperCase()}")

    val str2: String = nullStr ?: "This is the default value"
    println(str2)

    val something: Any = arrayOf(1, 2, 3, 4)
    val str3 = something as? String
    println(str3)

//    str3!!.toUpperCase() // not-null assertion ignores null check. generates null pointer in this case

    str3?.let { it.toUpperCase() } // a way to protect against null pointer when calling functions

    println(nullStr == str) // == is capable of comparing nullable variables

    val nullableInts = arrayOfNulls<Int>(10)
    println(nullableInts.contentToString())
}