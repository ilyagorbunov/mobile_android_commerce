package app.com.rentalerbe.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import app.com.rentalerbe.Interface.ItemClickListener;
import app.com.rentalerbe.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView img_product;
    TextView txt_product_name, txt_price;

    ItemClickListener itemClickListener;

    ImageView btn_add_to_cart, btn_favorite;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public ProductViewHolder(View itemView) {
        super(itemView);

        img_product = (ImageView)itemView.findViewById(R.id.image_product);
        txt_product_name = (TextView)itemView.findViewById(R.id.txt_product_name);
        txt_price = (TextView)itemView.findViewById(R.id.txt_price);
        btn_add_to_cart = (ImageView) itemView.findViewById(R.id.btn_add_cart);
        btn_favorite = (ImageView) itemView.findViewById(R.id.btn_favorite);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v);
    }
}
