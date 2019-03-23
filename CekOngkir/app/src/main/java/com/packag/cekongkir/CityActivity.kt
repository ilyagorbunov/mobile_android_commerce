package com.packag.cekongkir

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.error.ANError
import org.json.JSONObject
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority


class CityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        getCity()

        supportActionBar!!.setTitle("Pilih Kota")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    fun getCity(){
        AndroidNetworking.get("https://api.rajaongkir.com/starter/city")
            .addHeaders("key", "e2d1393065a094cb4225c85b2bb8a4fa")
            .setTag("test")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    // do anything with response
                    Log.e("_response", response.toString())
                }

                override fun onError(error: ANError) {
                    // handle error
                }
            })
    }
}
