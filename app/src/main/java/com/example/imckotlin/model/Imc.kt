package com.example.imckotlin.model

import com.example.imckotlin.emun.Sexo

class Imc(peso: Double, altura: Double, genero: Sexo) {

    private var peso: Double = peso
    private var altura : Double = altura
    private  var genero : Sexo = genero


    fun calculaImc() = peso / (altura * altura)

    fun pesoIdeal(peso: Double, altura: Double): Double {

        var alturaEmcm : Double = altura * 100

        var resultado : Double

        if (ehSexoMasculino()){

            resultado = (alturaEmcm - 100) * 0.9

        }else if (ehSexoFeminino()){

            resultado = (alturaEmcm - 100) * 0.85
        }else {

            resultado = 0.0
        }
        return resultado;
    }

    fun ehSexoMasculino(): Boolean{

        return genero == Sexo.MASCULINO
    }

    fun ehSexoFeminino(): Boolean{

        return  genero == Sexo.FEMININO
    }

     fun classificacaoImc(imc: Double): String{

        var retorno : String

        if (imc < 16){

            retorno = "Baixo peso muito grave!"
        }else if ((imc >= 16) and (imc < 17)){

            retorno = "Baixo peso grave!"
        }else if ((imc >= 17) and (imc < 18.5)){

            retorno = "Baixo Peso!"
        }else if ((imc >= 18.5) and (imc < 25)){

            retorno = "Peso normal!"
        }else if ((imc >= 25) and (imc < 30)){

            retorno = "Sobre Peso!"
        }else if ((imc >= 30) and (imc < 35)){

            retorno = "Obesidade grau I!"
        }else if ((imc >= 35) and (imc < 40)){

            retorno = "Obesidade grau II!"
        } else if (imc >40){

            retorno = "Obesidade grau III!"
        }else {

            retorno = "Ocorreu algum erro!"
        }

         return retorno
    }
}