package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.calculator.databinding.ActivityMainBinding
//import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
import kotlin.math.exp


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        setContentView(R.layout.activity_main)

        binding.buttonC.setOnClickListener {

            binding.solutionTv.text = ""
            binding.resultTv.text = ""
        }
        binding.buttonOpenBraket.setOnClickListener{
            binding.solutionTv.text=addToInputText("(")
        }
        binding.buttonCloseBraket.setOnClickListener{
            binding.solutionTv.text=addToInputText(")")
        }
        binding.buttonDivide.setOnClickListener{
            binding.solutionTv.text=addToInputText("/")
        }

        binding.buttonMultiply.setOnClickListener{
            binding.solutionTv.text=addToInputText("*")
        }
        binding.buttonAddition.setOnClickListener{
            binding.solutionTv.text=addToInputText("+")
        }
        binding.buttonSubtract.setOnClickListener{
            binding.solutionTv.text=addToInputText("-")
        }
        binding.buttonPoint.setOnClickListener{
            binding.solutionTv.text=addToInputText(".")
        }

        binding.button7.setOnClickListener{
            binding.solutionTv.text=addToInputText("7")
        }
        binding.button8.setOnClickListener{
            binding.solutionTv.text=addToInputText("8")
        }
        binding.button9.setOnClickListener{
            binding.solutionTv.text=addToInputText("9")
        }
        binding.button6.setOnClickListener{
            binding.solutionTv.text=addToInputText("6")
        }
        binding.button5.setOnClickListener{
            binding.solutionTv.text=addToInputText("5")
        }
        binding.button4.setOnClickListener{
            binding.solutionTv.text=addToInputText("4")
        }
        binding.button3.setOnClickListener{
            binding.solutionTv.text=addToInputText("3")
        }
        binding.button2.setOnClickListener{
            binding.solutionTv.text=addToInputText("2")
        }
        binding.button1.setOnClickListener{
            binding.solutionTv.text=addToInputText("1")
        }
        binding.button0.setOnClickListener{
            binding.solutionTv.text=addToInputText("0")
        }
        binding.buttonEqualTo.setOnClickListener{
            showResult()
        }





    }
    private fun addToInputText(buttonValue:String):String{
        return "${binding.solutionTv.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = binding.solutionTv.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                binding.resultTv.text = "Error"
                binding.resultTv.setTextColor(ContextCompat.getColor(this, R.color.purple_700))
            } else {
                // Show Result
                binding.resultTv.text = DecimalFormat("0.######").format(result).toString()
                binding.resultTv.setTextColor(ContextCompat.getColor(this, R.color.purple_700))
            }
        } catch (e: Exception) {
            // Show Error Message
            binding.resultTv.text = "Error"
            binding.resultTv.setTextColor(ContextCompat.getColor(this, R.color.purple_700))
        }

        }
    }
