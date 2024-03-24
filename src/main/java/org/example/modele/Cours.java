package org.example.modele;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@NoArgsConstructor
@ToString
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nomCours;

    @ManyToOne
    @ToString.Exclude
    private Prof prof;

    @OneToMany(mappedBy = "cours", cascade = CascadeType.PERSIST)
    private Set<Etudiant> etudiants = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Cours(String nomCours, Prof prof) {
        this.nomCours = nomCours;
        this.prof = prof;
    }

    public void addEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        etudiant.setCours(this);
    }
}
