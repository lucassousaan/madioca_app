package com.lucas.mandiocadafazenda.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucas.mandiocadafazenda.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bt_login.setOnClickListener {
            if (et_email.text.isNullOrEmpty()) {
                til_email.error = "Preencha o e-mail"
            } else if (et_password.text.isNullOrEmpty()) {
                til_password.error = "Preencha a senha"
            } else {
                til_email.error = null
                til_password.error = null
                if (et_email.text.toString() == "producao@email.com") {
                    startActivity(Intent(this, MainProducaoActivity::class.java))
                    finish()
                } else if (et_email.text.toString() == "entregador@email.com") {
                    startActivity(Intent(this, MainEntregadorActivity::class.java))
                    finish()
                } else {
                    til_email.error = "E-mail inválido"
                }
            }
        }
    }
}
