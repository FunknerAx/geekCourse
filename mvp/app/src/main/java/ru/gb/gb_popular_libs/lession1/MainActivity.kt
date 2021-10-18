package ru.gb.gb_popular_libs.lession1

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ru.gb.gb_popular_libs.lession1.R.layout.activity_main

class MainActivity : AppCompatActivity(activity_main), MainView {

    private val btn_counter1: Button by lazy { findViewById(R.id.btn_counter1) }
    private val btn_counter2: Button by lazy { findViewById(R.id.btn_counter2) }
    private val btn_counter3: Button by lazy { findViewById(R.id.btn_counter3) }
    private val presenter: Presenter by lazy { Presenter(Model(listOf(R.id.btn_counter1,R.id.btn_counter2,R.id.btn_counter3)),this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_counter1.setOnClickListener {
            presenter.contUp(it.id)
        }

        btn_counter2.setOnClickListener {
            presenter.contUp(it.id)
        }

        btn_counter3.setOnClickListener {
            presenter.contUp(it.id)
        }

        presenter
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //outState.putIntArray("counters", counters.toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val countersArray = savedInstanceState.getIntArray("counters")
//        countersArray?.toList()?.let {
//            counters.clear()
//            counters.addAll(it)
//        }
    }

    override fun setButtonText(index: Int, text: String) {
        when(index) {
            R.id.btn_counter1 -> btn_counter1.text = text
            R.id.btn_counter2 -> btn_counter2.text = text
            R.id.btn_counter3 -> btn_counter3.text = text
        }
    }

}
