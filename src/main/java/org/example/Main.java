package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EcoleRepositoryJpa;
import org.example.modele.Cours;
import org.example.modele.Etudiant;
import org.example.modele.Prof;
import org.example.service.Service;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {
        // Startup
        TCP_Server.createTcpServer();

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("intra");
        final Service service = new Service(new EcoleRepositoryJpa(emf));


        // Runtime
        Prof prof = new Prof("Nicolas");
        Cours cours = new Cours("Math", prof);
        cours.addEtudiant(new Etudiant("Angel"));
        cours.addEtudiant(new Etudiant("Victoria"));
        cours.addEtudiant(new Etudiant("Sensini"));

        prof.addCours(cours);

        service.createProf(prof);

        Prof prof2 = service.findProf("Nicolas");
        System.out.println(prof2);

        Thread.currentThread().join();

    }
}