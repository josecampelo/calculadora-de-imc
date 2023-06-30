package com.campelo.calculadoradeimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var edtPeso: EditText
    private lateinit var edtAltura: EditText
    private lateinit var btnCalcular: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtPeso = findViewById(R.id.edtPeso)
        edtAltura = findViewById(R.id.edtAltura)
        btnCalcular = findViewById(R.id.btnVoltar)

        btnCalcular.setOnClickListener {
            val intent = Intent(this, ResultadoActivity::class.java)

            val peso = edtPeso.text.toString()
            val altura = edtAltura.text.toString()

            if(peso.isNotEmpty() && altura.isNotEmpty()){
                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())

                startActivity(intent)
            }else{
                Toast.makeText(this, "Preencha os campos corretamente", Toast.LENGTH_SHORT).show()
            }
        }
    }
}