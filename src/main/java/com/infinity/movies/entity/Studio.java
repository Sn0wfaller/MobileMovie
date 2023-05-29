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
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_studio")
    private Long id;

    @NotNull
    private String name;

    public Studio(String name) {
        this.name = name;
    }
}
