package app.com.rentalerbe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

import app.com.rentalerbe.Adapter.ProductAdapter;
import app.com.rentalerbe.Model.Product;
import app.com.rentalerbe.Retrofit.API;
import app.com.rentalerbe.Utils.Common;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ProductActivity extends AppCompatActivity {

    API mService;

    RecyclerView list_product;

    TextView txt_banner_name;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mService = Common.getAPI();

        list_product = (RecyclerView)findViewById(R.id.recycler_products);
        list_product.setLayoutManager(new GridLayoutManager(this, 2));
        list_product.setHasFixedSize(true);

        txt_banner_name = (TextView)findViewById(R.id.txt_menu_name);
        txt_banner_name.setText(Common.currentCategory.Name);

        loadListProduct(Common.currentCategory.ID);
    }

    private void loadListProduct(String menuId) {
        compositeDisposable.add(mService.getProductByMenuID(menuId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<Product>>() {
            @Override
            public void accept(List<Product> products) throws Exception {
                displayProductList(products);
            }
        }));
    }

    private void displayProductList(List<Product> products) {
        ProductAdapter adapter = new ProductAdapter(this, products);
        list_product.setAdapter(adapter);
    }
}
