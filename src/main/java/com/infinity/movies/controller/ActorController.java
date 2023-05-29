package com.infinity.movies.controller;

import com.infinity.movies.entity.Actor;
import com.infinity.movies.entity.Director;
import com.infinity.movies.model.ActorModel;
import com.infinity.movies.model.DirectorModel;
import com.infinity.movies.service.ActorService;
import com.infinity.movies.service.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable Long id) {
        return new ResponseEntity<>(actorService.getActorById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Actor>> getActors(){
        return new ResponseEntity<>(actorService.getActors(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Actor> addActor(@RequestBody ActorModel actorModel)
    {
        return new ResponseEntity<>(actorService.addActor(actorModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable Long id, @RequestBody ActorModel actorModel)
    {
        return new ResponseEntity<>(actorService.updateActor(id, actorModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Long id)
    {
        actorService.deleteById(id);
    }
}
