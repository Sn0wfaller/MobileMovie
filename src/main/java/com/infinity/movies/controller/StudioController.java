package com.infinity.movies.controller;


import com.infinity.movies.dto.PageDto;
import com.infinity.movies.entity.Genre;
import com.infinity.movies.entity.Movie;
import com.infinity.movies.entity.Studio;
import com.infinity.movies.model.GenreModel;
import com.infinity.movies.model.StudioModel;
import com.infinity.movies.service.StudioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/studio")
public class StudioController {

    private final StudioService studioService;

    @GetMapping("/{id}")
    public ResponseEntity<Studio> getStudioById(@PathVariable Long id) {
        return new ResponseEntity<>(studioService.getStudioById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Studio>> getStudios(PageDto pageDto){
        return new ResponseEntity<>(studioService.getStudios(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Studio> addGenre(@RequestBody StudioModel studioModel)
    {
        return new ResponseEntity<>(studioService.addStudio(studioModel), HttpStatus.CREATED);
    }
}
