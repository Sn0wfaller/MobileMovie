package com.infinity.movies.controller;

import com.infinity.movies.dto.PageDto;
import com.infinity.movies.entity.Genre;
import com.infinity.movies.entity.Movie;
import com.infinity.movies.model.GenreModel;
import com.infinity.movies.model.MovieModel;
import com.infinity.movies.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<Iterable<Genre>> getGenres(PageDto pageDto){
        return new ResponseEntity<>(genreService.getGenres(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Genre> addGenre(@RequestBody GenreModel genreModel)
    {
        return new ResponseEntity<>(genreService.addGenre(genreModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody GenreModel genreModel)
    {
        return new ResponseEntity<>(genreService.updateGenre(id, genreModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Long id)
    {
        genreService.deleteById(id);
    }
}
