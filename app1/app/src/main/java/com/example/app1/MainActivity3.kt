package com.example.app1

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    private val validUsers = mapOf(
        "hola" to "1234",
        "test" to "test",
        "123" to "hola"
    )
    val maxAttempts = 3
    var attemptsLeft = maxAttempts
    val lockTime = 15000L //milliseconds
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val buttonej2 = findViewById<Button>(R.id.button6)
        val valBtn = findViewById<Button>(R.id.button7)
        val valTvw = findViewById<TextView>(R.id.textView3)
        val userName = findViewById<EditText>(R.id.editTextText)
        val password = findViewById<EditText>(R.id.editTextTextPassword)
        valBtn.setOnClickListener {
            val inputUserName = userName.text.toString().trim()
            val inputPassword = password.text.toString()
            if (validUsers[inputUserName] == inputPassword){
                attemptsLeft = maxAttempts
                valTvw.text = "Valido, hola $inputUserName"
            } else{
                attemptsLeft--
                if (attemptsLeft>0){
                    valTvw.text = "Invalido, intentos disponibles: ${attemptsLeft}"
                } else{
                    lockInpts(userName, password, valBtn, isEnabled = false)
                    object : CountDownTimer(lockTime, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            val segsLeft = millisUntilFinished / 1000
                            //me olvide y empece a hacer todo en ingles en este momento
                            valTvw.text = "Lock, retry in: ${segsLeft}s"
                        }
                        override fun onFinish() {
                            attemptsLeft = maxAttempts
                            lockInpts(userName, password, valBtn, isEnabled = true)
                            valTvw.text = "You can retry now."
                        }
                    }.start()
                }
            }
        }
        buttonej2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
    private fun lockInpts(user: EditText, pass: EditText, btn: Button, isEnabled: Boolean) {
        user.isEnabled = isEnabled
        pass.isEnabled = isEnabled
        btn.isEnabled = isEnabled
    }
}
// nombre de usuario, password, boton, validar con un string hardcodeado,