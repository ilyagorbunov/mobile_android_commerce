package com.packag.ecommerceappkotlin

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_show_all_jsonobjects.*

class ShowAllJSONObjectsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_jsonobjects)

        txtAllProducts.setBackgroundColor(Color.BLUE)
        txtAllProducts.setTextColor(Color.WHITE)

        txtAllProducts.setOnClickListener(){
            val allProductsURL = "http://192.168.1.35/ecommerc/present_json_array.php"
            var allProductsString: String = ""
            val requestQ: RequestQueue = Volley.newRequestQueue(this@ShowAllJSONObjectsActivity)

            val jsonAR = JsonArrayRequest(Request.Method.GET, allProductsURL, null,
                Response.Listener { response ->

                    for (productIndex in 0.until(response.length())){

//                      allProductsString +=
//                        allProductsString = allProductsString +
//                                response.getJSONObject(productIndex).getString(
//                                    "name") + " - " +
//                                response.getJSONObject(productIndex).getString(
//                                    "price")
                        var pn = response.getJSONObject(productIndex).getString("name")
                        var pp = response.getJSONObject(productIndex).getInt("price")

                        allProductsString = allProductsString + pn + " - " + pp + "\n"
                    }

                    txtAllProducts.text = allProductsString

                }, Response.ErrorListener { error ->

                    txtAllProducts.text = error.message
                })

            requestQ.add(jsonAR)

        }
    }
}
