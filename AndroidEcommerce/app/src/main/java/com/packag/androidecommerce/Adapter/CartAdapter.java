package com.packag.androidecommerce.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.packag.androidecommerce.Database.ModelDB.Cart;
import com.packag.androidecommerce.R;
import com.packag.androidecommerce.Utils.Common;
import com.squareup.picasso.Picasso;

import java.util.List;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{

    Context context;
    List<Cart> cartList;

    public CartAdapter(Context context, List<Cart> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.cart_item_layout,parent,false);
        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, final int position) {
        Picasso.with(context)
                .load(cartList.get(position).link)
                .into(holder.img_product);

        holder.txt_amount.setNumber(String.valueOf(cartList.get(position).amount));
        holder.txt_price.setText(new StringBuilder("Rp.").append(cartList.get(position).price));
        holder.txt_product_name.setText(cartList.get(position).name);
        holder.txt_sugar_ice.setText(new StringBuilder("Sugar: ")
                .append(cartList.get(position).sugar).append("%").append("\n")
                .append("Ice: ").append(cartList.get(position).ice)
                .append("%").toString());

        holder.txt_amount.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                Cart cart = cartList.get(position);
                cart.amount = newValue;

                Common.cartRepository.updateCart(cart);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img_product;
        TextView txt_product_name, txt_sugar_ice, txt_price;
        ElegantNumberButton txt_amount;

        public CartViewHolder(View itemView) {
            super(itemView);

            img_product = (ImageView)itemView.findViewById(R.id.img_product);
            txt_amount = (ElegantNumberButton)itemView.findViewById(R.id.txt_amount);
            txt_product_name = (TextView)itemView.findViewById(R.id.txt_product_name);
            txt_sugar_ice = (TextView)itemView.findViewById(R.id.txt_sugar_ice);
            txt_price = (TextView)itemView.findViewById(R.id.txt_price);
        }
    }

}
