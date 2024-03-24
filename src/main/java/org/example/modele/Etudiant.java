package org.example.modele;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@NoArgsConstructor
@ToString
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @ToString.Exclude
    private Cours cours;

    private String nomEtudiant;

    public Long getId() {
        return id;
    }

    public Etudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }
}
