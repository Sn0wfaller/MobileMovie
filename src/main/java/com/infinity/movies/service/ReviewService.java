package com.infinity.movies.service;

import com.infinity.movies.entity.Review;
import com.infinity.movies.model.ReviewModel;

public interface ReviewService {

    Review getReviewById(Long id);

    Iterable<Review> getReviews();

    Review addReview(ReviewModel reviewModel);

    Review updateReview(Long id, ReviewModel reviewModel);

    void deleteById(Long id);
}
