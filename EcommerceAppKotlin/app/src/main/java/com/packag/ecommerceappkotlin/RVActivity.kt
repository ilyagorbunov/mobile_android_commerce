package com.packag.ecommerceappkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_rv.*

class RVActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)

        var myProductList = ArrayList<EProduct>()
        myProductList.add(
            EProduct(0, "iPhone", 1000,
            R.drawable.iphone))
        myProductList.add(EProduct(1, "iPad", 2000,
            R.drawable.ipad))
        myProductList.add(EProduct(2, "MacPro", 3000,
            R.drawable.macpro))
        myProductList.add(EProduct(3, "MacBookAir", 4500,
            R.drawable.macbookair))
        myProductList.add(EProduct(4, "MacBookPro", 500,
            R.drawable.macbookpro))
        myProductList.add(EProduct(5, "MacPro", 3000,
            R.drawable.macpro))
        myProductList.add(EProduct(6, "MacBookAir", 4500,
            R.drawable.macbookair))
        myProductList.add(EProduct(7, "MacBookPro", 500,
            R.drawable.macbookpro))

        var rvAdapter = RVAdapter(this@RVActivity, myProductList)

        recyclerView.layoutManager =
                LinearLayoutManager(this@RVActivity )

        recyclerView.adapter = rvAdapter



    }
}
