package ru.gb.gb_popular_libs.lession1

import android.util.Log

class Presenter(private val model: Model, val view: MainView) {
    private val presenterModel = model
    init{
        presenterModel.counters.forEach{
            view.setButtonText(it.key,it.value.toString())
            Log.d("VALUES", "" + it.key + " " + it.value)
        }
        Log.d("INIT","INIT VALUES")
    }

    fun contUp(id: Int) {
        view.setButtonText(id,presenterModel.next(id).toString())
        Log.d("VALUES", id.toString() + " " + presenterModel.getCounter(id).toString())
    }
}
