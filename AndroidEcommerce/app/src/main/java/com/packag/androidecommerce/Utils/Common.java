package com.packag.androidecommerce.Utils;

import com.packag.androidecommerce.Model.Category;
import com.packag.androidecommerce.Model.Drink;
import com.packag.androidecommerce.Model.User;
import com.packag.androidecommerce.Retrofit.IDrinkShopAPI;
import com.packag.androidecommerce.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

public class Common {
    //config ip
    private static final String BASE_URL = "http://10.1.206.208/shop_jamu/";

    public static final String TOPPING_MENU_ID = "7";

    public static User currentUser = null;
    public static Category currentCategory = null;

    public static List<Drink> toppingList = new ArrayList<>();

    public static double toppingPrice = 0.0;
    public static List<String> toppingAdded = new ArrayList<>();

    public static IDrinkShopAPI getAPI()
    {
        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);

    }
}
