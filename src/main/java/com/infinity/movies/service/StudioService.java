package com.infinity.movies.service;


import com.infinity.movies.entity.Studio;
import com.infinity.movies.model.StudioModel;

public interface StudioService {

    Studio getStudioById(Long id);

    Iterable<Studio> getStudios();

    Studio addStudio(StudioModel studioModel);

    Studio updateStudio(Long id, StudioModel studioModel);

    void deleteById(Long id);
}
