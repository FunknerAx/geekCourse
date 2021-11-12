package com.example.calculater

class CalculaterLogics : Calculators {
    fun get(numbers: MutableList<Double>, operators: MutableList<Operators>): Double {
        var result = 0.0

        if (numbers.size > 1) {
            for (i in 0 until operators.size) {
                if (operators[i] == Operators.MUL) {
                    val newNumber: Double = multiply(numbers[i], numbers[i + 1])
                    operators.removeAt(i)
                    numbers[i] = newNumber
                    numbers.removeAt(i + 1)
                    break;
                } else if (operators[i] == Operators.DIV) {
                    val newNumber: Double = divide(numbers[i], numbers[i + 1])
                    operators.removeAt(i)
                    numbers[i] = newNumber
                    numbers.removeAt(i + 1)
                    break;
                } else if (operators[i] == Operators.SUM) {
                    val newNumber: Double = sum(numbers[i], numbers[i + 1])
                    operators.removeAt(i)
                    numbers[i] = newNumber
                    numbers.removeAt(i + 1)
                    break;
                } else {
                    val newNumber: Double = subtract(numbers[i], numbers[i + 1])
                    operators.removeAt(i)
                    numbers[i] = newNumber
                    numbers.removeAt(i + 1)
                    break;
                }
            }

            result = get(numbers,operators)

        } else {
            result = numbers[0]
        }

        return result
    }

    override fun sum(valueOne: Double, valueTwo: Double): Double {
        return valueOne.plus(valueTwo)
    }

    override fun multiply(valueOne: Double, valueTwo: Double): Double {
        return valueOne * valueTwo
    }

    override fun subtract(valueOne: Double, valueTwo: Double): Double {
        return valueOne.minus(valueTwo)
    }

    override fun divide(valueOne: Double, valueTwo: Double): Double {
        return valueOne.div(valueTwo)
    }

}