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
public class FavouriteModel {

    @JsonProperty(value = "accountId")
    private Long accountId;

    @JsonProperty(value = "movieId")
    private Long movieId;
}
