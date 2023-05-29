package com.infinity.movies.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
@Setter
public class GenreModel {

    @JsonProperty(value = "movieIds")
    private List<Long> movieIds;

    @JsonProperty(value = "name")
    private String name;
}
