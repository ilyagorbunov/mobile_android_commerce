package ecom.app.com.ecomerceappkotlin

import android.app.DownloadManager
import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.RequestQueue
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var sharedP: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetData.setOnClickListener{

            val serverURL: String = "http://192.168.43.249/ecom/test_file.php"
            val requestQ: RequestQueue = Volley.newRequestQueue(this@MainActivity)
            val stringRequest = StringRequest(Request.Method.GET, serverURL,

                Response.Listener { response ->

                txtHelloWorld.text = response

                }, Response.ErrorListener {error ->

                    txtHelloWorld.text = error.message

                })

            requestQ.add(stringRequest)
        }
    }
}
