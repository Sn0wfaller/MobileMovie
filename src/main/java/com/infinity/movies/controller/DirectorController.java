package com.infinity.movies.controller;


import com.infinity.movies.entity.Director;
import com.infinity.movies.model.DirectorModel;
import com.infinity.movies.service.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping("/director")
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id) {
        return new ResponseEntity<>(directorService.getDirectorById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Director>> getDirectors(){
        return new ResponseEntity<>(directorService.getDirectors(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Director> addDirector(@RequestBody DirectorModel directorModel)
    {
        return new ResponseEntity<>(directorService.addDirector(directorModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Director> updateDirector(@PathVariable Long id, @RequestBody DirectorModel directorModel)
    {
        return new ResponseEntity<>(directorService.updateDirector(id, directorModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Long id)
    {
        directorService.deleteById(id);
    }
}
