package com.jamshidbek.micalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zero.setOnClickListener { appendOnClick(true, "0") }
        one.setOnClickListener { appendOnClick(true, "1") }
        two.setOnClickListener { appendOnClick(true, "2") }
        three.setOnClickListener { appendOnClick(true, "3") }
        four.setOnClickListener { appendOnClick(true, "4") }
        five.setOnClickListener { appendOnClick(true, "5") }
        six.setOnClickListener { appendOnClick(true, "6") }
        seven.setOnClickListener { appendOnClick(true, "7") }
        eight.setOnClickListener { appendOnClick(true, "8") }
        nine.setOnClickListener { appendOnClick(true, "9") }
        dot.setOnClickListener { appendOnClick(true, ".") }

        plus.setOnClickListener { appendOnClick(true, "+") }
        minus.setOnClickListener { appendOnClick(true, "-") }
        multiply.setOnClickListener { appendOnClick(true, "*") }
        divide.setOnClickListener{appendOnClick(true,"/")}
        backspace.setOnClickListener{
            val txtQuiz = txt_question.text
            txtQuiz.trimEnd()
            txt_question.text = txtQuiz
        }

            cls.setOnClickListener {
            clear()
        }

        equals.setOnClickListener {
            calculate()
        }
    }


    private fun appendOnClick(clear: Boolean, string: String) {

        if (clear) {
            txt_answer.text = ""
            txt_question.append(string)
        } else {
            txt_question.append(txt_question.text)
            txt_question.append(string)
            txt_answer.text = ""
        }
    }

    private fun clear() {
        txt_answer.text = ""
        txt_question.text = ""
    }

    private fun calculate() {

        try {
            val input = ExpressionBuilder(txt_question.text.toString()).build()
            val output = input.evaluate()
            val longOutput = output.toLong()
            if (output == longOutput.toDouble()){
                txt_answer.text = longOutput.toString()
            }else{
                txt_answer.text = output.toString()
            }

        }catch (e:Exception){
            Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG).show()
        }
    }
}