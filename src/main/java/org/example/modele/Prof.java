package org.example.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Prof {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nomProf;
    private LocalDate dateNaissance;

    @OneToMany(mappedBy = "prof", cascade = CascadeType.PERSIST)
    private Set<Cours> cours = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Prof(String nomProf) {
        this.nomProf = nomProf;
    }

    public void addCours(Cours unCour) {
        cours.add(unCour);
    }
}
