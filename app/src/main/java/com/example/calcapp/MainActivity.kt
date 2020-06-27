package com.example.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonDiv.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonMul.setOnClickListener(this)
        buttonPlus.setOnClickListener(this)
    }

    override fun onClick(v: View){

        val str1 = editText1.getText().toString()
        val str2 = editText2.getText().toString()

        if(str1.equals("") || str2.equals("")){
            Toast.makeText(this,"数字を入力してください",Toast.LENGTH_LONG).show()
            return
        }

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("VALUE1", str1.toDouble())
        intent.putExtra("VALUE2", str2.toDouble())

        when(v.id){
            R.id.buttonPlus -> {
                intent.putExtra("VALUE3","+")
            }

            R.id.buttonMinus -> {
                intent.putExtra("VALUE3","-")
            }

            R.id.buttonDiv -> {
                intent.putExtra("VALUE3","/")
            }

            R.id.buttonMul ->{
                intent.putExtra("VALUE3","*")
            }
        }

        startActivity(intent)

    }
}