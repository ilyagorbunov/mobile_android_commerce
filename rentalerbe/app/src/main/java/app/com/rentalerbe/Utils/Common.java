package app.com.rentalerbe.Utils;

import app.com.rentalerbe.Model.User;
import app.com.rentalerbe.Retrofit.API;
import app.com.rentalerbe.Retrofit.RetrofitClient;

public class Common {
    private static final String BASE_URL = "http://192.168.43.249/shop/";

    public static User currentUser = null;

    public static API getAPI()
    {
        return RetrofitClient.getClient(BASE_URL).create(API.class);
    }
}
