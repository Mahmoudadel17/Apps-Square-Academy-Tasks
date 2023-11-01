package com.example.appssquare



/*
*  in kotlin we have vararg in function parameter,
*  can use it when need to pass unKnown number of parameters with same data type
* */
fun printAllNames(vararg names:String){
    for ((counter, name) in names.withIndex()){
        println("name ${counter +1} : $name")
    }

}



fun main(){
    printAllNames("mahmoud","ahmed","mohamed","tarek")

}