package com.packag.cekongkir

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.packag.cekongkir.data.Api
import com.packag.cekongkir.data.Constant
import kotlinx.android.synthetic.main.activity_city.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

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

        btnCekOngkir.setOnClickListener{
            if(Constant.ORIGIN_ID.isBlank()|| Constant.DEST_ID.isBlank())
                Toast.makeText(applicationContext, "Isi data dengan benar", Toast.LENGTH_SHORT).show()
            else
                getCost()
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

    fun getCost(){
        AndroidNetworking.post(Api.COST)
            .addHeaders("key", Api.KEY)
            .addBodyParameter("origin", Constant.ORIGIN_ID)
            .addBodyParameter("destination", Constant.DEST_ID)
            .addBodyParameter("weight", "1000")
            .addBodyParameter("courier", "jne")
            .setTag("test")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    // do anything with response
                    Log.e("_responseCost", response.toString())

                    val rajaongkirObject = response.getJSONObject("rajaongkir")
                    val resultsArray = rajaongkirObject.getJSONArray("results")

                    for(i in 0 until resultsArray.length()){
                        val resultsObject = resultsArray.getJSONObject(i)
                        Log.e("_logCode", resultsObject["code"].toString())

                        val code:String = resultsObject["code"].toString().toUpperCase()

                        val costsArray = resultsObject.getJSONArray("costs")
                        for (j in 0 until costsArray.length()){
                            val costsObject = costsArray.getJSONObject(j)
                            Log.e("_logService", costsObject["service"].toString())

                            val costArray = costsObject.getJSONArray("cost")
                            for (k in 0 until costArray.length()){
                                val costObject = costArray.getJSONObject(k)

                                Log.e("_logValue", costObject["value"].toString())
                            }


                        }
                    }


                }

                override fun onError(error: ANError) {
                    // handle error
                }
            })

    }
}
