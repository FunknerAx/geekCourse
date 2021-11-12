package com.example.calculater

class MainPresenter(val mainActivity: MainInterface) {
    private val calculater = CalculaterModel()
    
    fun addAction(value: Operators) {
        calculater.addAction(value)
        mainActivity.updateDisplay(" $value ")
    }
    
    fun addNumber(value: Double) {
        calculater.addNumber(value)
        mainActivity.updateDisplay(value.toInt().toString())

    }
    
    fun getResult(){
        if(calculater.checkResult()){
            mainActivity.showResult(calculater.getResult())
        } else {
            mainActivity.showException("Необходимо ввести еще одно число")
        }
    }



}