package com.infinity.movies.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.infinity.movies.entity.Actor;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
@Setter
public class ActorModel {

    @JsonProperty(value = "countryId")
    private Long countryId;

    @JsonProperty(value = "birth")
    private String birth;

    @JsonProperty(value = "image")
    private byte[] image;

    @JsonProperty(value = "surname")
    private String surname;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "patronymic")
    private String patronymic;

    @JsonProperty(value = "gender")
    private Actor.Gender gender;
}
