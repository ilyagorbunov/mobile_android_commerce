package com.packag.cekongkir

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SimpleAdapter
import com.androidnetworking.error.ANError
import org.json.JSONObject
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.packag.cekongkir.data.Api
import kotlinx.android.synthetic.main.activity_city.*


class CityActivity : AppCompatActivity() {

    var arrayList = ArrayList<HashMap<String, String>>()

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
        AndroidNetworking.get(Api.CITY)
            .addHeaders("key", Api.KEY)
            .setTag("test")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    // do anything with response
                    Log.e("_response", response.toString())

                    val jsonObject = response.getJSONObject("rajaongkir")
                    val jsonArray = jsonObject.getJSONArray("results")
                }

                override fun onError(error: ANError) {
                    // handle error
                }
            })
    }

    fun setAdapter(){
        val simpleAdapter = SimpleAdapter(this, arrayList, R.layout.adapter_city,
            arrayOf("id", "name"), intArrayOf(R.id.txtId, R.id.txtName))

        listView.adapter = simpleAdapter
    }
}
