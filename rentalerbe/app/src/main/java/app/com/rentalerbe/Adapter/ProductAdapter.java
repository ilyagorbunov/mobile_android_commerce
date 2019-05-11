package app.com.rentalerbe.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import app.com.rentalerbe.Database.ModelDB.Cart;
import app.com.rentalerbe.Database.ModelDB.Favorite;
import app.com.rentalerbe.Interface.ItemClickListener;
import app.com.rentalerbe.Model.Product;
import app.com.rentalerbe.R;
import app.com.rentalerbe.Utils.Common;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    Context context;
    List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.product_item_layout, null);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, final int position) {

        holder.txt_price.setText(new StringBuffer("Rp.").append(productList.get(position).Price).toString());
        holder.txt_product_name.setText(productList.get(position).Name);

        holder.btn_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddToCartDialog(position);
            }
        });

        Picasso.with(context)
                .load(productList.get(position).Link)
                .into(holder.img_product);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Favorite System
        if(Common.favoriteRepository.isFavorite(Integer.parseInt(productList.get(position).ID))==1)
            holder.btn_favorite.setImageResource(R.drawable.ic_favorite_black_24dp);
        else
            holder.btn_favorite.setImageResource(R.drawable.ic_favorite_border_black_24dp);

        holder.btn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Common.favoriteRepository.isFavorite(Integer.parseInt(productList.get(position).ID))!=1) {
                    addOrRemoveFavorite(productList.get(position),true);
                    holder.btn_favorite.setImageResource(R.drawable.ic_favorite_black_24dp);
                }
                else {
                    addOrRemoveFavorite(productList.get(position),false);
                    holder.btn_favorite.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                }
            }
        });

    }

    private void addOrRemoveFavorite(Product product, boolean isAdd) {
        Favorite favorites = new Favorite();
        favorites.id = product.ID;
        favorites.link = product.Link;
        favorites.name = product.Name;
        favorites.price = product.Price;
        favorites.menuId = product.MenuId;

        if(isAdd)
            Common.favoriteRepository.insertFav(favorites);
        else
            Common.favoriteRepository.delete(favorites);
    }

    private void showAddToCartDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.add_to_cart_layout, null);

        ImageView img_product_dialog = (ImageView)itemView.findViewById(R.id.img_cart_product);
        final ElegantNumberButton txt_count = (ElegantNumberButton)itemView.findViewById(R.id.txt_count);
        TextView txt_product_dialog = (TextView)itemView.findViewById(R.id.txt_cart_product_name);

        EditText edt_comment = (EditText)itemView.findViewById(R.id.edt_comment);

        RadioButton rdi_sizeM = (RadioButton)itemView.findViewById(R.id.rdi_sizeM);
        RadioButton rdi_sizeL = (RadioButton)itemView.findViewById(R.id.rdi_sizeL);

        rdi_sizeM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sizeofCup = 0;
            }
        });

        rdi_sizeL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sizeofCup = 1;
            }
        });

        RadioButton rdi_sugar_100 = (RadioButton)itemView.findViewById(R.id.rdi_sugar_100);
        RadioButton rdi_sugar_70 = (RadioButton)itemView.findViewById(R.id.rdi_sugar_70);
        RadioButton rdi_sugar_50 = (RadioButton)itemView.findViewById(R.id.rdi_sugar_50);
        RadioButton rdi_sugar_30 = (RadioButton)itemView.findViewById(R.id.rdi_sugar_30);
        RadioButton rdi_sugar_free = (RadioButton)itemView.findViewById(R.id.rdi_sugar_free);

        rdi_sugar_100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 100;
            }
        });

        rdi_sugar_70.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 70;
            }
        });

        rdi_sugar_50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 50;
            }
        });

        rdi_sugar_30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 30;
            }
        });

        rdi_sugar_free.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.sugar = 0;
            }
        });

        RadioButton rdi_ice_100 = (RadioButton)itemView.findViewById(R.id.rdi_ice_100);
        RadioButton rdi_ice_70 = (RadioButton)itemView.findViewById(R.id.rdi_ice_70);
        RadioButton rdi_ice_50 = (RadioButton)itemView.findViewById(R.id.rdi_ice_50);
        RadioButton rdi_ice_30 = (RadioButton)itemView.findViewById(R.id.rdi_ice_30);
        RadioButton rdi_ice_free = (RadioButton)itemView.findViewById(R.id.rdi_ice_free);

        rdi_ice_100.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.ice = 100;
            }
        });

        rdi_ice_70.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.ice = 70;
            }
        });

        rdi_ice_50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.ice = 50;
            }
        });

        rdi_ice_30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.ice = 30;
            }
        });

        rdi_ice_free.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Common.ice = 0;
            }
        });

        RecyclerView recycler_tambah = (RecyclerView)itemView.findViewById(R.id.recycler_tambah);
        recycler_tambah.setLayoutManager(new LinearLayoutManager(context));
        recycler_tambah.setHasFixedSize(true);

        MultiChoiceAdapter adapter = new MultiChoiceAdapter(context, Common.tambahList);
        recycler_tambah.setAdapter(adapter);

        Picasso.with(context)
                .load(productList.get(position).Link)
                .into(img_product_dialog);
        txt_product_dialog.setText(productList.get(position).Name);

        builder.setView(itemView);
        builder.setNegativeButton("ADD TO CART", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                if (Common.sizeofCup == -1)
                {
                    Toast.makeText(context, "Please choose size of cup", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Common.sugar == -1)
                {
                    Toast.makeText(context, "Please choose sugar", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Common.ice == -1)
                {
                    Toast.makeText(context, "Please choose ice", Toast.LENGTH_SHORT).show();
                    return;
                }

                showConfirmDialog(position, txt_count.getNumber());
                dialog.dismiss();
            }
        });

        builder.show();

    }

    private void showConfirmDialog(final int position, final String number) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.confirm_add_to_cart_layout, null);

        ImageView img_product_dialog = (ImageView)itemView.findViewById(R.id.img_product);
        final TextView txt_product_dialog = (TextView)itemView.findViewById(R.id.txt_cart_product_name);
        TextView txt_product_price = (TextView)itemView.findViewById(R.id.txt_cart_product_price);
        TextView txt_sugar = (TextView)itemView.findViewById(R.id.txt_sugar);
        TextView txt_ice = (TextView)itemView.findViewById(R.id.txt_ice);
        final TextView txt_tambah_extra = (TextView)itemView.findViewById(R.id.txt_tambah_extra);

        Picasso.with(context).load(productList.get(position).Link).into(img_product_dialog);
        txt_product_dialog.setText(new StringBuilder(productList.get(position).Name).append(" x")
        .append(Common.sizeofCup == 0 ? " Size M":" Size L")
        .append(number).toString());

        txt_ice.setText(new StringBuilder("Ice : ").append(Common.ice).append("%").toString());
        txt_sugar.setText(new StringBuilder("Sugar : ").append(Common.sugar).append("%").toString());

        double price = (Double.parseDouble(productList.get(position).Price) * Double.parseDouble(number)) + Common.tambahPrice;

        if (Common.sizeofCup == 1)
            price += (3.0 * Double.parseDouble(number));

        StringBuilder tambah_final_comment = new StringBuilder("");
        for (String line:Common.tambahAdded)
            tambah_final_comment.append(line).append("\n");

        txt_tambah_extra.setText(tambah_final_comment);

        final double finalPrice = Math.round(price);

        txt_product_price.setText(new StringBuilder("Rp.").append(finalPrice));

        builder.setNegativeButton("CONFIRM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                dialog.dismiss();

                try {
                    Cart cartItem = new Cart();
                    cartItem.name = productList.get(position).Name;
                    cartItem.amount = Integer.parseInt(number);
                    cartItem.ice = Common.ice;
                    cartItem.sugar = Common.sugar;
                    cartItem.price = finalPrice;
                    cartItem.size = Common.sizeofCup;
                    cartItem.tambahExtra = txt_tambah_extra.getText().toString();
                    cartItem.link = productList.get(position).Link;

                    Common.cartRepository.insertToCart(cartItem);

                    Log.d("PSBO_DEBUG", new Gson().toJson(cartItem));

                    Toast.makeText(context, "Save item to cart success", Toast.LENGTH_SHORT).show();
                }
                catch (Exception ex)
                {
                    Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        builder.setView(itemView);
        builder.show();
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
