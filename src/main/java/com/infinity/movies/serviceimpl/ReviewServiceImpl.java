package com.infinity.movies.serviceimpl;
import com.infinity.movies.entity.Account;
import com.infinity.movies.entity.Favourite;
import com.infinity.movies.entity.Movie;
import com.infinity.movies.entity.Review;
import com.infinity.movies.exception.ResourceNotFoundException;
import com.infinity.movies.model.ReviewModel;
import com.infinity.movies.repository.AccountRepository;
import com.infinity.movies.repository.MovieRepository;
import com.infinity.movies.repository.ReviewRepository;
import com.infinity.movies.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final AccountRepository accountRepository;


    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Рецензии с id =" + id + " не существует."));
    }

    @Override
    public Iterable<Review> getReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review addReview(ReviewModel reviewModel) {

        Account account = accountRepository.findById(reviewModel.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Пользователя с id =" + reviewModel.getAccountId() + " не существует."));

        Movie movie = movieRepository.findById(reviewModel.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException("Фильма с id =" + reviewModel.getMovieId() + " не существует."));

        Review review = Review.builder()
                .account(account)
                .movie(movie)
                .comment(reviewModel.getComment())
                .rating(reviewModel.getRating())
                .build();

        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, ReviewModel reviewModel) {

        if (!reviewRepository.existsById(id)){
            throw new ResourceNotFoundException("Рецензии с id = " + id + " не существует.");
        }

        Account account = accountRepository.findById(reviewModel.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Пользователя с id =" + reviewModel.getAccountId() + " не существует."));

        Movie movie = movieRepository.findById(reviewModel.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException("Фильма с id =" + reviewModel.getMovieId() + " не существует."));

        Review review = new Review(id, movie, account, reviewModel.getComment(), reviewModel.getRating());

        return reviewRepository.save(review);
    }

    @Override
    public void deleteById(Long id) {

        reviewRepository.deleteById(id);
    }
}
