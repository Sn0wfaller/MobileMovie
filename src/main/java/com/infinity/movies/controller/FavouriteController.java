package com.infinity.movies.controller;

import com.infinity.movies.entity.Favourite;
import com.infinity.movies.entity.Movie;
import com.infinity.movies.model.FavouriteModel;
import com.infinity.movies.model.MovieModel;
import com.infinity.movies.repository.FavouriteRepository;
import com.infinity.movies.service.FavouriteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/favourite")
public class FavouriteController {

    private final FavouriteService favouriteService;

    @GetMapping("/{username}")
    public ResponseEntity<List<Movie>> getMoviesByUsername(@PathVariable String username) {
        return new ResponseEntity<>(favouriteService.getMoviesByAccountName(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Favourite> addFavourite(@RequestBody FavouriteModel favouriteModel)
    {
        return new ResponseEntity<>(favouriteService.addFavourite(favouriteModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Favourite> updateFavourite(@PathVariable Long id, @RequestBody FavouriteModel favouriteModel)
    {
        return new ResponseEntity<>(favouriteService.updateFavourite(id, favouriteModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Long id)
    {
        favouriteService.deleteById(id);
    }
}
