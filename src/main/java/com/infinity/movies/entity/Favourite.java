package com.infinity.movies.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Favourite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favourite")
    private Long id;

    @JoinColumn(name = "id_account")
    @ManyToOne
    private Account account;


    @JsonBackReference
    @JoinColumn(name = "id_movie")
    @ManyToOne
    private Movie movie;
}
