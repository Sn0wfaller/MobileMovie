package com.infinity.movies.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@Getter
@Setter
@Lazy
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private Long id;

    @JoinColumn(name = "id_country")
    @ManyToOne
    private Country country;

    @JoinColumn(name = "id_studio")
    @ManyToOne
    private Studio studio;

    @JoinColumn(name = "id_director")
    @ManyToOne
    private Director director;

    @Nullable
    private byte[] image;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_genre"))
    private List<Genre> genres;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "movie_favourite",
            joinColumns = @JoinColumn(name = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_favourite"))
    private List<Favourite> favourites;


    @NotNull
    private String name;

    @NotNull
    private Integer release;

    @NotNull
    private String duration;

    @NotNull
    private String description;
}
