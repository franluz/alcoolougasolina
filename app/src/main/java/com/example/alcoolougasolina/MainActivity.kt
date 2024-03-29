package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun btCalcular(view: View){

        //recupera valores digitados
        val precoAlcool = edit_preco_alcool.text.toString()
        val precoGasolina = edit_preco_gasolina.text.toString()

        val validaCampos = validarCampos( precoAlcool, precoGasolina )
        if( validaCampos ){
            calcularMelhorPreco( precoAlcool, precoGasolina )
        }else{
            text_resultado.setText("Preencha os preços primeiro!")
        }


    }

    fun validarCampos( precoAlcool: String, precoGasolina: String ) : Boolean {

        var camposValidados: Boolean = true

        if ( precoAlcool == null || precoAlcool.equals("") ){
            camposValidados = false
        }else if( precoGasolina == null || precoGasolina.equals("") ){
            camposValidados = false
        }

        return camposValidados

    }

    fun calcularMelhorPreco( precoAlcool: String, precoGasolina: String ){

        //Converte valores string para numeros
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        /*Faz cálculo ( precoAlcool / precoGasolina )
            * Se resultado >= 0.7 melhor utilizar gasolina
            * senão melhor utilizar Álcool
        * */
        val resultadoPreco = valorAlcool / valorGasolina

        if( resultadoPreco >= 0.7 ){
            text_resultado.setText("Melhor utilizar Gasolina!")
        }else{
            text_resultado.setText("Melhor utilizar Álcool!")
        }

    }


}
