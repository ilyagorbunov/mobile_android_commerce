package com.packag.androidecommerce.Utils;

import com.packag.androidecommerce.Retrofit.IDrinkShopAPI;
import com.packag.androidecommerce.Retrofit.RetrofitClient;

public class Common {
    //config ip
    private static final String BASE_URL = "http://localhost/shop/";

    public static IDrinkShopAPI getAPI()
    {
        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);

    }
}
