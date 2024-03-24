package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {
        // Startup
        TCP_Server.createTcpServer();

//        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("intra");
//        final EcoleService ecoleService = new EcoleService(new EcoleRepositoryJpa(emf));
//
//
//        // Runtime
//        Prof prof = new Prof("Nicolas");
//        Cours cours = new Cours("Math", prof);
//        cours.addEtudiant(new Etudiant("Angel"));
//        cours.addEtudiant(new Etudiant("Victoria"));
//        cours.addEtudiant(new Etudiant("Sensini"));
//
//        prof.addCours(cours);
//
//        ecoleService.createProf(prof);
//
//        Prof prof2 = ecoleService.findProf("Nicolas");
//        System.out.println(prof2);
//
//        Thread.currentThread().join();

    }
}