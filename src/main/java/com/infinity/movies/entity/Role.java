package com.infinity.movies.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long id;

    @JoinColumn(name = "id_actor")
    @ManyToOne
    private Actor actor;

    @JoinColumn(name = "id_movie")
    @ManyToOne
    private Movie movie;

    @NotNull
    private String name;
}
