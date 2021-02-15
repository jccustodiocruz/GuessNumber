package com.example.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var maxNum = 100
    var minNum = 0
    var num = 0
    var won = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessings: TextView = findViewById(R.id.guessings)
        val up: Button = findViewById(R.id.up)
        val down: Button = findViewById(R.id.down)
        val generate: Button = findViewById(R.id.generate)
        val guessed: Button = findViewById(R.id.guessed)

        generate.setOnClickListener{
            num = Random.nextInt(minNum, maxNum)
            guessings.setText(num.toString())
            generate.visibility = View.INVISIBLE
            guessed.visibility =  View.VISIBLE
        }

        up.setOnClickListener{
            minNum = num
            if (checkingLimits()){
                num = Random.nextInt(minNum, maxNum)
                guessings.setText(num.toString())
            } else {
                guessings.setText("Oh no, perdí")
            }
        }

        down.setOnClickListener{
            maxNum = num
            if (checkingLimits()){
                num = Random.nextInt(minNum, maxNum)
                guessings.setText(num.toString())
            } else {
                guessings.setText("Oh no, perdí")
            }
        }

        guessed.setOnClickListener{
            if (!won) {
                guessings.setText("Gané")
                guessed.setText("Otra vez?")
                won = true
            } else {
                generate.visibility = View.VISIBLE
                guessings.setText("Tap on generate to start")
                guessed.visibility = View.GONE
                resetValues()
            }
        }
    }

    fun checkingLimits(): Boolean{
        return minNum != maxNum
    }

    fun resetValues(){
        minNum = 0
        maxNum = 100
        num = 0
        won = false
    }


}