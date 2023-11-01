package com.example.appssquare


/*
*  an extension function is a powerful feature that allows you to add new functions
*  to existing classes without modifying their source code
* */

fun String.printMessage(){
    println(this)
}



fun main(){
    val message = "hello world"
    message.printMessage()
}