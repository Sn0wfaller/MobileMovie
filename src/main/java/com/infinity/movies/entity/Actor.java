package com.infinity.movies.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@Getter
@Setter
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actor")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @JoinColumn(name = "id_country")
    @ManyToOne
    private Country country;

    @NotNull
    private String birth;

    @NotNull
    private String surname;

    @Nullable
    private byte[] image;

    @NotNull
    private String name;

    @Nullable
    private String patronymic;

    public enum Gender {
        Мужской,
        Женский
    }
}
