package com.infinity.movies.service;


import com.infinity.movies.entity.Actor;
import com.infinity.movies.model.ActorModel;

public interface ActorService {

    Actor getActorById(Long id);

    Iterable<Actor> getActors();

    Actor addActor(ActorModel actorModel);

    Actor updateActor(Long id, ActorModel actorModel);

    void deleteById(Long id);
}
