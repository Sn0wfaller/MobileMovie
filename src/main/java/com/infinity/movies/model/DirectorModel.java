package com.infinity.movies.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.infinity.movies.entity.Director;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
@Setter
public class DirectorModel {

    @JsonProperty(value = "countryId")
    private Long countryId;

    @JsonProperty(value = "birth")
    private String birth;

    @JsonProperty(value = "surname")
    private String surname;

    @JsonProperty(value = "image")
    private byte[] image;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "patronymic")
    private String patronymic;

    @JsonProperty(value = "gender")
    private Director.Gender gender;
}
