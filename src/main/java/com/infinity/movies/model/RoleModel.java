package com.infinity.movies.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
@Setter
public class RoleModel {

    @JsonProperty(value = "actorId")
    private Long actorId;

    @JsonProperty(value = "movieId")
    private Long movieId;

    @JsonProperty(value = "name")
    private String name;
}
