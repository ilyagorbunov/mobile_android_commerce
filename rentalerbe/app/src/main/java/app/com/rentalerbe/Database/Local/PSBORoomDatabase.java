package app.com.rentalerbe.Database.Local;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import app.com.rentalerbe.Database.ModelDB.Cart;
import app.com.rentalerbe.Database.ModelDB.Favorite;

@Database(entities = {Cart.class, Favorite.class},version = 1)
public abstract class PSBORoomDatabase extends RoomDatabase {

    public abstract CartDAO cartDAO();
    public abstract FavoriteDAO favoriteDAO();

    private static PSBORoomDatabase instance;

    public static PSBORoomDatabase getInstance(Context context)
    {
        if (instance == null)
            instance = Room.databaseBuilder(context,PSBORoomDatabase.class, "PSBO_ShopDB")
                    .allowMainThreadQueries()
                    .build();
        return instance;
    }
}
