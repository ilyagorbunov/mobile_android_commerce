package app.com.rentalerbe.Database.DataSource;

import app.com.rentalerbe.Database.ModelDB.Favorite;

import java.util.List;

import io.reactivex.Flowable;


public interface IFavoriteDataSource {
    Flowable<List<Favorite>> getFavItem();

    int isFavorite(int itemId);

    void insertFav(Favorite... favorite);

    void delete(Favorite favorite);
}
