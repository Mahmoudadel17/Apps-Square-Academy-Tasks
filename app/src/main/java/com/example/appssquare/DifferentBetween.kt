package com.example.appssquare

// val and const are two different concepts used for different purposes
/*
* 1- val ex: val pi = 3.14159
*
*  - is a keyword used to declare a read-only (immutable) variable .
*
*  - val variables are evaluated at runtime.
*
*  - Once a val variable is assigned a value, it cannot be changed or reassigned
*
*
* 2-  const ex: const val PI = 3.14159
*
*  - const is used to declare a compile-time.
*
*  - const is primarily used for creating constants
*    that have the same value throughout the application and should not change.
*
* */






// in Kotlin, both lateinit and by lazy are used to defer the initialization of properties,
// but they have different use cases and behaviors.
/*
* 1-  lateinit ex:  lateinit var name: String
*  - It is typically used for non-nullable properties
*    that are not immediately available at the time of object creation but will be initialized before they are accessed.
*
*
*  - Accessing a lateinit property before it is initialized,
*    will result in a lateinit property not initialized exception at runtime.
*
*
* 2- by lazy ex:
* val exampleProperty: String by lazy {
    // Initialization code
    "Initialized Value"
}
*
*
*  - by lazy is a property delegate in Kotlin, used for both val and var properties.
     It is designed for properties that need lazy initialization, and it allows you to initialize a property when it is first accessed.
*
*
*  - The property can be reassigned if it's declared as var
*
*
* */
