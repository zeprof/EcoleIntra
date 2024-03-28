package org.example;

import org.example.modele.Cours;
import org.example.modele.Etudiant;
import org.example.modele.Prof;
import org.example.service.EcoleService;
import org.example.service.dto.ProfDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcoleIntraSpringBootApplication implements CommandLineRunner{

    private final EcoleService ecoleService;

    public EcoleIntraSpringBootApplication(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }

    public static void main(String[] args) {
        SpringApplication.run(EcoleIntraSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Prof prof = new Prof("Nicolas");
        Cours cours = new Cours("Math", prof);
        cours.addEtudiant(new Etudiant("Angel"));
        cours.addEtudiant(new Etudiant("Victoria"));
        cours.addEtudiant(new Etudiant("Sensini"));

        prof.addCours(cours);

        ecoleService.createProf(prof);

        ProfDto prof2 = ecoleService.findProf("Nicolas");
        System.out.println(prof2);
    }
}
