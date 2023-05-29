package com.infinity.movies.serviceimpl;

import com.infinity.movies.entity.Account;
import com.infinity.movies.entity.Favourite;
import com.infinity.movies.entity.Movie;
import com.infinity.movies.exception.ResourceNotFoundException;
import com.infinity.movies.model.FavouriteModel;
import com.infinity.movies.repository.AccountRepository;
import com.infinity.movies.repository.FavouriteRepository;
import com.infinity.movies.repository.MovieRepository;
import com.infinity.movies.service.FavouriteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@AllArgsConstructor
public class FavouriteServiceImpl implements FavouriteService {


    private final FavouriteRepository favouriteRepository;
    private final MovieRepository movieRepository;
    private final AccountRepository accountRepository;


    @Override
    public Favourite getFavouriteById(Long id) {

        return favouriteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Избранного с id =" + id + " не существует."));

    }

    @Override
    public Iterable<Favourite> getFavourites() {

        return favouriteRepository.findAll();
    }

    @Override
    public List<Movie> getMoviesByAccountName(String username) {

        return favouriteRepository.findAllMovieByAccountName(username);
    }

    @Override
    public Favourite addFavourite(FavouriteModel favouriteModel) {

        Account account = accountRepository.findById(favouriteModel.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Пользователя с id =" + favouriteModel.getAccountId() + " не существует."));

        Movie movie = movieRepository.findById(favouriteModel.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException("Фильма с id =" + favouriteModel.getMovieId() + " не существует."));

        Favourite favourite = Favourite.builder()
                .account(account)
                .movie(movie)
                .build();

        return favouriteRepository.save(favourite);
    }

    @Override
    public Favourite updateFavourite(Long id, FavouriteModel favouriteModel) {

        if (!favouriteRepository.existsById(id)){
            throw new ResourceNotFoundException("Избранного с id = " + id + " не существует.");
        }

        Account account = accountRepository.findById(favouriteModel.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Пользователя с id =" + favouriteModel.getAccountId() + " не существует."));

        Movie movie = movieRepository.findById(favouriteModel.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException("Фильма с id =" + favouriteModel.getMovieId() + " не существует."));

        Favourite favourite = new Favourite(id, account, movie);

        return favouriteRepository.save(favourite);
    }

    @Override
    public void deleteById(Long id) {

        favouriteRepository.deleteById(id);
    }
}
