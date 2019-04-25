package com.packag.androidecommerce.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
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

    private void showAddToCartDialog(final int position) {
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

        rdiSizeM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Common.sizeOfCup=0;
            }
        });

        rdiSizeL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Common.sizeOfCup=1;
            }
        });

        RadioButton rdiSugar100=itemView.findViewById(R.id.rdi_sugar100);
        RadioButton rdiSugar70=itemView.findViewById(R.id.rdi_sugar70);
        RadioButton rdiSugar50=itemView.findViewById(R.id.rdi_sugar50);
        RadioButton rdiSugar30=itemView.findViewById(R.id.rdi_sugar30);
        RadioButton rdiSugarfree=itemView.findViewById(R.id.rdi_sugarfree);

        rdiSugar30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Common.sugar=30;
            }
        });

        rdiSugar50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Common.sugar=50;
            }
        });

        rdiSugar70.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Common.sugar=70;
            }
        });

        rdiSugar100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Common.sugar=100;
            }
        });

        rdiSugarfree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Common.sugar=0;
            }
        });

        RadioButton rdiIce100=itemView.findViewById(R.id.rdi_ice100);
        RadioButton rdiIce70=itemView.findViewById(R.id.rdi_ice70);
        RadioButton rdiIce50=itemView.findViewById(R.id.rdi_ice50);
        RadioButton rdiIce30=itemView.findViewById(R.id.rdi_ice30);
        RadioButton rdiIcefree=itemView.findViewById(R.id.rdi_icefree);

        rdiIce30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Common.ice=30;
            }
        });

        rdiIce50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Common.ice=50;
            }
        });


        rdiIce70.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Common.ice=70;
            }
        });

        rdiIce100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Common.ice=100;
            }
        });

        rdiIcefree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Common.ice=0;
            }
        });

        RecyclerView recyclerTopping = itemView.findViewById(R.id.recycler_topping);
        recyclerTopping.setLayoutManager(new LinearLayoutManager(context));
        recyclerTopping.setHasFixedSize(true);

        MultiChoiceAdapter adapter = new MultiChoiceAdapter(context, Common.toppingList);
        recyclerTopping.setAdapter(adapter);

        // Set Data
        Picasso.with(context)
                .load(drinkList.get(position).Link)
                .into(imgproductdialogue);
        txtProductDialogue.setText(drinkList.get(position).Name);

        builder.setView(itemView);
        builder.setNegativeButton("Add To Cart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(Common.sizeOfCup==-1)
                {
                    Toast.makeText(context, "Please Choose Size Of Cup", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Common.sugar==-1)
                {
                    Toast.makeText(context, "Please Choose Sugar", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Common.ice==-1)
                {
                    Toast.makeText(context, "Please Choose Ice", Toast.LENGTH_SHORT).show();
                    return;
                }
                showConfirmDialog(position,txtCount.getNumber(), Common.sizeOfCup, Common.sugar, Common.ice);
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void showConfirmDialog(int position, String number, int sizeOfCup, int sugar, int ice) {
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        View itemView=LayoutInflater.from(context)
                .inflate(R.layout.confirm_add_to_cart_layout,null);

        // View
        ImageView img_product_dialog=itemView.findViewById(R.id.img_product);
        TextView txt_product_dialog= itemView.findViewById(R.id.txt_cart_product_name);
        TextView txt_product_price=itemView.findViewById(R.id.txt_cart_product_price);
        TextView txt_sugar=itemView.findViewById(R.id.txt_sugar);
        TextView txt_ice=itemView.findViewById(R.id.txt_ice);
        TextView txt_topping_extra=itemView.findViewById(R.id.txt_topping_extra);

        // Set Data
        Picasso.with(context).load(drinkList.get(position).Link).into(img_product_dialog);
        txt_product_dialog.setText(new StringBuilder(drinkList.get(position).Name).append(" x")
                .append(number)
                .append(Common.sizeOfCup == 0 ? " Size M":" Size L").toString());

        txt_ice.setText(new StringBuilder("Ice: ").append(Common.ice).append("%").toString());
        txt_sugar.setText(new StringBuilder("Sugar: ").append(Common.sugar).append("%").toString());

        double price=(Double.parseDouble(drinkList.get(position).Price)* Double.parseDouble(number))
                + Common.toppingPrice;

        if(Common.sizeOfCup==1) //SizeL
            price+=(3.0)*Double.parseDouble(number);

        txt_product_price.setText(new StringBuilder("Rp").append(price));


        StringBuilder topping_final_comment=new StringBuilder("");
        for(String line:Common.toppingAdded)
            topping_final_comment.append(line).append("\n");

        txt_topping_extra.setText(topping_final_comment);

        builder.setNegativeButton("CONFIRM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        builder.setView(itemView);
        builder.show();

    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }
}
