package com.infinity.movies.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
@Entity
@Getter
@Setter
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genre")
    private Long id;

    @Nullable
    @JsonBackReference
    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies;

    @NotNull
    private String name;

    public Genre(String name) {
        this.name = name;
    }
}
