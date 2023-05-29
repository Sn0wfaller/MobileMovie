package com.infinity.movies.repository;

import com.infinity.movies.entity.Genre;
import com.infinity.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "select distinct m.* from Movie m cross join Genre g where g.name in ?1", nativeQuery = true)
    List<Movie> findMoviesByGenresIn(List<String> genres);

    List<Movie> findMoviesByActor(String actor);

    List<Movie> findMoviesByRelease(Integer release);

    List<Movie> findMoviesByStudio(String studio);
}
