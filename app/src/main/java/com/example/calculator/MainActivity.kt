package com.example.calculator


import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import com.example.calculator.databinding.ActivityMainBinding
import java.lang.ArithmeticException

var lastNumber = false
var lastDot = false




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View){
        calcDisplay.append((view as Button).text)
        lastNumber = true
        lastDot = false
    }

    fun onEqual(view: View){
        if(lastNumber){
            var splitNumber:List<String>
            var eNum = calcDisplay.text.toString()

            if (eNum.contains("+")){
                    splitNumber = eNum.split("+")
                    var result = splitNumber[0].toDouble() + splitNumber[1].toDouble()
                    calcDisplay.text = ""
                    calcDisplay.text = result.toString()
                }

            else if(eNum.contains("*")){
                    splitNumber = eNum.split("*")
                     var result = splitNumber[0].toDouble() * splitNumber[1].toDouble()
                    calcDisplay.text = ""
                    calcDisplay.text = result.toString()
                }
            else if(eNum.contains("/")){
                    splitNumber = eNum.split("/")
                    var result = splitNumber[0].toDouble() / splitNumber[1].toDouble()
                    calcDisplay.text = ""
                    calcDisplay.text = result.toString()
                }
            else if(eNum.contains("-")){
                if(eNum.startsWith("-")){
                    var minusPrefix = eNum[0]
                    splitNumber = eNum.split("-")
                    var num1 = minusPrefix + splitNumber[1]
                    var num2 = splitNumber[2]
                    var result = num1.toDouble() - num2.toDouble()
                    calcDisplay.text = ""
                    calcDisplay.text = result.toString()
                }
                else{
                    splitNumber = eNum.split("-")
                    var num1 = splitNumber[0]
                    var num2 = splitNumber[1]
                    var result = num1.toDouble() - num2.toDouble()
                    calcDisplay.text = ""
                    calcDisplay.text = result.toString()
                }
            }

        }
    }

    fun clear(view: View){
        calcDisplay.text = ""
        lastDot = false

    }

    fun decimalPoint(view: View){
        if(lastNumber && !lastDot) {
            calcDisplay.append(".")
            lastNumber = false
            lastDot = true
        }
    }

    fun onOperator(view: View){
        if(lastNumber && !isOperatorAdded(calcDisplay.text.toString())){
            calcDisplay.append((view as Button).text)
            lastNumber = false
        }
    }

    private fun isOperatorAdded(value:String): Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            value.contains("+") || value.contains("-") || value.contains("*") || value.contains("/")
        }
    }
}






