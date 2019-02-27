package com.packag.ecommerceappkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class RVAdapter(contect: Context, arrayList: ArrayList<EProduct>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    inner class ProductViewHolder(myView: View)
        : RecyclerView.ViewHolder(myView){

        var pIDTextView = myView.findViewById<TextView>(R.id.rv_row_pID)
        var pNameTextView = myView.findViewById<TextView>(R.id.rv_row_pName)
        var pPriceTextView = myView.findViewById<TextView>(R.id.rv_row_pPrice)
        var pImageView = myView.findViewById<ImageView>(R.id.rv_row_productImage)

        fun initializedUIComponents(pID: Int, pName: String, pPrice: Int, pPicture: Int){

            pIDTextView.text = pID.toString()
            pNameTextView.text = pName
            pPriceTextView.text = pPrice.toString()
            pImageView.setImageResource(pPicture)

        }
    }
}