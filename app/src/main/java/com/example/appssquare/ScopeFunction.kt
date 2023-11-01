package com.example.appssquare

/*
*   the scope functions are a set of higher-order functions,
*   that allow you to execute a block of code in the context of an object
*   There are five main scope functions in Kotlin: { let , run, with, also, apply }
* */





/*
* The 'let' function is used to perform an operation on an object and return a result.
*  It takes a lambda as a parameter and provides the object as 'it' within the lambda.
*  It is often used for null safety or to transform the object.
*/
fun letExample(user: User?){

    val userName = user?.let {
        println("user object not null in let")
        it.userName
    }
    println("user name = $userName") // output: "null" if user null
}


/*
* The run function is used to execute a block of code within the context of an object.
*  It returns the result of the lambda expression
*  and allows you to access the object's properties and functions directly without using it.
*/
fun runExample(){
    val length = "Kotlin".run {
        println(this)  // Access object directly
        length
    }

    println("Length: $length")
//                           Output:
//                                  Kotlin
//                                  Length: 6
}


/*
* The with function is similar to run but is not an extension function.
*  It takes an object and a lambda as arguments, and within the lambda,
*  you can access the object's properties and methods directly.
 */
fun withExample(user: User){

    val result = with(user){
        println("user name: $userName")
        userName // this with no effect because 'with' assign the last line to the result.
        id
    }

    println("result: $result") // print user id .
}


/*
* The also executes a block of code on an object and returns the object itself.
*  It is often used when you want to perform an operation on an object and then continue working with the same object.
*/
fun alsoExample(){
    val list = mutableListOf(1, 2, 3)
    list.also { it.add(4) }.add(5)

    println(list) // Output: [1, 2, 3, 4, 5]
}



/*
* The apply function is similar to also, but it returns the object it's called on.
*  It is often used when you want to modify the properties of an object and return the modified object.
* */
fun applyExample(user: User){
    val updatedUser = user.apply {
        userName = "mahmoud adel"
    }
    println(updatedUser)// output : User(id=1, userName=mahmoud adel)
}
fun main(){

    var user:User? = null
    letExample(user)

    user = User(1,"mahmoud")
    letExample(user)

    //-------------------------------
    runExample()

    // -----------------------------
    withExample(user)

    // ----------------------------
    alsoExample()

    // ----------------------------
    applyExample(user)

}