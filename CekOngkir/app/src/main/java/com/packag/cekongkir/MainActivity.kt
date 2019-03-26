package com.packag.cekongkir

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.SimpleAdapter
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.packag.cekongkir.data.Api
import com.packag.cekongkir.data.Constant
import com.packag.cekongkir.data.Prefs
import com.packag.cekongkir.utils.Converter
import kotlinx.android.synthetic.main.activity_city.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.adapter_city.view.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    val arrayList = ArrayList<HashMap<String, String>>()

    var prefs: Prefs? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = Prefs(this)

        editOrigin.setText(prefs!!.originName)
        editDestination.setText((prefs!!.destinationName))

        Constant.ORIGIN_ID = prefs!!.originId
        Constant.DEST_ID = prefs!!.destinationId

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

                prefs!!.originId = Constant.ORIGIN_ID
                prefs!!.originName = Constant.ORIGIN_NAME

            } false -> {
                editDestination.setText(Constant.DEST_NAME)

                prefs!!.destinationId = Constant.DEST_ID
                prefs!!.destinationName = Constant.DEST_NAME
            }
        }
    }

    fun getCost(){

        arrayList.clear()
        listCekOngkir.adapter = null
        progressBarCekOngkir.visibility = VISIBLE

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

                            val service:String = costsObject["service"].toString()
                            val description:String = costsObject["service"].toString()

                            val costArray = costsObject.getJSONArray("cost")
                            for (k in 0 until costArray.length()){
                                val costObject = costArray.getJSONObject(k)

                                Log.e("_logValue", costObject["value"].toString())

                                val map = HashMap<String, String>()
                                map["code"] = code
                                map["service"] = service
                                map["description"] = description
                                map["value"] = "IDR " + Converter.rupiah(costObject["value"].toString().toDouble())
                                map["etd"] = costObject["etd"].toString() + "hari"
                                arrayList.add(map)
                            }
                        }
                    }

                    progressBarCekOngkir.visibility = GONE
                    setAdapter()

                }

                override fun onError(error: ANError) {
                    // handle error
                }
            })

    }

    fun setAdapter(){
        val simpleAdapter = SimpleAdapter(this, arrayList, R.layout.adapter_main,
            arrayOf("code", "service", "description", "value", "etd"),
            intArrayOf(R.id.txtCode, R.id.txtService, R.id.txtDescription, R.id.txtValue, R.id.txtEtd))

        listCekOngkir.adapter = simpleAdapter




    }
}
