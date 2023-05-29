package com.infinity.movies.controller;

import com.infinity.movies.dto.PageDto;
import com.infinity.movies.entity.Director;
import com.infinity.movies.entity.Movie;
import com.infinity.movies.entity.Review;
import com.infinity.movies.entity.Studio;
import com.infinity.movies.model.DirectorModel;
import com.infinity.movies.model.MovieModel;
import com.infinity.movies.model.ReviewModel;
import com.infinity.movies.model.StudioModel;
import com.infinity.movies.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody ReviewModel reviewModel)
    {
        return new ResponseEntity<>(reviewService.addReview(reviewModel), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        return new ResponseEntity<>(reviewService.getReviewById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Review>> getReviews(PageDto pageDto){
        return new ResponseEntity<>(reviewService.getReviews(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody ReviewModel reviewModel)
    {
        return new ResponseEntity<>(reviewService.updateReview(id, reviewModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Long id)
    {
        reviewService.deleteById(id);
    }
}
