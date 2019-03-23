package com.packag.cekongkir

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.packag.cekongkir.data.Constant
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editOrigin.setOnClickListener{
            Constant.ORIGIN = true
            startActivity(Intent(this, CityActivity::class.java))
        }

        editDestination.setOnClickListener{
            Constant.ORIGIN = false
            startActivity(Intent(this, CityActivity::class.java))
        }
    }

    override fun onResume(){
        super.onResume()
        when(Constant.ORIGIN){
            true -> {
                editOrigin.setText( Constant.ORIGIN_NAME)
            } false -> {
                editDestination.setText(Constant.DEST_NAME)
            }
        }
    }
}
