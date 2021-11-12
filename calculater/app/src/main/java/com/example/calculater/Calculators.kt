package com.example.calculater

interface Calculators {
    fun sum(valueOne: Double, valueTwo: Double): Double
    fun multiply(valueOne: Double, valueTwo: Double): Double
    fun subtract(valueOne: Double, valueTwo: Double): Double
    fun divide(valueOne: Double, valueTwo: Double): Double

}