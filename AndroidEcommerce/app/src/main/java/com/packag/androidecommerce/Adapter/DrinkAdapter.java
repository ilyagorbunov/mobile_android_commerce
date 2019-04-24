package com.packag.androidecommerce.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.facebook.accountkit.ui.ContentControllerBase;
import com.packag.androidecommerce.Interface.ItemClickListener;
import com.packag.androidecommerce.Model.Drink;
import com.packag.androidecommerce.R;
import com.packag.androidecommerce.Utils.Common;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkViewHolder>{

    Context context;
    List<Drink> drinkList;

    public DrinkAdapter(Context context, List<Drink> drinkList) {
        this.context = context;
        this.drinkList = drinkList;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.drink_item_layout, null);

        return new DrinkViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, final int position) {

        holder.txt_price.setText(new StringBuilder("Rp").append(drinkList.get(position).Price).toString());
        holder.txt_drink_name.setText(drinkList.get(position).Name);

        holder.btn_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddToCartDialog(position);
            }
        });
        Picasso.with(context)
                .load(drinkList.get(position).Link)
                .into(holder.img_product);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showAddToCartDialog(int position) {
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        View itemView=LayoutInflater.from(context)
                .inflate(R.layout.add_to_cart_layout,null);

        //View

        ImageView imgproductdialogue=itemView.findViewById(R.id.img_cart_product);
        final ElegantNumberButton txtCount=itemView.findViewById(R.id.txt_count);
        TextView txtProductDialogue=itemView.findViewById(R.id.txt_cart_productname);

        EditText edtComment=itemView.findViewById(R.id.edt_comment);

        RadioButton rdiSizeM=itemView.findViewById(R.id.rdi_sizeM);
        RadioButton rdiSizeL=itemView.findViewById(R.id.rdi_sizeL);

        RadioButton rdiSugar100=itemView.findViewById(R.id.rdi_sugar100);
        RadioButton rdiSugar70=itemView.findViewById(R.id.rdi_sugar70);
        RadioButton rdiSugar50=itemView.findViewById(R.id.rdi_sugar50);
        RadioButton rdiSugar30=itemView.findViewById(R.id.rdi_sugar30);
        RadioButton rdiSugarfree=itemView.findViewById(R.id.rdi_sugarfree);

        RadioButton rdiIce100=itemView.findViewById(R.id.rdi_ice100);
        RadioButton rdiIce70=itemView.findViewById(R.id.rdi_ice70);
        RadioButton rdiIce50=itemView.findViewById(R.id.rdi_ice50);
        RadioButton rdiIce30=itemView.findViewById(R.id.rdi_ice30);
        RadioButton rdiIcefree=itemView.findViewById(R.id.rdi_icefree);

        // Set Data
        Picasso.with(context)
                .load(drinkList.get(position).Link)
                .into(imgproductdialogue);
        txtProductDialogue.setText(drinkList.get(position).Name);

        builder.setView(itemView);
        builder.setNegativeButton("Add To Cart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }
}
