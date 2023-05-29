package com.infinity.movies.controller;


import com.infinity.movies.entity.Account;
import com.infinity.movies.entity.Movie;
import com.infinity.movies.model.AccountModel;
import com.infinity.movies.model.MovieModel;
import com.infinity.movies.service.AccountService;
import com.infinity.movies.service.MovieRecommendationService;
import com.infinity.movies.serviceimpl.MovieRecommendationServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final MovieRecommendationServiceImpl movieRecommendationService;

    @GetMapping("/{username}")
    public ResponseEntity<String> getAuthorityByUsername(@PathVariable String username) {
        return new ResponseEntity<>(accountService.getMaxAuthorityByUsername(username), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody AccountModel accountModel)
    {
        return new ResponseEntity<>(accountService.updateUser(id, accountModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Long id)
    {
        accountService.deleteById(id);
    }

    @GetMapping("/{id}/recommendation")
    public ResponseEntity<List<Movie>> getMovieRecommendations(@PathVariable Long id) {

        return new ResponseEntity<>(movieRecommendationService.getMovieRecommendations(id), HttpStatus.OK);
    }
}
