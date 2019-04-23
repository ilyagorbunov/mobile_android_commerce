package app.com.rentalerbe.Retrofit;

import app.com.rentalerbe.Model.Product;
import io.reactivex.Observable;

import java.util.List;

import app.com.rentalerbe.Model.Category;
import app.com.rentalerbe.Model.Banner;
import app.com.rentalerbe.Model.CheckUserResponse;
import app.com.rentalerbe.Model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {
    @FormUrlEncoded
    @POST("checkuser.php")
    Call<CheckUserResponse> checkUserExists(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("register.php")
    Call<User> registerNewUser(@Field("phone") String phone,
                               @Field("name") String name,
                               @Field("address") String address,
                               @Field("birthdate") String birthdate);

    @FormUrlEncoded
    @POST("getuser.php")
    Call<User> getUserInformation(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("getproduct.php")
    Observable<List<Product>> getProductByMenuID(@Field("menuid") String menuID);

    @GET("getbanner.php")
    Observable<List<Banner>> getBanners();

    @GET("getmenu.php")
    Observable<List<Category>> getMenu();
}
