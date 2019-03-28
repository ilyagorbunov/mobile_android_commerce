package com.packag.onlinestorekotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SignUpLayout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_layout)

        supportActionBar!!.setTitle("Sign Up")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }
}
