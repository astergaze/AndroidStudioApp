package com.example.app1

import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonej2 = findViewById<Button>(R.id.button3)
        val textView = findViewById<TextView>(R.id.textView2)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            textView.text = "hola"
        }
        buttonej2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
// tocar un boton y cambiar un textview
// dos input donde ingreso los numeros, sumar y mostrar el resultado
// nombre de usuario, password, boton, validar con un string hardcodeado,
/* cada vez que se falle se reduce la cantidad de intentos, al fallar mas de 3 veces
 inhabilitar inputs y esperar un tiempo para volver a intentar
 si podes hacerlo en el mismo proyecto, ta bien
 */