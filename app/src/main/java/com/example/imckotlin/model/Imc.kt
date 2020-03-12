package com.example.imckotlin.model

import com.example.imckotlin.R
import com.example.imckotlin.emun.Sexo

class Imc(peso: Double, altura: Double, genero: Sexo) {

    private var peso: Double = peso
    private var altura: Double = altura
    private var genero: Sexo = genero


    fun calculaImc() = peso / (altura * altura)

    fun pesoIdeal(peso: Double, altura: Double): Double {
        var alturaEmcm: Double = altura * 100
        var resultado: Double

        if (ehSexoMasculino()) {
            resultado = (alturaEmcm - 100) * 0.9
        } else if (ehSexoFeminino()) {
            resultado = (alturaEmcm - 100) * 0.85
        } else {
            resultado = 0.0
        }
        return resultado;
    }

    fun ehSexoMasculino(): Boolean {
        return genero == Sexo.MASCULINO
    }

    fun ehSexoFeminino(): Boolean {
        return genero == Sexo.FEMININO
    }

    fun classificacaoImc(imc: Double): Int {

        return when {
            imc < 16 -> R.string.baixoPesoMuitoGrave
            imc < 17 -> R.string.baixoPesoGrave
            imc < 18.50 -> R.string.baixoPeso
            imc < 25 -> R.string.pesoNormal
            imc < 30 -> R.string.sobrepeso
            imc < 35 -> R.string.obesidadeGrauI
            imc < 40 -> R.string.obesidadeGrauII
            else -> R.string.obesidadeGrauIII
        }
    }
}