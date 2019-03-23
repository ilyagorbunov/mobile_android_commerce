package com.packag.cekongkir

import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
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
        google_progress.visibility = VISIBLE
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

                    Log.e("_count", jsonArray.length().toString())

                    for (i in 0 until jsonArray.length()){
                        val jsonObject1 = jsonArray.getJSONObject(i)
                        Log.e("_province", jsonObject1.getString("province"))

                        val map = HashMap<String, String>()
                        map["id"] = jsonObject1.getString("city_id")
                        map["name"] = jsonObject1.getString("city_name")
                        arrayList.add(map)
                    }

                    google_progress.visibility = GONE
                    setAdapter()
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

        pencarianKota.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                simpleAdapter.getFilter().filter(pencarianKota.text)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })
    }
}
