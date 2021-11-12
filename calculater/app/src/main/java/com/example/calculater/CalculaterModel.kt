package com.example.calculater

class CalculaterModel{

    private var numbers = mutableListOf<Double>()
    private var operators = mutableListOf<Operators>()
    private var lastNumber: String = ""
    private lateinit var logic: CalculaterLogics




    fun addNumber(value: Double) {
        lastNumber += value.toInt().toString()
    }

    fun addAction(value: Operators) {
        if(lastNumber != ""){
            numbers.add(lastNumber.toDouble())
            lastNumber = ""
        }

        operators.add(value)
    }

    fun getResult(): Double {
        logic = CalculaterLogics()
        return logic.get(numbers, operators)
    }

    fun checkResult(): Boolean {
        if(lastNumber != ""){
            numbers.add(lastNumber.toDouble())
            lastNumber = ""
        }
        return numbers.size > operators.size

    }

}