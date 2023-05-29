package com.infinity.movies.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
@Setter
public class AuthorityModel {

    @JsonProperty(value = "accountIds")
    private List<Long> accountIds;

    @JsonProperty(value = "name")
    private String name;
}
