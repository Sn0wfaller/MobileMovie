package com.infinity.movies.serviceimpl;
import com.infinity.movies.entity.Genre;
import com.infinity.movies.entity.Movie;
import com.infinity.movies.repository.FavouriteRepository;
import com.infinity.movies.repository.MovieRepository;
import com.infinity.movies.service.MovieRecommendationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieRecommendationServiceImpl implements MovieRecommendationService {

    private final MovieRepository movieRepository;
    private final FavouriteRepository favouriteRepository;
    public List<Movie> getMovieRecommendations(Long userId) {

        List<Movie> favouriteMovies = favouriteRepository.findAllMovieByAccountId(userId);
        List<Movie> recommendedMovies = movieRepository.findMoviesByGenresIn(getGenresFromFavoriteMovies(favouriteMovies));

        recommendedMovies.removeIf(movie -> favouriteMovies.contains(movie.getName()));

        return recommendedMovies;
    }

    private List<String> getGenresFromFavoriteMovies(List<Movie> favoriteMovies) {
        List<Genre> genres = new ArrayList<>();
        List<String> genresList = new ArrayList<>();

        for (Movie movie : favoriteMovies) {
            if (movie != null) {
                genres.addAll(movie.getGenres());
            }
        }
        for (Genre genre : genres) {
            if (genre != null) {
                genresList.add(genre.getName());
            }
        }
        return genresList;
    }
}
