package app.com.rentalerbe.Database.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import app.com.rentalerbe.Database.ModelDB.Favorite;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface FavoriteDAO {

    @Query("SELECT * FROM Favorite")
    Flowable<List<Favorite>> getFavItem();

    @Query("SELECT EXISTS (SELECT 1 FROM Favorite WHERE id=:itemId)")
    int isFavorite(int itemId);

    @Insert
    void insertFav(Favorite... favorite);

    @Delete
    void delete(Favorite favorite);
}
