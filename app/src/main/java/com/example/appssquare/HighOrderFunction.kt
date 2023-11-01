package com.example.appssquare

/*
* a higher-order function is a function that can accept other functions as parameters or return functions as results
*
* */




// "onButtonClick" is a function with empty parameters and return String,
fun userInterface(onButtonClick:()->String){
    // let we have userInterface and here we handel user click on action.
    val userClickOnButton = true

    if (userClickOnButton){
        val textButtonClick = onButtonClick()
        println(textButtonClick)
    }
}






// "multiplier" if a function that take a number and return a function take number and return the multiplier
fun multiplier(factor: Int): (Int) -> Int {
    return { x -> x * factor }
}


fun main(){
    // Accepting Functions as Parameters:
    userInterface {"user click on the button."}

    //Returning Functions as Results:
    val doubler = multiplier(2)
    val result = doubler(5)
    println(result) // output: 10

}