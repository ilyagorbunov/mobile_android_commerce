package com.packag.onlinestorekotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up_layout.*

class SignUpLayout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_layout)

        supportActionBar!!.setTitle("Sign Up")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btnSignUp.setOnClickListener() {

            if (edtSignUpPassword.text.toString().equals(
                    edtSignUpConfirmPassword.text.toString())){

                // registration

            } else {
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setTitle("Message")
                dialogBuilder.setMessage("Password Mismatch")
                dialogBuilder.create().show()

            }

        }
    }
}
