package com.infinity.movies.serviceimpl;

import com.infinity.movies.entity.*;
import com.infinity.movies.exception.ResourceNotFoundException;
import com.infinity.movies.model.MovieModel;
import com.infinity.movies.repository.*;
import com.infinity.movies.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final CountryRepository countryRepository;
    private final StudioRepository studioRepository;
    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final FavouriteRepository favouriteRepository;

    @Override
    public Movie getMovieById(Long id) {

        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Фильма с id =" + id + " не существует."));
    }

    @Override
    public Iterable<Movie> getMovies() {

        return movieRepository.findAll();
    }

    @Override
    public Movie addMovie(MovieModel movieModel) {

        Country country = countryRepository.findById(movieModel.getCountryId())
                .orElseThrow(() -> new ResourceNotFoundException("Страны с id =" + movieModel.getCountryId() + " не существует."));

        Studio studio = studioRepository.findById(movieModel.getStudioId())
                .orElseThrow(() -> new ResourceNotFoundException("Студии с id =" + movieModel.getCountryId() + " не существует."));

        Director director = directorRepository.findById(movieModel.getDirectorId())
                .orElseThrow(() -> new ResourceNotFoundException("Режиссера с id =" + movieModel.getDirectorId() + " не существует."));

        List<Genre> genresList = new ArrayList<>();
        for (Long genreId: movieModel.getGenreIds()) {

            Genre genre = genreRepository.findById(genreId)
                    .orElseThrow(() -> new ResourceNotFoundException("Жанра с id =" + genreId + " не существует."));
            genresList.add(genre);
        }

        Movie movie = Movie.builder()
                .country(country)
                .studio(studio)
                .director(director)
                .name(movieModel.getName())
                .release(movieModel.getRelease())
                .duration(movieModel.getDuration())
                .description(movieModel.getDescription())
                .genres(genresList)
                .build();

        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Long id, MovieModel movieModel) {

        if (!movieRepository.existsById(id)){
            throw new ResourceNotFoundException("Фильма с id = " + id + " не существует.");
        }

        Country country = countryRepository.findById(movieModel.getCountryId())
                .orElseThrow(() -> new ResourceNotFoundException("Страны с id =" + movieModel.getCountryId() + " не существует."));

        Studio studio = studioRepository.findById(movieModel.getStudioId())
                .orElseThrow(() -> new ResourceNotFoundException("Студии с id =" + movieModel.getCountryId() + " не существует."));

        Director director = directorRepository.findById(movieModel.getDirectorId())
                .orElseThrow(() -> new ResourceNotFoundException("Режиссера с id =" + movieModel.getCountryId() + " не существует."));


        List<Genre> genresList = new ArrayList<>();
        for (Long genreId: movieModel.getGenreIds()) {

            Genre genre = genreRepository.findById(genreId)
                    .orElseThrow(() -> new ResourceNotFoundException("Жанра с id =" + genreId + " не существует."));
            genresList.add(genre);
        }

        List<Favourite> favouritesList = new ArrayList<>();
        for (Long favouriteId: movieModel.getFavouriteIds()) {

            Favourite favourite = favouriteRepository.findById(favouriteId)
                    .orElseThrow(() -> new ResourceNotFoundException("Избранного с id =" + favouriteId + " не существует."));
            favouritesList.add(favourite);
        }

        Movie movie = new Movie(id, country, studio, director, movieModel.getImage(), genresList, favouritesList, movieModel.getName(),
                movieModel.getRelease(), movieModel.getDuration(), movieModel.getDescription());


        return movieRepository.save(movie);
    }

    @Override
    public void deleteById(Long id) {

        movieRepository.deleteById(id);
    }
}
