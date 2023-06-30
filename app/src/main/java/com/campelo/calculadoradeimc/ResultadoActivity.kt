package com.campelo.calculadoradeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {

    private lateinit var txtPeso: TextView
    private lateinit var txtAltura: TextView
    private lateinit var txtResultado: TextView
    private lateinit var btnVoltar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        txtPeso = findViewById(R.id.txtPeso)
        txtAltura = findViewById(R.id.txtAltura)
        txtResultado = findViewById(R.id.txtResultado)
        btnVoltar = findViewById(R.id.btnVoltar)

        val bundle = intent.extras

        if(bundle != null){
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            txtPeso.text = "Peso informado: $peso kg"
            txtAltura.text = "Altura informada: $altura kg"

            val imc = peso / (altura * altura)
            val resultado = if(imc < 18.5){
                "Baixo"
            }else if(imc in 18.5 .. 24.9){
                "Normal"
            }else if(imc in 25.0 .. 29.9){
                "Sobrepeso"
            }else{
                "Obesidade"
            }

            txtResultado.text = resultado
        }


        btnVoltar.setOnClickListener {
            finish()
        }
    }
}