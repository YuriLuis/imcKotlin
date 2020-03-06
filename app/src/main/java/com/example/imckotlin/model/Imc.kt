package com.example.imckotlin.model

import com.example.imckotlin.emun.Sexo

class Imc(peso: Double, altura: Double, genero: Sexo) {

    private var peso: Double = peso
    private var altura : Double = altura
    private  var genero : Sexo = genero


    fun calculaImc() = peso / (altura * altura)

    fun pesoIdeal(peso: Double, altura: Double): Double {

        return 0.0
    }

     fun classificacaoImc(imc: Double): String{

        var retorno : String
        if (imc < 18.5){

            retorno = "abaixo do Peso"
        }else if ((imc >= 18.5) and (imc < 25)){

            retorno = "Normal"
        }else if ((imc >= 25) and (imc < 30)){

            retorno = "Sobrepeso"
        }else {

            retorno = "Está Gordo Obeso "
        }

         return retorno
    }
}