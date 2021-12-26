package com.example.kotlinfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var newOp=true
    var oldNum=""
    var operator=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun allClear(view: android.view.View) {
        inputOutput.text="" //clears everything
    }
    fun equalsClicked(view: android.view.View) {
        var newNum:String=inputOutput.text.toString()
        var res=0.0
        when(operator){
            "+" -> {res=oldNum.toDouble() + newNum.toDouble()}
            "-" -> {res=oldNum.toDouble() - newNum.toDouble()}
            "/" -> {res=oldNum.toDouble() / newNum.toDouble()}
            "*" -> {res=oldNum.toDouble() * newNum.toDouble()}
        }
        inputOutput.text=res.toString()
    }


    fun backSpaceClicked(view: android.view.View) {
        val length=inputOutput.length()
        if(length>0)
            inputOutput.text=inputOutput.text.subSequence(0,length-1)
    }

    fun numberEvent(view: android.view.View) {
        if(newOp)
            inputOutput.text="" //if new operators is clicked it will go to the next number and iterate
        newOp=false
        var btnClick:String=inputOutput.text.toString()
        var btnSelect:Button=view as Button
        when(btnSelect.id){
            btn0.id -> {btnClick +="0"}
            btn1.id -> {btnClick +="1"}
            btn2.id -> {btnClick +="2"}
            btn3.id -> {btnClick +="3"}
            btn4.id -> {btnClick +="4"}
            btn5.id -> {btnClick +="5"}
            btn6.id -> {btnClick +="6"}
            btn7.id -> {btnClick +="7"}
            btn8.id -> {btnClick +="8"}
            btn9.id -> {btnClick +="9"}

        }
        inputOutput.text = btnClick
    }

    fun operatorEvent(view: android.view.View) {
        newOp=true
        oldNum=inputOutput.text.toString()
        var btnSelect=view as Button
        when(btnSelect.id){
            btnAdd.id -> {operator ="+"}
            btnMinus.id -> {operator ="-"}
            btnDiv.id -> {operator ="/"}
            btnMul.id -> {operator ="*"}
        }
    }
}