package app.com.rentalerbe.Database.Local;

import app.com.rentalerbe.Database.DataSource.IFavoriteDataSource;
import app.com.rentalerbe.Database.ModelDB.Favorite;

import java.util.List;

import io.reactivex.Flowable;

public class FavoriteDataSource implements IFavoriteDataSource {

    private FavoriteDAO favoriteDAO;
    private static FavoriteDataSource instance;

    public FavoriteDataSource(FavoriteDAO favoriteDAO) {
        this.favoriteDAO = favoriteDAO;
    }

    public static FavoriteDataSource getInstance(FavoriteDAO favoriteDAO)
    {
        if(instance == null)
            instance = new FavoriteDataSource(favoriteDAO);
        return instance;
    }

    @Override
    public Flowable<List<Favorite>> getFavItem() {
        return favoriteDAO.getFavItem();
    }

    @Override
    public int isFavorite(int itemId) {
        return favoriteDAO.isFavorite(itemId);
    }

    @Override
    public void insertFav(Favorite... favorite) {
        favoriteDAO.insertFav(favorite);
    }

    @Override
    public void delete(Favorite favorite) {
        favoriteDAO.delete(favorite);
    }
}