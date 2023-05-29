package com.infinity.movies.service;

import com.infinity.movies.entity.Movie;

import java.util.List;

public interface MovieRecommendationService {

    List<Movie> getMovieRecommendations(Long userId);
}
