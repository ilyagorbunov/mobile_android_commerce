package com.packag.androidecommerce.Utils;

import com.packag.androidecommerce.Database.DataSource.CartRepository;
import com.packag.androidecommerce.Database.Local.CartDatabase;
import com.packag.androidecommerce.Model.Category;
import com.packag.androidecommerce.Model.Drink;
import com.packag.androidecommerce.Model.User;
import com.packag.androidecommerce.Retrofit.IDrinkShopAPI;
import com.packag.androidecommerce.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

public class Common {
    //config ip
    public static final String BASE_URL = "http://10.1.206.208/shop_jamu/";

    public static final String TOPPING_MENU_ID = "7";

    public static User currentUser = null;
    public static Category currentCategory = null;

    public static List<Drink> toppingList = new ArrayList<>();

    public static double toppingPrice = 0.0;
    public static List<String> toppingAdded = new ArrayList<>();

    // Hold Field
    public static int sizeOfCup = -1;// -1: number choose (error) ,0:M,1:L
    public static int sugar = -1;// -1 : No choose(Error)
    public static int ice = -1;

    //Database
    public static CartDatabase cartDatabase;
    public static CartRepository cartRepository;

    public static IDrinkShopAPI getAPI()
    {
        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);

    }
}
