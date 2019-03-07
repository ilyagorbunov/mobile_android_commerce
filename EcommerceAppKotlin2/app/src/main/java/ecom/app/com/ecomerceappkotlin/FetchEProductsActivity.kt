package ecom.app.com.ecomerceappkotlin

import android.app.AlertDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.Volley

class FetchEProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch_eproducts)

        val selectedBrand:String = intent.getStringExtra("BRAND")

        var productsList = ArrayList<EProduct>()

        val productsURL = "http://192.168.43.249/store/fetch_eproducts.php?brand=$selectedBrand"
        val requestQ = Volley.newRequestQueue(this@FetchEProductsActivity)
        val jsonAR = JsonArrayRequest(Request.Method.GET, productsURL, null, Response.Listener 
        { response ->  

            for (productJOIndex in 0.until(response.length())){

                productsList.add(EProduct(
                    response.getJSONObject(productJOIndex).getInt("id"),
                    response.getJSONObject(productJOIndex).getString("name"),
                    response.getJSONObject(productJOIndex).getInt("price"),
                    response.getJSONObject(productJOIndex).getString("picture")))

            }
            
        }, Response.ErrorListener { error ->

            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setTitle("Message")
            dialogBuilder.setMessage(error.message)
            dialogBuilder.create().show()

        })

    }
}
