package com.infinity.movies.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review")
    private Long id;

    @JoinColumn(name = "id_movie")
    @ManyToOne
    private Movie movie;

    @JoinColumn(name = "id_account")
    @ManyToOne
    private Account account;

    @NotNull
    private String comment;

    @NotNull
    private Float rating;
}
