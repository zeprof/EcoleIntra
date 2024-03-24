package org.example.service;

import org.example.dao.CoursRepository;
import org.example.dao.EtudiantRepository;
import org.example.dao.ProfRepository;
import org.example.modele.Prof;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EcoleService {

    private final CoursRepository coursRepository;
    private final EtudiantRepository etudiantRepository;
    private final ProfRepository profRepository;

    public EcoleService(CoursRepository coursRepository, EtudiantRepository etudiantRepository, ProfRepository profRepository) {
        this.coursRepository = coursRepository;
        this.etudiantRepository = etudiantRepository;
        this.profRepository = profRepository;
    }


    public Prof createProf(Prof prof) {
        Objects.requireNonNull(prof);
        return profRepository.save(prof);
    }

    public Prof findProf(String prof) {
        Objects.requireNonNull(prof);
        return profRepository.findByNomProf(prof)
                .orElse(null);
    }
}
