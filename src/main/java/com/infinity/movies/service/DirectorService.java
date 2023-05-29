package com.infinity.movies.service;


import com.infinity.movies.entity.Director;
import com.infinity.movies.model.DirectorModel;

public interface DirectorService {

    Director getDirectorById(Long id);

    Iterable<Director> getDirectors();

    Director addDirector(DirectorModel directorModel);

    Director updateDirector(Long id, DirectorModel directorModel);

    void deleteById(Long id);
}
