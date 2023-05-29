package com.infinity.movies.repository;

import com.infinity.movies.entity.Favourite;
import com.infinity.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {

    @Query("select f.movie from Favourite f where f.account.username = ?1")
    List<Movie> findAllMovieByAccountName(String username);

    @Query("select f.movie from Favourite f where f.account.id = ?1")
    List<Movie> findAllMovieByAccountId(Long userId);
}
