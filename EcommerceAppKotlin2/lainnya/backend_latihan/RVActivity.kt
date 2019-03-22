package ecom.app.com.ecomerceappkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_rv.*

class RVActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)

        var myProductList = ArrayList<EProduct>()
        myProductList.add(EProduct(0, "iPhone", 1000,
            R.drawable.iphone))
        myProductList.add(EProduct(0, "Macbook Air", 2000,
            R.drawable.macbookair))
        myProductList.add(EProduct(0, "iMac", 1500,
            R.drawable.imac))
        myProductList.add(EProduct(0, "iPod Nano", 500,
            R.drawable.ipodnano))
        myProductList.add(EProduct(0, "iPad", 3000,
            R.drawable.ipad))

        var rvAdapter = RVAdapter(this@RVActivity, myProductList)

        recyclerView.layoutManager =
                LinearLayoutManager(this@RVActivity)
        recyclerView.adapter = rvAdapter

    }
}
