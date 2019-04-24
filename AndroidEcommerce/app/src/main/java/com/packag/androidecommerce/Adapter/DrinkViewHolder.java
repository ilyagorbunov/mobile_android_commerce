package com.packag.androidecommerce.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.packag.androidecommerce.Interface.ItemClickListener;
import com.packag.androidecommerce.R;

public class DrinkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView img_product;
    TextView txt_drink_name, txt_price;

    ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public DrinkViewHolder(View itemView){
        super(itemView);

        img_product=itemView.findViewById(R.id.imageproduct);
        txt_drink_name=itemView.findViewById(R.id.txt_drink_name);
        txt_price=itemView.findViewById(R.id.txt_price);

    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v);

    }

}
