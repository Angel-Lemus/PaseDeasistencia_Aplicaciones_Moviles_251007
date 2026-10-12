package com.example.interfaz

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
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

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        val tvMensaje = findViewById<TextView>(R.id.tvMensaje)
        val etxtNombre = findViewById<EditText>(R.id.etxtNombre)
        val etxtMatricula = findViewById<EditText>(R.id.etxtMatricula)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val btnLimpiar = findViewById<Button>(R.id.btnLimpiar)
        val pbCarga = findViewById<ProgressBar>(R.id.pbCarga)

        btnRegistrar.setOnClickListener {

            val nombre = etxtNombre.text.toString()
            val matricula = etxtMatricula.text.toString()

            if (nombre.isEmpty() || matricula.isEmpty()) {

                tvMensaje.text = "Completa todos los campos"

            } else {

                tvMensaje.text =
                    "Registro realizado: $nombre - $matricula"
            }
        }

        btnLimpiar.setOnClickListener {

            etxtNombre.text.clear()
            etxtMatricula.text.clear()

            tvMensaje.text = "Escribe tus datos para registrarte"
        }
    }
}
