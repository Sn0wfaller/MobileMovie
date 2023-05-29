package com.infinity.movies.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
@Setter
public class StudioModel {

    @JsonProperty(value = "name")
    private String name;
}
