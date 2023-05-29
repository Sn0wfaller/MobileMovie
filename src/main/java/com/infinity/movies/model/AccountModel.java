package com.infinity.movies.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
@Setter
public class AccountModel {

    @JsonProperty(value = "authoritiesIds")
    private List<Long> authoritiesIds;

    @JsonProperty(value = "username")
    private String username;

    @JsonProperty(value = "password")
    private String password;
}
