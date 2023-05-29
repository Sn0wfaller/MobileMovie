package com.infinity.movies.service;


import com.infinity.movies.entity.Favourite;
import com.infinity.movies.entity.Movie;
import com.infinity.movies.model.FavouriteModel;

import java.util.List;

public interface FavouriteService {

    Favourite getFavouriteById(Long id);

    Iterable<Favourite> getFavourites();

    List<Movie> getMoviesByAccountName(String username);

    Favourite addFavourite(FavouriteModel favouriteModel);

    Favourite updateFavourite(Long id, FavouriteModel favouriteModel);

    void deleteById(Long id);
}
