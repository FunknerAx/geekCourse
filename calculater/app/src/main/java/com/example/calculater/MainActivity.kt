package com.example.calculater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.example.calculater.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainInterface {

    private lateinit var binding: ActivityMainBinding
    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonOne.setOnClickListener {
            presenter.addNumber(binding.buttonOne.text.toString().toDouble())
        }
        binding.buttonTwo.setOnClickListener {
            presenter.addNumber(binding.buttonTwo.text.toString().toDouble())
        }
        binding.buttonThree.setOnClickListener {
            presenter.addNumber(binding.buttonThree.text.toString().toDouble())
        }
        binding.buttonFour.setOnClickListener {
            presenter.addNumber(binding.buttonFour.text.toString().toDouble())
        }
        binding.buttonFive.setOnClickListener {
            presenter.addNumber(binding.buttonFive.text.toString().toDouble())
        }
        binding.buttonSix.setOnClickListener {
            presenter.addNumber(binding.buttonSix.text.toString().toDouble())
        }
        binding.buttonSeven.setOnClickListener {
            presenter.addNumber(binding.buttonSeven.text.toString().toDouble())
        }
        binding.buttonEight.setOnClickListener {
            presenter.addNumber(binding.buttonEight.text.toString().toDouble())
        }
        binding.buttonNine.setOnClickListener {
            presenter.addNumber(binding.buttonNine.text.toString().toDouble())
        }

        binding.buttonSum.setOnClickListener {
            presenter.addAction(Operators.SUM)
        }
        binding.buttonSub.setOnClickListener {
            presenter.addAction(Operators.SUB)
        }
        binding.buttonMultiply.setOnClickListener {
            presenter.addAction(Operators.MUL)
        }
        binding.buttonDivide.setOnClickListener {
            presenter.addAction(Operators.DIV)
        }

        binding.buttonResult.setOnClickListener {
            presenter.getResult()
        }

    }

    override fun showResult(value: Double) {
        binding.mainView.text = value.toString()
    }

    override fun showException(value: String) {
        Toast.makeText(this,value,Toast.LENGTH_SHORT).show()
    }

    override fun updateDisplay(value: String) {
        binding.mainView.text = binding.mainView.text.toString() + value
    }
}