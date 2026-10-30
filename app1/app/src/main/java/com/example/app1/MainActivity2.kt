package com.example.app1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private fun sum(n1: Int, n2: Int): Int = n1 + n2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button = findViewById<Button>(R.id.button2)
        val buttonej1 = findViewById<Button>(R.id.button4)
        val buttonej3 = findViewById<Button>(R.id.button5)
        val textVw = findViewById<TextView>(R.id.textView)
        val num1 = findViewById<EditText>(R.id.editTextNumber2)
        val num2 = findViewById<EditText>(R.id.editTextNumber)

        button.setOnClickListener {
            val val1 = num1.text.toString().toInt()
            val val2 = num2.text.toString().toInt()
            textVw.text = (sum(val1, val2)).toString()
        }
        buttonej1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        buttonej3.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}
// dos input donde ingreso los numeros, sumar y mostrar el resultado