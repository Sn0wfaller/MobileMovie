package com.infinity.movies.serviceimpl;

import com.infinity.movies.entity.*;
import com.infinity.movies.exception.ResourceNotFoundException;
import com.infinity.movies.model.ActorModel;
import com.infinity.movies.repository.*;
import com.infinity.movies.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;
    private final CountryRepository countryRepository;

    @Override
    public Actor getActorById(Long id) {

        return actorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Актера с id =" + id + " не существует."));
    }

    @Override
    public Iterable<Actor> getActors() {

        return actorRepository.findAll();
    }

    @Override
    public Actor addActor(ActorModel actorModel) {

        Country country = countryRepository.findById(actorModel.getCountryId())
                .orElseThrow(() -> new ResourceNotFoundException("Страны с id =" + actorModel.getCountryId() + " не существует."));

        Actor actor = Actor.builder()
                .gender(actorModel.getGender())
                .country(country)
                .birth(actorModel.getBirth())
                .surname(actorModel.getSurname())
                .name(actorModel.getName())
                .patronymic(actorModel.getPatronymic())
                .build();

        return actorRepository.save(actor);
    }

    @Override
    public Actor updateActor(Long id, ActorModel actorModel) {

        if (!actorRepository.existsById(id)){
            throw new ResourceNotFoundException("Актера с id = " + id + " не существует.");
        }

        Country country = countryRepository.findById(actorModel.getCountryId())
                .orElseThrow(() -> new ResourceNotFoundException("Страны с id =" + actorModel.getCountryId() + " не существует."));

        Actor actor = new Actor(id, actorModel.getGender(), country, actorModel.getBirth(), actorModel.getSurname(),
                actorModel.getImage(), actorModel.getName(), actorModel.getPatronymic());

        return actorRepository.save(actor);
    }

    @Override
    public void deleteById(Long id) {

        actorRepository.deleteById(id);
    }
}
