package com.infinity.movies.entity;


import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
@Entity
@Getter
@Setter
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_director")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @JoinColumn(name = "id_country")
    @ManyToOne
    private Country country;

    @Nullable
    private byte[] image;

    @NotNull
    private String birth;

    @NotNull
    private String surname;

    @NotNull
    private String name;

    @Nullable
    private String patronymic;

    public enum Gender {
        Мужской,
        Женский
    }
}
