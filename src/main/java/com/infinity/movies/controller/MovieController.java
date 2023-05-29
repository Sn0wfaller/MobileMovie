package com.infinity.movies.controller;


import com.infinity.movies.dto.PageDto;
import com.infinity.movies.entity.Movie;
import com.infinity.movies.model.MovieModel;
import com.infinity.movies.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


                                                                                                                                    @Controller
                                                                                                                                    @AllArgsConstructor
                                                                                                                                    @RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Movie>> getMovies(PageDto pageDto){
        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovies(@RequestBody MovieModel movieModel)
    {
        return new ResponseEntity<>(movieService.addMovie(movieModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovies(@PathVariable Long id, @RequestBody MovieModel movieModel)
    {
        return new ResponseEntity<>(movieService.updateMovie(id, movieModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Long id)
    {
        movieService.deleteById(id);
    }
}
