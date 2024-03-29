package app.com.rentalerbe.Utils;

import java.util.ArrayList;
import java.util.List;

import app.com.rentalerbe.Database.DataSource.CartRepository;
import app.com.rentalerbe.Database.DataSource.FavoriteRepository;
import app.com.rentalerbe.Database.Local.PSBORoomDatabase;
import app.com.rentalerbe.Model.Category;
import app.com.rentalerbe.Model.Product;
import app.com.rentalerbe.Model.User;
import app.com.rentalerbe.Retrofit.API;
import app.com.rentalerbe.Retrofit.RetrofitClient;

public class Common {
    public static final String BASE_URL = "http://10.5.1.5/store_jamu/";

    public static final String TAMBAH_MENU_ID = "3";

    public static User currentUser = null;
    public static Category currentCategory = null;

    public static List<Product> tambahList = new ArrayList<>();

    public static double tambahPrice = 0.0;
    public static List<String> tambahAdded = new ArrayList<>();

    public static int sizeofCup = -1;
    public static int sugar = -1;
    public static int ice = -1;

    public static PSBORoomDatabase psboRoomDatabase;
    public static CartRepository cartRepository;
    public static FavoriteRepository favoriteRepository;

    public static API getAPI()
    {
        return RetrofitClient.getClient(BASE_URL).create(API.class);
    }
}
