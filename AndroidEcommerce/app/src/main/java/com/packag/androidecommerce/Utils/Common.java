package com.packag.androidecommerce.Utils;

import com.packag.androidecommerce.Model.User;
import com.packag.androidecommerce.Retrofit.IDrinkShopAPI;
import com.packag.androidecommerce.Retrofit.RetrofitClient;

public class Common {
    //config ip
    private static final String BASE_URL = "http://192.168.1.9/shop_jamu/";

    public static User currentUser = null;

    public static IDrinkShopAPI getAPI()
    {
        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);

    }
}
