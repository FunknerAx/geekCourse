package com.example.calculater

class CalculaterModel{

    var numbers = mutableListOf<Double>()
    var operators = mutableListOf<Operators>()
    lateinit var logic: CalculaterLogics




    fun addNumber(value: Double) {
        numbers.add(value)
    }

    fun addAction(value: Operators) {
        operators.add(value)
    }

    fun getResult(): Double {
        return logic.get(numbers, operators)
    }

}