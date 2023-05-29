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
public class MovieModel {

    @JsonProperty(value = "countryId")
    private Long countryId;

    @JsonProperty(value = "studioId")
    private Long studioId;

    @JsonProperty(value = "directorId")
    private Long directorId;

    @JsonProperty(value = "image")
    private byte[] image;

    @JsonProperty(value = "genreIds")
    private List<Long> genreIds;

    @JsonProperty(value = "favouriteIds")
    private List<Long> favouriteIds;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "release")
    private Integer release;

    @JsonProperty(value = "duration")
    private String duration;

    @JsonProperty(value = "description")
    private String description;
}
