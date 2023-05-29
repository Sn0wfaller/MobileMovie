package com.infinity.movies.serviceimpl;

import com.infinity.movies.entity.Country;
import com.infinity.movies.entity.Director;
import com.infinity.movies.exception.ResourceNotFoundException;
import com.infinity.movies.model.DirectorModel;
import com.infinity.movies.repository.CountryRepository;
import com.infinity.movies.repository.DirectorRepository;
import com.infinity.movies.service.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DirectorServiceImpl implements DirectorService {


    private final DirectorRepository directorRepository;
    private final CountryRepository countryRepository;

    @Override
    public Director getDirectorById(Long id) {

        return directorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Режиссера с id =" + id + " не существует."));
    }

    @Override
    public Iterable<Director> getDirectors() {

        return directorRepository.findAll();
    }

    @Override
    public Director addDirector(DirectorModel directorModel) {

        Country country = countryRepository.findById(directorModel.getCountryId())
                .orElseThrow(() -> new ResourceNotFoundException("Страны с id =" + directorModel.getCountryId() + " не существует."));

        Director director = Director.builder()
                .gender(directorModel.getGender())
                .country(country)
                .birth(directorModel.getBirth())
                .surname(directorModel.getSurname())
                .name(directorModel.getName())
                .patronymic(directorModel.getPatronymic())
                .build();

        return directorRepository.save(director);
    }

    @Override
    public Director updateDirector(Long id, DirectorModel directorModel) {

        if (!directorRepository.existsById(id)){
            throw new ResourceNotFoundException("Режиссера с id = " + id + " не существует.");
        }

        Country country = countryRepository.findById(directorModel.getCountryId())
                .orElseThrow(() -> new ResourceNotFoundException("Страны с id =" + directorModel.getCountryId() + " не существует."));

        Director director = new Director(id, directorModel.getGender(), country, directorModel.getImage(), directorModel.getBirth(),
                directorModel.getSurname(), directorModel.getName(), directorModel.getPatronymic());

        return directorRepository.save(director);
    }

    @Override
    public void deleteById(Long id) {

        directorRepository.deleteById(id);
    }
}
