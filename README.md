# kotlin-sandbox

### Notes based on Kotlin for Java Developers course

### https://www.udemy.com/course/kotlin-for-java-developers/

#### Basic differences between Kotlin and Java
- kotlin compiles to Java .class files
- when using intellij, it seems that the kotlin runtime version used must be the one bundled with intellij
- when packaging a kotlin app, kotlin runtime and JRE must be bundled
- kotlin main() function can be declared without args
- the standard library has a lot of utilities to avoid importing libs
- kotlin uses type inference, so the type declaration may be skipped
- variables declared as VAR can be reassigned
- variables declared as VAL cannot be reassigned
- it's a good practice to declare all variables as VAL and only VAR when really needed
- in kotlin, == checks for structural equality, === checks for referential equality
- type checking is done using 'is'
- casting is done using 'as'
- kotlin has automatic casting after type checking
- supports string templates
- has a REPL that knows about the context of the project

#### Data Types and Null Reference Handling
- kotlin does not convert numbers, i.e convert from int to long
- java interoperability is assured even using Kotlin types. Boxing/unboxing to java primitives types is automatic
- the Any type is equivalent to Object in java
- the Unit type is equivalent to void in java (but it's an object)
- the Nothing type tells the kotlin compiler to not expect a return for a function (for instance, an expected infinite loop)
- in kotlin arrays dont have a default toString method. Lists do have them
- using the primitive array types (IntArray, BooleanArray, CharArray) is faster than using the generic array
- kotlin compiler will check for nullable types and block some operations
- if default values are needed when checking for null, use elvis operator ?:
- casting also has a safe check. as? is used to safe cast
- to make sure that a value is not null, the !! operator can be used. if it is null, null pointer exception will be thrown

#### OO and Kotlin: Classes, Functions, Inheritance
- in kotlin, default visibility is public
- kotlin has no matching requirement between classes and file names
- private access applies to the file where the declarations are
- kotlin a new access modifier - internal - that is visible within the same module
- internal is compiled to public, possibly causing encapsulation problems with java interop
- all classes are public and final by default
- in kotlin, properties cannot be accessed directly from the outside of the file, so they do not need to be private
- getters and setters MUST BE declared right after the property
- data classes are used to store state, they have equals(), hashCode(), toString() and copy() already defined
