package com.infinity.movies.serviceimpl;

import com.infinity.movies.entity.Studio;
import com.infinity.movies.exception.ResourceNotFoundException;
import com.infinity.movies.model.StudioModel;
import com.infinity.movies.repository.StudioRepository;
import com.infinity.movies.service.StudioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudioServiceImpl implements StudioService {


    private final StudioRepository studioRepository;

    @Override
    public Studio getStudioById(Long id) {

        return studioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Студии с id =" + id + " не существует."));
    }

    @Override
    public Iterable<Studio> getStudios() {

        return studioRepository.findAll();
    }

    @Override
    public Studio addStudio(StudioModel studioModel) {

        Studio studio = studioRepository.findByName(studioModel.getName());

        if (studio == null){
            studio = new Studio(studioModel.getName());
            studioRepository.save(studio);
        }

        return studio;
    }

    @Override
    public Studio updateStudio(Long id, StudioModel studioModel) {

        if (!studioRepository.existsById(id)){
            throw new ResourceNotFoundException("Студии с id =" + id + " не существует.");
        }
        Studio studio = new Studio(id, studioModel.getName());

        return studioRepository.save(studio);
    }

    @Override
    public void deleteById(Long id) {

        studioRepository.deleteById(id);
    }
}
