package com.example.imckotlin.activity

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.imckotlin.R
import com.example.imckotlin.emun.Sexo
import com.example.imckotlin.model.Imc

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCalculaImc: Button
    private lateinit var inputTextPeso: EditText
    private lateinit var inputTextAltura: EditText
    private lateinit var radioButtonMasculino: RadioButton
    private lateinit var radioButtonFeminino: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instaciaLayoutComXml()
    }

    private fun instaciaLayoutComXml() {

        this.buttonCalculaImc = findViewById(R.id.buttonCalcular)
        this.inputTextPeso = findViewById(R.id.editTextPeso)
        this.inputTextAltura = findViewById(R.id.editTextAltura)
        this.radioButtonMasculino = findViewById(R.id.radioButtonMasculino)
        this.radioButtonFeminino = findViewById(R.id.radioButtonFeminino)
    }

    fun calculaImcQuandoBotaoForClicado(view : View) {

        if (validaCampos()) {

            criaAlertDialog()
        }
    }

    private fun criaAlertDialog() {

        var builder = AlertDialog.Builder(this)
        builder.setTitle("Resultado Imc")

        var resultadoImc = calculaImcPessoa()

        var classificacaoImc = criaInstanciaDoImc().classificacaoImc(resultadoImc)

        var pesoIdeal = criaInstanciaDoImc().pesoIdeal(inputTextPeso.text.toString().toDouble()
            ,inputTextAltura.text.toString().toDouble())

        builder.setMessage("Imc =  $classificacaoImc" + "\nPeso ideal = $pesoIdeal " )
        builder.setCancelable(false)
        builder.setPositiveButton("Ok") { dialog: DialogInterface?, which: Int -> }
        builder.show()
    }

    private fun calculaImcPessoa(): Double {

        return criaInstanciaDoImc().calculaImc()
    }

    private fun criaInstanciaDoImc(): Imc {

        return Imc(
            this.inputTextPeso.text.toString().toDouble(),
            this.inputTextAltura.text.toString().toDouble(),
            verificaSexo()
        )
    }

    private fun verificaSexo(): Sexo {

        return if (ehSexoMasculino()) {

            Sexo.MASCULINO
        } else {

            Sexo.FEMININO
        }
    }

    private fun validaCampos(): Boolean {
        var retorno = true

        if (inputTextPeso.text.trim().isEmpty()) {

            inputTextPeso.error = "Campo Obrigatório!"
            retorno = false
        }

        if (this.inputTextAltura.text.trim().isEmpty()) {

            this.inputTextAltura.error = "Campo Obrigatório!"
            retorno = false
        }

        if (ehSexoMasculino() or ehSexoFeminino()) {

        } else {

            Toast.makeText(
                this,
                "Informe Genero",
                Toast.LENGTH_SHORT
            ).show()
            retorno = false
        }

        return retorno;
    }

    private fun ehSexoMasculino(): Boolean {

        return this.radioButtonMasculino.isChecked
    }

    private fun ehSexoFeminino(): Boolean {

        return this.radioButtonFeminino.isChecked
    }
}
