package com.infinity.movies.service;


import com.infinity.movies.entity.Movie;
import com.infinity.movies.model.MovieModel;

public interface MovieService {

    Movie getMovieById(Long id);

    Iterable<Movie> getMovies();

    Movie addMovie(MovieModel movieModel);

    Movie updateMovie(Long id, MovieModel movieModel);

    void deleteById(Long id);
}
