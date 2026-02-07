package com.example.dados

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

       // resutlTextView.text = dice.roll().toString()



        fun rollDice(){
            val dice = Dice(6)
            val diceRoll = dice.roll()
            val diceImage: ImageView = findViewById(R.id.imageView)
            val resutlTextView: TextView = findViewById(R.id.textView)
            resutlTextView.text = diceRoll.toString()
            //diceImage.setImageResource(R.drawable.dice_2)

            val drawableResource = when (diceRoll) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            diceImage.setImageResource(drawableResource)

        }
        rollButton.setOnClickListener {
            rollDice()
           // Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
        }
    }
}