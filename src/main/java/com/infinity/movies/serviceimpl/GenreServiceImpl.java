package com.infinity.movies.serviceimpl;

import com.infinity.movies.entity.Genre;
import com.infinity.movies.entity.Movie;
import com.infinity.movies.exception.ResourceNotFoundException;
import com.infinity.movies.model.GenreModel;
import com.infinity.movies.repository.GenreRepository;
import com.infinity.movies.repository.MovieRepository;
import com.infinity.movies.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {


    private final GenreRepository genreRepository;
    private final MovieRepository movieRepository;

    @Override
    public Genre getGenreById(Long id) {

        return genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Жанра с id =" + id + " не существует."));
    }

    @Override
    public Iterable<Genre> getGenres() {

        return genreRepository.findAll();
    }

    @Override
    public Genre addGenre(GenreModel genreModel) {

        Genre genre = genreRepository.findGenreByName(genreModel.getName());

        if (genre == null){
            genre = new Genre(genreModel.getName());
            genreRepository.save(genre);
        }

        return genre;
    }

    @Override
    public Genre updateGenre(Long id, GenreModel genreModel) {

        if (!genreRepository.existsById(id)){
                throw new ResourceNotFoundException("Жанра с id =" + id + " не существует.");
        }

        List<Movie> movieList = new ArrayList<>();
        for (Long movieId: genreModel.getMovieIds()) {

            Movie movie = movieRepository.findById(movieId)
                    .orElseThrow(() -> new ResourceNotFoundException("Фильма с id =" + movieId + " не существует."));
            movieList.add(movie);
        }

        Genre genre = new Genre(id, movieList, genreModel.getName());

        genreRepository.save(genre);
        return genre;
    }

    @Override
    public void deleteById(Long id) {

        genreRepository.deleteById(id);
    }
}
