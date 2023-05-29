package com.infinity.movies.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
@Setter
public class ReviewModel {

    @JsonProperty(value = "movieId")
    private Long movieId;

    @JsonProperty(value = "accountId")
    private Long accountId;

    @JsonProperty(value = "comment")
    private String comment;

    @JsonProperty(value = "rating")
    private Float rating;
}
