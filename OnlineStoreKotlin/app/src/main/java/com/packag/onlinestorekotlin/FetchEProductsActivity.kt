package com.packag.onlinestorekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class FetchEProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch_eproducts)

        val selectedBrand:String = intent.getStringExtra("BRAND")

        val productsUrl = "http://192.168.43.103/ecommerc/fetch_eproducts.php?brand=$selectedBrand"

        val productsList = ArrayList<EProduct>()

        val requestQ = Volley.newRequestQueue(this@FetchEProductsActivity)
        val jsonAR = JsonArrayRequest(Request.Method.GET, productsUrl, null,
            Response.Listener { response ->

                for (productJOIndex in 0.until(response.length())){

                    productsList.add(EProduct(
                        response.getJSONObject(productJOIndex).getInt("id"),
                        response.getJSONObject(productJOIndex).getString("name"),
                        response.getJSONObject(productJOIndex).getInt("price"),
                        response.getJSONObject(productJOIndex).getString("picture")
                        )
                    )
                }

            }, Response.ErrorListener { error ->
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setTitle("Message")
                dialogBuilder.setMessage(error.message)
                dialogBuilder.create().show()

            })


    }
}
