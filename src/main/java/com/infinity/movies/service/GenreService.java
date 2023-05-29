package com.infinity.movies.service;

import com.infinity.movies.entity.Genre;
import com.infinity.movies.model.GenreModel;

public interface GenreService {

    Genre getGenreById(Long id);

    Iterable<Genre> getGenres();

    Genre addGenre(GenreModel genreModel);

    Genre updateGenre(Long id, GenreModel genreModel);

    void deleteById(Long id);
}
