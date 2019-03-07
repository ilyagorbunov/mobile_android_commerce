package ecom.app.com.ecomerceappkotlin

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        var brandsURL = "http://192.168.43.249/store/fetch_brands.php"

        var brandsList = ArrayList<String>()

        var requestQ = Volley.newRequestQueue(this@HomeScreen)

        var jsonAR = JsonArrayRequest(Request.Method.GET, brandsURL, null, Response.Listener
        { response ->

            for (jsonObject in 0.until(response.length())) {
                brandsList.add(response.getJSONObject(jsonObject).getString("brand"))
            }

            var brandsListAdapter = ArrayAdapter(this@HomeScreen, android.R.layout.simple_list_item_1, brandsList)
            brandsListView.adapter = brandsListAdapter

        }, Response.ErrorListener { error ->

            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setTitle("Message")
            dialogBuilder.setMessage(error.message)
            dialogBuilder.create().show()

        })

        requestQ.add(jsonAR)

    }
}
